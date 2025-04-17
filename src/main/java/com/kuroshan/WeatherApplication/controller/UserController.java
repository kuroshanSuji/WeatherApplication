package com.kuroshan.WeatherApplication.controller;

import com.kuroshan.WeatherApplication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getWeather")
    public void getWeather(@RequestParam @Valid String location)
    {
       userService.getGeoLocation(location);
    }
}
