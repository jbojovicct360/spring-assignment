package com.jovan_bojovic.spring_assignment.service;

import com.jovan_bojovic.spring_assignment.entity.Hello;
import com.jovan_bojovic.spring_assignment.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HelloServiceImplementation implements HelloService{

    @Autowired
    private HelloRepository repository;

    @Override
    public List<Hello> getAll() {
        return repository.findAll();
    }

    @Override
    public Hello findByLang(String lang) {
        return repository.findByLANG(lang);
    }
}
