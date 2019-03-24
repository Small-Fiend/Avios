package io.ssau.team.Avios.service;

import io.ssau.team.Avios.dao.ThemeDao;
import io.ssau.team.Avios.model.Theme;
import io.ssau.team.Avios.model.json.ThemeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
public class ThemeService {

    private ThemeDao themeDao;

    @Autowired
    public ThemeService(ThemeDao themeDao) { this.themeDao = themeDao; }

    public ThemeJson createTheme(ThemeJson themeJson) {
        Theme theme = themeDao.create(new Theme(themeJson));
        if (theme == null) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED);
        }
        return new ThemeJson(theme);
    }

    public ArrayList<Theme> indexTheme(ThemeDao themeList, int index) {
        ArrayList<Theme> list = new ArrayList<>();
        if(index == 0){
            list.add(themeList.getById(themeList.getSize() - 1));
        } else if(index == 1) {
            if(themeList.getSize() < 10){
                list.addAll(themeList.getList());
            } else {
                for(int i = themeList.getSize() - 1; i > themeList.getSize() - 11; i--){
                    list.add(themeList.getById(i));
                }
            }
        }
        return list;

    }


    /*
    public ThemeDao indexTheme(ThemeDao themeList){
        Theme list = themeDao.create().size();

    }
    */
}
