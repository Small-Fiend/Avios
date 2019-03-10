package io.ssau.team.Avios.service;

import io.ssau.team.Avios.config.AuthProvider;
import io.ssau.team.Avios.dao.TokenDao;
import io.ssau.team.Avios.dao.UserDao;
import io.ssau.team.Avios.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class AuthService {

    private TokenDao tokenDao;
    private UserDao userDao;

    private AuthProvider authProvider;

    @Autowired
    public AuthService(TokenDao tokenDao, UserDao userDao, AuthProvider authProvider) {
        this.tokenDao = tokenDao;
        this.userDao = userDao;
        this.authProvider = authProvider;
    }

    public String registerUser(String username){
        if (userDao.contains(username)){
            throw  new ResponseStatusException(HttpStatus.CONFLICT, "username is already used");
        }
        String token = UUID.randomUUID().toString();
        User user = userDao.create(username);
        tokenDao.create(token, username);
        SecurityContextHolder.getContext().setAuthentication(authProvider.createAuthenticationToken(token, user));
        return token;
    }
}