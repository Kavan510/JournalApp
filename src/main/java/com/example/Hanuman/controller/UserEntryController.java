package com.example.Hanuman.controller;

import com.example.Hanuman.Services.UserEntryService;
import com.example.Hanuman.entity.User;
import com.example.Hanuman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // for REST apis
@RequestMapping("/user")
public class UserEntryController {

@Autowired
    private UserEntryService userEntryService;
@Autowired
private UserRepository userRepository;

//    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



@GetMapping
public List<User> getAllUsers(){

    return userEntryService.getAll();
}



@PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


    String name = authentication.getName();

        User tempUser = userEntryService.findByuserName(name);


            tempUser.setUserName(user.getUserName());

            tempUser.setPassword(user.getPassword());
            userEntryService.saveNewUser(tempUser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping
    public ResponseEntity<?>  deleteUserById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/greet")
    public ResponseEntity<?>  greetings(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>("Hi,.."+ authentication.getName(), HttpStatus.OK);
    }


}