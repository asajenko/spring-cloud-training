package pl.training.shop;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

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
