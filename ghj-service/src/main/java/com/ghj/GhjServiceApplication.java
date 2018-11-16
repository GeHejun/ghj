package com.ghj;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.ghj"})
public class GhjServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GhjServiceApplication.class,args);
    }
}
