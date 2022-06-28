package com.skytech.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HrMgtProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrMgtProducerApplication.class, args);
	}

}
