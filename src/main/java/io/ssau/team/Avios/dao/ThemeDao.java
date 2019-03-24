package io.ssau.team.Avios.dao;

import io.ssau.team.Avios.model.Theme;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ThemeDao {
    private static final List<Theme> themes = new ArrayList<>();

    @PostConstruct
    public void init() {
        themes.add(new Theme(1, "name1", "Comment1"));
        themes.add(new Theme(2, "name2", "Comment2"));
        themes.add(new Theme(3, "name3", "Comment3"));
    }

    public Theme create(Theme theme) {
        theme.setId(themes.size());
        themes.add(theme);
        return theme;
    }

    public List<Theme> getList(){
        return themes;
    }

    public Theme getById(int id) {
        return themes.get(id);
    }

    public int getSize(){
        return themes.size();
    }


}
