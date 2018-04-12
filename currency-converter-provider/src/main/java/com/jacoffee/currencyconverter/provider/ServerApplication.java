package com.jacoffee.currencyconverter.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jacoffee.currencyconverter.provider"})
public class ServerApplication {

  public static void main(String[] args) {
     SpringApplication.run(ServerApplication.class, args);
  }

}
