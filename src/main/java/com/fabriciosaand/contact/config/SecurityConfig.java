package com.fabriciosaand.contact.config;

import com.fabriciosaand.contact.service.AppUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@EnableWebSecurity
@Log4j2
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SuppressWarnings("java:S5344")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String PASSWORD = "123456";
    private final AppUserDetailsService appUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        var passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        log.info("Password encoded {}", passwordEncoder.encode(PASSWORD));

        auth.inMemoryAuthentication()
                .withUser("fabricio2")
                .password(passwordEncoder.encode("123456"))
                .roles("USER", "ADMIN")
                .and()
                .withUser("santiago2")
                .password(passwordEncoder.encode("123456"))
                .roles("USER");

        auth.userDetailsService(appUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }
}
