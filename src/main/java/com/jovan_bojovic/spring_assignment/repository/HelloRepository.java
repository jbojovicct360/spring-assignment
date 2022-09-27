package com.jovan_bojovic.spring_assignment.repository;

import com.jovan_bojovic.spring_assignment.entity.Hello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends JpaRepository<Hello, Integer> {

    Hello findByLANG(String lang);

}
