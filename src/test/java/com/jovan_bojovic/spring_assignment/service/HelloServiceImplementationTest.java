package com.jovan_bojovic.spring_assignment.service;

import com.jovan_bojovic.spring_assignment.entity.Hello;
import com.jovan_bojovic.spring_assignment.repository.HelloRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HelloServiceImplementationTest {

    @InjectMocks
    private HelloService service = new HelloServiceImplementation();

    @Mock
    private HelloRepository repository;

    @Test
    void saveHello() {
        lenient().when(repository.save(new Hello("EN", "Hello world!"))).thenReturn(new Hello("EN", "Hello world!"));
        assertEquals(false, service.saveHello("EN", "Hello world!"));
    }
}