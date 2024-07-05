package com.travel.cab_fare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.travel.cab_fare")
@EntityScan(basePackages = "com.travel.cab_fare.bean")
@EnableJpaRepositories(basePackages = "com.travel.cab_fare.dao")
public class CabFareApplication {

    public static void main(String[] args) {
        SpringApplication.run(CabFareApplication.class, args);
        System.out.println("Cab fare service started");
    }

}