package com.myproject.springproject;

import com.myproject.springproject.controller.HelloController;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.sources(HelloController.class);
        return application.sources(SpringProjectApplication.class);
    }

}
