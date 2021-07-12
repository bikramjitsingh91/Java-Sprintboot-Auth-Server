package com.springlearn.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {

        //SpringApplication.run(DemoApplication.class, args);
        Samsung s7;
        s7.config();
    }

}
