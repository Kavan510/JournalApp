package com.example.Hanuman.controller;


import com.example.Hanuman.Services.UserEntryService;
import com.example.Hanuman.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/public")

public class PublicController {


    @Autowired
    private UserEntryService userEntryService;


    @GetMapping("/health-check")
    public String healthCheck()
    {
        return "OK";
    }


    @PostMapping("/create")
    public boolean createUser(@RequestBody User user) {
        userEntryService.saveNewUser(user);
        return true;
    }


}
