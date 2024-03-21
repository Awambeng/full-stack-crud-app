package com.awambeng.fullstackcrudapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegistrationDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

//    public void setPassword(String password, BCryptPasswordEncoder passwordEncoder) {
//        this.password = passwordEncoder.encode(password);
//    }
}
