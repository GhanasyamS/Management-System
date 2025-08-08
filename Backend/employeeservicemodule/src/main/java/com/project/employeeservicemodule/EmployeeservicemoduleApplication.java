package com.project.employeeservicemodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EmployeeservicemoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeservicemoduleApplication.class, args);
	}

}
