package com.ghj;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author gehj
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class GhjWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(GhjWebApplication.class,args);
    }

}
