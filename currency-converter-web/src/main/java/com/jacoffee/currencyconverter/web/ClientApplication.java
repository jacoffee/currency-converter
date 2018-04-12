package com.jacoffee.currencyconverter.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jacoffee.currencyconverter.web.*"})
public class ClientApplication  {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ClientApplication.class, args);
    }

}