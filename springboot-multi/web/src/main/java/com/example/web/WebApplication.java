package com.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class WebApplication
{
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "test success";
    }
}
