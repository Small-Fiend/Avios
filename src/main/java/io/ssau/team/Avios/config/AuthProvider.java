package io.ssau.team.Avios.config;

import io.ssau.team.Avios.dao.TokenDao;
import io.ssau.team.Avios.dao.UserDao;
import io.ssau.team.Avios.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class AuthProvider implements AuthenticationProvider {

    private TokenDao tokenDao;
    private UserDao userDao;

    @Autowired
    public AuthProvider(TokenDao tokenDao, UserDao userDao) {
        this.tokenDao = tokenDao;
        this.userDao = userDao;
    }

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        final AuthenticationToken tokenContainer = (AuthenticationToken) auth;
        final String token = tokenContainer.getToken();

        if (!tokenDao.contains(token)) {
            throw new BadCredentialsException("Invalid token - " + token);
        }

        final String username = tokenDao.get(token);
        if (!userDao.contains(username)) {
            throw new BadCredentialsException("No user found for token - " + token);
        }

        final User user = userDao.get(username);

        return new AuthenticationToken(token, user);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return AuthenticationToken.class.isAssignableFrom(authentication);
    }
}