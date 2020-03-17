package com.patientDetailsManagementApp.patientDetailsManagementApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PDMAModel {
	
	@Id
	private int patientID;
	private String patientName;
	private int patientAge;
	private String patientProfession;

}
