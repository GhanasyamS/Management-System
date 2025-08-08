package com.project.emailservicemodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EmailservicemoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailservicemoduleApplication.class, args);
	}

}
