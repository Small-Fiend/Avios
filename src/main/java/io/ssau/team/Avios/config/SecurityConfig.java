package io.ssau.team.Avios.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(authFilter(), AnonymousAuthenticationFilter.class)
                .csrf().disable();
    }

    private AbstractAuthenticationProcessingFilter authFilter() throws Exception {
        //here we define the interfaces which don't need any authorisation
        AuthFilter filter = new AuthFilter(new NegatedRequestMatcher(
                new AndRequestMatcher(
                        new AntPathRequestMatcher("/login"),
                        new AntPathRequestMatcher("/health")
                )
        ));
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }
}
