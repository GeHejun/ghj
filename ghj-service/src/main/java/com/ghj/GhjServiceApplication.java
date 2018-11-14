package com.ghj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(basePackages = {"com.ghj"})
public class GhjServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GhjServiceApplication.class,args);
    }
}
