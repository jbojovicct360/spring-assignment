package com.jovan_bojovic.spring_assignment.service;

import com.jovan_bojovic.spring_assignment.entity.Hello;

import java.util.List;

public interface HelloService {

    List<Hello> getAll();

    Hello findByLang(String lang);

}
