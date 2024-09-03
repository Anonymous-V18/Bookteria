package com.anonymousv18.identity.mapper;

import com.anonymousv18.identity.dto.PermissionDTO;
import com.anonymousv18.identity.entity.PermissionEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class IPermissionMapperImpl implements IPermissionMapper {

    @Override
    public PermissionDTO toDTO(PermissionEntity permissionEntity) {
        if ( permissionEntity == null ) {
            return null;
        }

        PermissionDTO.PermissionDTOBuilder permissionDTO = PermissionDTO.builder();

        permissionDTO.name( permissionEntity.getName() );
        permissionDTO.description( permissionEntity.getDescription() );

        return permissionDTO.build();
    }

    @Override
    public PermissionEntity toEntity(PermissionDTO permissionDTO) {
        if ( permissionDTO == null ) {
            return null;
        }

        PermissionEntity permissionEntity = new PermissionEntity();

        permissionEntity.setName( permissionDTO.getName() );
        permissionEntity.setDescription( permissionDTO.getDescription() );

        return permissionEntity;
    }
}
