package com.example.Hanuman.service;

import com.example.Hanuman.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.core.userdetails.UserDetailsResourceFactoryBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
/*spring badhu compile time e component ne pack
kare etle jo aa include no kare to userRepo null show kare and kai test thay nai
*/

public class UserEntryServiceTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUserName(){
        assertEquals(4,2+2);
        assertNotNull(userRepository.findByUserName("Ram"));
    }


}
