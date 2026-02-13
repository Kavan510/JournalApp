package com.example.Hanuman.controller;


import com.example.Hanuman.Services.UserEntryService;
import com.example.Hanuman.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")

public class AdminController {


    @Autowired
    private UserEntryService userEntryService;


    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers(){
        List<User> all = userEntryService.getAll();

        if(all!=null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("create-admin-user")
    public void createUser(@RequestBody User user) {
        userEntryService.saveAdmin(user);
    }


}
