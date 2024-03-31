package com.example.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class OAuthSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(requests -> {
                    requests.antMatchers("/", "/login").permitAll()
                            .anyRequest().authenticated();
                })
                .oauth2Login(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }

//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        ClientRegistration registration = this.googleClientRegistration();
//        return new InMemoryClientRegistrationRepository(registration);
//    }
//
//    private ClientRegistration googleClientRegistration() {
//        return ClientRegistration.withRegistrationId("google")
//                .clientId("312212422058-nf7rg9qq2l3t2lpp13ale94676d3sqd6.apps.googleusercontent.com")
//                .clientSecret("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")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .redirectUriTemplate("http://localhost:6066/login/oauth2/code/google")
//                .scope("profile", "email")
//                .authorizationUri("https://accounts.google.com/o/oauth2/auth")
//                .tokenUri("https://www.googleapis.com/oauth2/v3/token")
//                .userInfoUri("https://openidconnect.googleapis.com/v1/userinfo")
//                .userNameAttributeName("sub")
//                .clientName("Google")
//                .build();
//    }

}
