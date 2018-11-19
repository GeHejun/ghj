package com.ghj.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class GhjShiroApplication {
    public static void main(String[] args) {
        SpringApplication.run(GhjShiroApplication.class,args);
    }
}
