package com.anonymousv18.identity.mapper;

import com.anonymousv18.identity.dto.PermissionDTO;
import com.anonymousv18.identity.dto.RoleDTO;
import com.anonymousv18.identity.dto.UserDTO;
import com.anonymousv18.identity.dto.request.SignupRequest;
import com.anonymousv18.identity.entity.PermissionEntity;
import com.anonymousv18.identity.entity.RoleEntity;
import com.anonymousv18.identity.entity.UserEntity;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public UserDTO toDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.username( userEntity.getUsername() );
        userDTO.roles( roleEntitySetToRoleDTOSet( userEntity.getRoles() ) );

        return userDTO.build();
    }

    @Override
    public UserEntity toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userDTO.getId() );
        userEntity.setCreatedBy( userDTO.getCreatedBy() );
        userEntity.setCreatedDate( userDTO.getCreatedDate() );
        userEntity.setModifiedBy( userDTO.getModifiedBy() );
        userEntity.setModifiedDate( userDTO.getModifiedDate() );
        userEntity.setUsername( userDTO.getUsername() );
        userEntity.setPassword( userDTO.getPassword() );
        userEntity.setRoles( roleDTOSetToRoleEntitySet( userDTO.getRoles() ) );

        return userEntity;
    }

    @Override
    public UserEntity toEntity(SignupRequest signupRequest) {
        if ( signupRequest == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername( signupRequest.getUsername() );
        userEntity.setEmail( signupRequest.getEmail() );

        return userEntity;
    }

    protected PermissionDTO permissionEntityToPermissionDTO(PermissionEntity permissionEntity) {
        if ( permissionEntity == null ) {
            return null;
        }

        PermissionDTO.PermissionDTOBuilder permissionDTO = PermissionDTO.builder();

        permissionDTO.name( permissionEntity.getName() );
        permissionDTO.description( permissionEntity.getDescription() );

        return permissionDTO.build();
    }

    protected List<PermissionDTO> permissionEntitySetToPermissionDTOList(Set<PermissionEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<PermissionDTO> list = new ArrayList<PermissionDTO>( set.size() );
        for ( PermissionEntity permissionEntity : set ) {
            list.add( permissionEntityToPermissionDTO( permissionEntity ) );
        }

        return list;
    }

    protected RoleDTO roleEntityToRoleDTO(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        RoleDTO.RoleDTOBuilder roleDTO = RoleDTO.builder();

        roleDTO.name( roleEntity.getName() );
        roleDTO.code( roleEntity.getCode() );
        roleDTO.permissions( permissionEntitySetToPermissionDTOList( roleEntity.getPermissions() ) );

        return roleDTO.build();
    }

    protected Set<RoleDTO> roleEntitySetToRoleDTOSet(Set<RoleEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleDTO> set1 = new LinkedHashSet<RoleDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleEntity roleEntity : set ) {
            set1.add( roleEntityToRoleDTO( roleEntity ) );
        }

        return set1;
    }

    protected PermissionEntity permissionDTOToPermissionEntity(PermissionDTO permissionDTO) {
        if ( permissionDTO == null ) {
            return null;
        }

        PermissionEntity permissionEntity = new PermissionEntity();

        permissionEntity.setName( permissionDTO.getName() );
        permissionEntity.setDescription( permissionDTO.getDescription() );

        return permissionEntity;
    }

    protected Set<PermissionEntity> permissionDTOListToPermissionEntitySet(List<PermissionDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<PermissionEntity> set = new LinkedHashSet<PermissionEntity>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( PermissionDTO permissionDTO : list ) {
            set.add( permissionDTOToPermissionEntity( permissionDTO ) );
        }

        return set;
    }

    protected RoleEntity roleDTOToRoleEntity(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( roleDTO.getId() );
        roleEntity.setCreatedBy( roleDTO.getCreatedBy() );
        roleEntity.setCreatedDate( roleDTO.getCreatedDate() );
        roleEntity.setModifiedBy( roleDTO.getModifiedBy() );
        roleEntity.setModifiedDate( roleDTO.getModifiedDate() );
        roleEntity.setName( roleDTO.getName() );
        roleEntity.setCode( roleDTO.getCode() );
        roleEntity.setPermissions( permissionDTOListToPermissionEntitySet( roleDTO.getPermissions() ) );

        return roleEntity;
    }

    protected Set<RoleEntity> roleDTOSetToRoleEntitySet(Set<RoleDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleEntity> set1 = new LinkedHashSet<RoleEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleDTO roleDTO : set ) {
            set1.add( roleDTOToRoleEntity( roleDTO ) );
        }

        return set1;
    }
}
