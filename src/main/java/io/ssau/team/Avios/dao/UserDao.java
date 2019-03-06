package io.ssau.team.Avios.dao;

import io.ssau.team.Avios.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Repository
public class UserDao {

    private Set<User> users = new HashSet<>();

    @PostConstruct
    public void init(){
        users.add(new User(1, "User"));
        users.add(new User(2, "Admin"));
        users.add(new User(3, "simple"));
    }

    public boolean contains(String username) {
        return users.stream().findAny().filter(user-> Objects.equals(user.getUsername(), username)).isPresent();
    }

    public User get(String username) {
        return users.stream().findAny().filter(user-> Objects.equals(user.getUsername(), username)).orElse(null);
    }
}
