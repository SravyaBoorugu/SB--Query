package com.patientDetailsManagementApp.patientDetailsManagementApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.patientDetailsManagementApp.patientDetailsManagementApp.dao.PatientRepository;
import com.patientDetailsManagementApp.patientDetailsManagementApp.model.PDMAModel;

@Service
public class PDMAService {

	@Autowired
	private PatientRepository patientRepository;
	
	@PostConstruct
    public void initDB() 
	{
       List<PDMAModel> patientList = new ArrayList<>();
       patientList.add(new PDMAModel(1, "Sravya", 22, "Engineer"));
       patientList.add(new PDMAModel(2, "Shreyas", 20, "Doctor"));
       /*
        
        patientList.add(patientObject);
        patientList.add(patientObject); 
       
        */
       
       patientRepository.saveAll(patientList);
     }

	
	public List<PDMAModel> findPatients(){
		return patientRepository.findAll();
	}

  
	public Optional<PDMAModel> findByPatientID(int patientID){
		return patientRepository.findById(patientID);
	} 
	
	public Optional<PDMAModel> findByPatientProfession(String patientProfession){
		return patientRepository.findByPatientProfession(patientProfession);
	}

	
	@Transactional
	public void deletePatient(String patientName) {
	    patientRepository.deletePatient(patientName);
	    System.out.println("deleted.");
	}
	
	@Transactional
	public Optional<PDMAModel> findByPatientMultiCondition(int patientID, String patientProfession){
		return patientRepository.findByPatientMultiCondition(patientID, patientProfession);
	}
	
	public List<PDMAModel> findByMultiCondition(String patientName, int patientAge){
		return patientRepository.findByPatientNameAndPatientAge(patientName, patientAge);
	}
	
	@Transactional
	public void deleteByPatientName(String patientName) {
	      patientRepository.deleteByPatientName(patientName);
	      System.out.println("Patient record deleted");
	}
	
}
