package com.awambeng.fullstackcrudapp.services;

import com.awambeng.fullstackcrudapp.dto.UserRegistrationDto;
import com.awambeng.fullstackcrudapp.models.User;

public interface UserService {

    public User saveUser(UserRegistrationDto user);
    public String enc(String pass);

    public boolean compareHashPassword(String password, Long id);
}
