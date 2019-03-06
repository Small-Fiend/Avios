package io.ssau.team.Avios.dao;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TokenDao {
    private static final Map<String, String> tokens = new HashMap<>();

    @PostConstruct
    public void init() {
        tokens.put("123", "User");
        tokens.put("aaa", "Admin");
        tokens.put("0", "simple");
    }

    public boolean contains(String token) {
        return tokens.containsKey(token);
    }

    public String get(String token) {
        return tokens.get(token);
    }
}
