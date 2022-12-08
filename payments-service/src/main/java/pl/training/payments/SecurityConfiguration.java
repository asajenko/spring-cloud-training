package pl.training.payments;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import pl.training.payments.commons.security.BaseSecurityConfiguration;

// https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
@KeycloakConfiguration
public class SecurityConfiguration extends BaseSecurityConfiguration {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().ignoringRequestMatchers(apiMatcher)
                .and()
                .authorizeRequests()
                .mvcMatchers("/**").hasRole("ADMIN");
    }


}
