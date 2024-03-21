package com.awambeng.fullstackcrudapp.services;

import com.awambeng.fullstackcrudapp.dto.UserRegistrationDto;
import com.awambeng.fullstackcrudapp.models.Role;
import com.awambeng.fullstackcrudapp.models.User;
import com.awambeng.fullstackcrudapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(UserRegistrationDto userRegistrationDto) {
        UserServiceImpl n = new UserServiceImpl();
        User newUser = new User(null,userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(), n.enc(userRegistrationDto.getPassword()),
                List.of(new Role(null, "ROLE_USER")));
        return userRepository.save(newUser);
    }

    @Override
    public String enc(String pass) {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder(10);
        return b.encode(pass);
    }

    @Override
    public boolean compareHashPassword(String rawPassword, Long id) {
        User user = userRepository.findById(id).get();
        String hash = user.getPassword();
        BCryptPasswordEncoder b = new BCryptPasswordEncoder(10);
        boolean res = b.matches(rawPassword, hash);
        return res;
    }
}
