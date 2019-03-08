package io.ssau.team.Avios.service;

import io.ssau.team.Avios.dao.TokenDao;
import io.ssau.team.Avios.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    private TokenDao tokenDao;
    private UserDao userDao;

    @Autowired
    public AuthService(TokenDao tokenDao, UserDao userDao) {
        this.tokenDao = tokenDao;
        this.userDao = userDao;
    }

    public void authUser(String token, String username){
        if (userDao.contains(username)){
            throw  new ResponseStatusException(HttpStatus.CONFLICT, "username is already used");
        }
        tokenDao.create(token, username);

    }
}