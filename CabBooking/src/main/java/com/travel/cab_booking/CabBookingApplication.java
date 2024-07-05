package com.travel.cab_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.travel.cab_booking")
@EntityScan(basePackages = "com.travel.cab_booking.bean")
@EnableJpaRepositories(basePackages = "com.travel.cab_booking.dao")
public class CabBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CabBookingApplication.class, args);
        System.out.println("Booking service started");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
