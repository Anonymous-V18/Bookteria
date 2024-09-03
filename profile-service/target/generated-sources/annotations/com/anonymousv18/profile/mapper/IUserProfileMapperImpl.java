package com.anonymousv18.profile.mapper;

import com.anonymousv18.profile.dto.request.UserProfileCreationRequest;
import com.anonymousv18.profile.dto.response.UserProfileResponse;
import com.anonymousv18.profile.entity.UserProfileEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class IUserProfileMapperImpl implements IUserProfileMapper {

    @Override
    public UserProfileEntity toEntity(UserProfileCreationRequest userProfileCreationRequest) {
        if ( userProfileCreationRequest == null ) {
            return null;
        }

        UserProfileEntity.UserProfileEntityBuilder userProfileEntity = UserProfileEntity.builder();

        userProfileEntity.userId( userProfileCreationRequest.getUserId() );
        userProfileEntity.firstName( userProfileCreationRequest.getFirstName() );
        userProfileEntity.lastName( userProfileCreationRequest.getLastName() );
        userProfileEntity.dob( userProfileCreationRequest.getDob() );
        userProfileEntity.city( userProfileCreationRequest.getCity() );

        return userProfileEntity.build();
    }

    @Override
    public UserProfileResponse toUserProfileResponse(UserProfileEntity userProfileEntity) {
        if ( userProfileEntity == null ) {
            return null;
        }

        UserProfileResponse.UserProfileResponseBuilder userProfileResponse = UserProfileResponse.builder();

        userProfileResponse.id( userProfileEntity.getId() );
        userProfileResponse.firstName( userProfileEntity.getFirstName() );
        userProfileResponse.lastName( userProfileEntity.getLastName() );
        userProfileResponse.dob( userProfileEntity.getDob() );
        userProfileResponse.city( userProfileEntity.getCity() );

        return userProfileResponse.build();
    }
}
