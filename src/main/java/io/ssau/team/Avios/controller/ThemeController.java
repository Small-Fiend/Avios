package io.ssau.team.Avios.controller;

import io.ssau.team.Avios.dao.ThemeDao;
import io.ssau.team.Avios.model.Theme;
import io.ssau.team.Avios.model.json.ThemeJson;
import io.ssau.team.Avios.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController("/theme")
public class ThemeController {

    private ThemeService themeService;
    private ThemeDao themeDao;

    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }


    @PostMapping()
    public ResponseEntity<ThemeJson> createTheme(@RequestBody ThemeJson theme) {
        return ResponseEntity.status(HttpStatus.CREATED).body(themeService.createTheme(theme));
    }

    @GetMapping("{id}")
    public ArrayList<Theme> AllTheme(@PathVariable("id") Integer id) {
        return this.themeService.indexTheme(themeDao, id);
    }
}