package com.project.timesheetservicemodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TimesheetservicemoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimesheetservicemoduleApplication.class, args);
	}

}
