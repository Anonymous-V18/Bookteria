package com.anonymousv18.identity.mapper;

import com.anonymousv18.identity.dto.request.ProfileCreationRequest;
import com.anonymousv18.identity.dto.request.SignupRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class IProfileMapperImpl implements IProfileMapper {

    @Override
    public ProfileCreationRequest toProfileCreationRequest(SignupRequest signupRequest) {
        if ( signupRequest == null ) {
            return null;
        }

        ProfileCreationRequest.ProfileCreationRequestBuilder profileCreationRequest = ProfileCreationRequest.builder();

        profileCreationRequest.firstName( signupRequest.getFirstName() );
        profileCreationRequest.lastName( signupRequest.getLastName() );
        profileCreationRequest.dob( signupRequest.getDob() );
        profileCreationRequest.city( signupRequest.getCity() );

        return profileCreationRequest.build();
    }
}
