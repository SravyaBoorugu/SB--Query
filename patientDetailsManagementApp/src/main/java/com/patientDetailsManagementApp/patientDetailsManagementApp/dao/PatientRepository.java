package com.patientDetailsManagementApp.patientDetailsManagementApp.dao;

import java.util.List;
import java.util.Optional;

//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.patientDetailsManagementApp.patientDetailsManagementApp.model.PDMAModel;



public interface PatientRepository extends JpaRepository<PDMAModel, Integer>{

	Optional<PDMAModel> findByPatientProfession(String patientProfession);

	// @Transactional
	@Query("select p from PDMAModel p where p.patientID = :patientID and p.patientProfession = :patientProfession")
	Optional<PDMAModel> findByPatientMultiCondition(@Param("patientID") int patientID, @Param("patientProfession") String patientProfession);
	
	//@Transactional
	@Modifying
	@Query("delete from PDMAModel where patientName = :patientName")
	void deletePatient(@Param("patientName") String patientName);
	

	//public List<PDMAModel> findAll();
	//public String findByPatientID(int patientID);
	
	public List<PDMAModel> findByPatientNameAndPatientAge(String patientName, int patientAge);
	
	public void deleteByPatientName(String patientName);
	
}


 