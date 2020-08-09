package com.example.generic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class GenericApplication {

    public static void main(String[] args) {
        Generic g= new Generic(123);
        Generic g2 = new Generic("123");

    }

}
