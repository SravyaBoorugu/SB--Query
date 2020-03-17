package com.patientDetailsManagementApp.patientDetailsManagementApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.PDMADao")
//@ComponentScan(basePackages={"com.PDMAContoller","com.PDMADao","com.PDMAModel","com.PDMAService"})
public class PatientDetailsManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientDetailsManagementAppApplication.class, args);
	}

}
