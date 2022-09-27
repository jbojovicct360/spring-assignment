package com.jovan_bojovic.spring_assignment.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HelloRestControllerTest {

    @Test
    public void restHelloWorldTest() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/hello-rest/");
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        HttpEntity entity = response.getEntity();
        String responseEntity = EntityUtils.toString(entity, "UTF-8");
        assertEquals("Hello world!", responseEntity);
    }

}