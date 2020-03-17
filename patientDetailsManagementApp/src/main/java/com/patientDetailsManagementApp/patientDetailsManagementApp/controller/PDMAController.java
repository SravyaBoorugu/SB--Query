package com.patientDetailsManagementApp.patientDetailsManagementApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patientDetailsManagementApp.patientDetailsManagementApp.model.PDMAModel;
import com.patientDetailsManagementApp.patientDetailsManagementApp.service.PDMAService;

@RestController
@RequestMapping("/spring-data-jpa")
public class PDMAController {
	
	@Autowired
	public PDMAService pDMAService;

	@GetMapping("/getPatients")
	public List<PDMAModel> findPatients(){
		return pDMAService.findPatients();
	}

    @GetMapping("/getPatientById/{patientID}")
    public Optional<PDMAModel> findPatientByID(@PathVariable(required = true) int patientID){
    	return pDMAService.findByPatientID(patientID);
    }
    
    @GetMapping("/getPatientByProfession/{patientProfession}")
    public Optional<PDMAModel> findPatientByProfession(@PathVariable(required = true) String patientProfession){
            return pDMAService.findByPatientProfession(patientProfession);
    }
    
    @GetMapping("/deletePatient/{patientName}")
    public void deletePatient(@PathVariable(required = true) String patientName) { 
    	pDMAService.deletePatient(patientName);
    }
    
    @GetMapping("/getPatientByMultiCondition/{patientID}/{patientProfession}")
    public Optional<PDMAModel> findByPatientMultiCondition(@PathVariable(required = true) int patientID,@PathVariable(required=true) String patientProfession){
    	return pDMAService.findByPatientMultiCondition(patientID, patientProfession);
    }
    
    @GetMapping("/getPatientByMultiFactor/{patientName}/{patientAge}")
    public List<PDMAModel> findByMultiCondition(@PathVariable String patientName, @PathVariable int patientAge){
    	return pDMAService.findByMultiCondition(patientName, patientAge);
    }
    
    @GetMapping("/deleteByPatientName/{patientName}")
    public void deleteByPatientName(@PathVariable String patientName) {
    	pDMAService.deleteByPatientName(patientName);
    }
    
}
