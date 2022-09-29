package com.jovan_bojovic.spring_assignment.service;

import com.jovan_bojovic.spring_assignment.entity.User;
import com.jovan_bojovic.spring_assignment.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplementationTest {

    @InjectMocks
    private UserService service = new UserServiceImplementation();

    @Mock
    private UserRepository repository;

    @Test
    void doLoginTest() {
        when(repository.findByUsernameAndPassword("admin", "admin")).thenReturn(new
                User.UserBuilder().setUsername("admin").setPassword("admin").build());
        assertEquals(true, service.doLogin("admin", "admin"));
    }

}