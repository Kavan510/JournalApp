package com.example.Hanuman.Services;

//includes business logic


import com.example.Hanuman.entity.User;
import com.example.Hanuman.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class UserEntryService {
    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserEntryService.class);

//final keyword km? to avoid accidental reassignment. ek j instance bane

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<User> getAll() {

        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void saveNewUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        userRepository.save(user);
    }

    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepository.save(user);
    }


    public User findByuserName(String userName){
        return userRepository.findByUserName(userName);
}
}
