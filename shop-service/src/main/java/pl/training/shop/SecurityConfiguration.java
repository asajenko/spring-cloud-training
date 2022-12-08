package pl.training.shop;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import pl.training.shop.commons.security.BaseSecurityConfiguration;

// https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
@KeycloakConfiguration
public class SecurityConfiguration extends BaseSecurityConfiguration {

    @Autowired
    private RequestMatcher apiMatcher;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().ignoringRequestMatchers(apiMatcher)
                .and()
                .authorizeRequests()
                .mvcMatchers("/**").hasRole("ADMIN")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/index.html");
    }

    /*

    // Aktywacja uwierzytelniania odbywa się przez zestaw filtrów web, albo aspekty nakładane na beany

    AuthenticationManager authenticationManager; // Abstrakcja odpowiadająca za proces uwierzytelnienia
        ProviderManager providerManager; // Implementuje AuthenticationManager, deleguje uwierzytelnienie do jednego ze skonfigurowanych AuthenticationProvider
            AuthenticationProvider authenticationProvider; // Fizycznie przeprowadza uwierzytelnienie np. DaoAuthenticationProvider, LdapAuthenticationProvide, OpenIDAuthenticationProvider
                DaoAuthenticationProvider daoAuthenticationProvider; // Ładuje dane za pomocą usługi UserDetailsService i porównuje z danymi przekazanymi w Authentication

    Authentication authentication; // Reprezentuje dane niezbędne do uwierzytelnienia, ale także status po uwierzytelnieniu
                                   // Implementowane np. przez UsernamePasswordAuthenticationToken

    UserDetails userDetails; // Reprezentuje użytkownika / konto

    GrantedAuthority grantedAuthority; // Reprezentuje uprawnienia / role

    SecurityContext securityContext; // Przechowuje Authentication zalogowanego użytkownika

    SecurityContextHolder securityContextHolder; // Przechowuje SecurityContext dla użytkownika (domyślna strategia ThreadLocal)

    PasswordEncoder passwordEncoder; // Abstrakcja obiektu umożliwiającego hashowanie i porównywanie haseł
        BCryptPasswordEncoder bCryptPasswordEncoder;

    AuthorizationManager authorizationManager; // Abstrakcja odpowiadająca za autoryzację dostępu, zwraca wynik autoryzacji typy AuthorizationDecision
        AuthorityAuthorizationManager authorityAuthorizationManager; // Implementacja oparta o role

    AccessDecisionManager decisionManager; (deprecated) // Abstrakcja odpowiadająca za autoryzację dostępu np. AffirmativeBased, ConsensusBased, UnanimousBased
                                           // Podejmuje decyzję na podstawie głosowania AccessDecisionVoter accessDecisionVoter

    */


}
