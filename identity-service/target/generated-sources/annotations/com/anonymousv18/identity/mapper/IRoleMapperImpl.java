package com.anonymousv18.identity.mapper;

import com.anonymousv18.identity.dto.PermissionDTO;
import com.anonymousv18.identity.dto.RoleDTO;
import com.anonymousv18.identity.dto.request.RoleRequest;
import com.anonymousv18.identity.entity.PermissionEntity;
import com.anonymousv18.identity.entity.RoleEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class IRoleMapperImpl implements IRoleMapper {

    @Override
    public RoleEntity toEntity(RoleRequest request) {
        if ( request == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setName( request.getName() );
        roleEntity.setCode( request.getCode() );

        return roleEntity;
    }

    @Override
    public RoleDTO toDTO(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        RoleDTO.RoleDTOBuilder roleDTO = RoleDTO.builder();

        roleDTO.name( roleEntity.getName() );
        roleDTO.code( roleEntity.getCode() );
        roleDTO.permissions( permissionEntitySetToPermissionDTOList( roleEntity.getPermissions() ) );

        return roleDTO.build();
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
}
