package com.anonymousv18.identity.service.iml;

import com.anonymousv18.event.dto.NotificationEvent;
import com.anonymousv18.identity.dto.UserDTO;
import com.anonymousv18.identity.dto.request.ProfileCreationRequest;
import com.anonymousv18.identity.dto.request.SignupRequest;
import com.anonymousv18.identity.entity.RoleEntity;
import com.anonymousv18.identity.entity.UserEntity;
import com.anonymousv18.identity.exception.AppException;
import com.anonymousv18.identity.exception.ErrorCode;
import com.anonymousv18.identity.mapper.IProfileMapper;
import com.anonymousv18.identity.mapper.IUserMapper;
import com.anonymousv18.identity.repository.IRoleRepository;
import com.anonymousv18.identity.repository.IUserRepository;
import com.anonymousv18.identity.repository.httpclient.IProfileClient;
import com.anonymousv18.identity.service.IUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService implements IUserService {

    IUserRepository userRepository;
    PasswordEncoder passwordEncoder;
    IRoleRepository roleRepository;
    IUserMapper userMapper;
    IProfileClient profileClient;
    IProfileMapper profileMapper;
    KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public UserDTO createUser(SignupRequest signupRequest) {

        boolean isUserExist = userRepository.existsByUsername(signupRequest.getUsername());
        if (isUserExist) {
            throw new AppException(ErrorCode.USER_EXIST);
        }

        UserEntity userEntity = userMapper.toEntity(signupRequest);
        userEntity.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        RoleEntity roles = roleRepository.findOneByCode(signupRequest.getRole());
        userEntity.setRoles(Set.of(roles));

        userEntity = userRepository.save(userEntity);

        ProfileCreationRequest profileCreationRequest =
                profileMapper.toProfileCreationRequest(signupRequest);

        profileCreationRequest.setUserId(userEntity.getId());

        profileClient.createProfile(profileCreationRequest);

        NotificationEvent notificationEvent = NotificationEvent.builder()
                .channel("MAIL")
                .receiver(signupRequest.getEmail())
                .body("Hello + " + signupRequest.getUsername())
                .subject("Welcome to Anonymous-V18 bookstore !")
                .build();

        kafkaTemplate.send("notification-delivery", notificationEvent);
        
        return userMapper.toDTO(userEntity);
    }

    @Override
    public List<UserDTO> showAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDTO).toList();
    }
}
