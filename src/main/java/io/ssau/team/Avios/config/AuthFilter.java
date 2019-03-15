package io.ssau.team.Avios.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static io.ssau.team.Avios.param.Header.TOKEN;

public class AuthFilter extends AbstractAuthenticationProcessingFilter {

    AuthFilter(RequestMatcher requestMatcher) {
        super(requestMatcher);
        setAuthenticationSuccessHandler((request, response, authentication) ->
        {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            request.getRequestDispatcher(request.getServletPath()).forward(request, response);
        });
        setAuthenticationFailureHandler((request, response, authenticationException) ->
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authenticationException.getMessage()));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        final String tokenValue = request.getHeader(TOKEN);

        AuthenticationToken token = new AuthenticationToken(tokenValue);
        token.setDetails(authenticationDetailsSource.buildDetails(request));
        return this.getAuthenticationManager().authenticate(token);

    }
}