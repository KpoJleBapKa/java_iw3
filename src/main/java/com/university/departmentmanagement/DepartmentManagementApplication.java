package com.university.departmentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DepartmentManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(DepartmentManagementApplication.class, args);
	}
}
