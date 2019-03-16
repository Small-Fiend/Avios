package io.ssau.team.Avios.service;

import io.ssau.team.Avios.dao.ThemeDao;
import io.ssau.team.Avios.model.Theme;
import io.ssau.team.Avios.model.json.ThemeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ThemeService {

    private ThemeDao themeDao;

    @Autowired
    public ThemeService(ThemeDao themeDao) {
        this.themeDao = themeDao;
    }

    public ThemeJson createTheme(ThemeJson themeJson) {
        Theme theme = themeDao.create(new Theme(themeJson));
        if (theme == null) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED);
        }
        return new ThemeJson(theme);
    }
}
