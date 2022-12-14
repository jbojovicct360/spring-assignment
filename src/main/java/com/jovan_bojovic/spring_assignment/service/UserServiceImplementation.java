package com.jovan_bojovic.spring_assignment.service;

import com.jovan_bojovic.spring_assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean doLogin(String username, String password) {
        if(userRepository.findByUsernameAndPassword(username, password) == null)
            return false;
        return true;
    }
}
