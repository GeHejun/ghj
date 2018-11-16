package com.ghj;



import com.ghj.dao.MyMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.ghj.dao"},markerInterface = MyMapper.class)
public class GhjServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GhjServiceApplication.class,args);
    }
}
