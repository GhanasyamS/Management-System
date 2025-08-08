package com.project.customerservicemodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CustomerservicemoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerservicemoduleApplication.class, args);
	}

}
