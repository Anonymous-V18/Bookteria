package com.anonymousv18.gateway.repository;

import com.anonymousv18.gateway.dto.request.IntrospectRequest;
import com.anonymousv18.gateway.dto.response.ApiResponse;
import com.anonymousv18.gateway.dto.response.IntrospectResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

public interface IIdentityClient {

    @PostExchange(url = "/auth/introspect", contentType = MediaType.APPLICATION_JSON_VALUE)
    Mono<ApiResponse<IntrospectResponse>> introspect(@RequestBody IntrospectRequest request);

}
