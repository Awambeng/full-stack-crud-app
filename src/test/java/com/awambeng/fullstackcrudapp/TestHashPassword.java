package com.awambeng.fullstackcrudapp;

import com.awambeng.fullstackcrudapp.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestHashPassword {
    private String pass;
    @Autowired
    private UserServiceImpl userService;
    @Test
    public void testHashPass(){
        TestHashPassword t1 = new TestHashPassword();
        userService.compareHashPassword("test", 1L);
    }
}
