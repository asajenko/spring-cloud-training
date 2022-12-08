package pl.training.shop.commons.security;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static pl.training.shop.commons.security.KeycloakToken.getAuthorizationHeader;

@Component
public class FeignTokenInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        getAuthorizationHeader()
                .ifPresent(headerValue -> requestTemplate.header(AUTHORIZATION, headerValue));
    }

}
