package com.myproject.springproject.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "api/v1/hello")
public class HelloController {
    @GetMapping(value = "/get")
    public String hello(){
        return "hello 222";
    }
}
