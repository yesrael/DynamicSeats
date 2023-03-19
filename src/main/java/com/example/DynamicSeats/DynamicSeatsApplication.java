package com.example.DynamicSeats;

import com.example.DynamicSeats.service.ChooseSeatBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.DynamicSeats")
public class DynamicSeatsApplication {


    public static void main(String[] args) {

        SpringApplication.run(DynamicSeatsApplication.class, args);
    }

}
