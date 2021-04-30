package com.ltts.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltts.model.*;
import com.ltts.service.PatientService;



@RestController
@RequestMapping("/Patients_data")
public class PatientController
{
	
	@Autowired
	PatientService patientservice;
	@PostMapping("/patients")
	
	ResponseEntity <Patient>addPatient(@RequestBody Patient patient)
	{
		Patient patients= patientservice.AddPatient(patient);
		return ResponseEntity.ok(patients);
	}
	
	@GetMapping("/patients/get_patient/{P_id}")
	ResponseEntity <Patient>getPatientbyID(@PathVariable("Patient_id") Integer P_id)
	{
		Patient patients=patientservice.getPatientbyId(P_id);
		return ResponseEntity.status(HttpStatus.OK).body(patients);
		
	}
	@GetMapping("/patients/name/{P_name}")
	
		ResponseEntity<List<Patient>>getPatientsByName(@PathVariable("P_name")String P_name)
		{
			List<Patient>patientList= patientservice.getPatientbyName(P_name);
			return ResponseEntity.ok(patientList);
			
		}
		
		
	@GetMapping("/patients/oxygenLevel/{P_Oxygen_Level}")
	ResponseEntity<List<Patient>>getPatientByOL(@PathVariable("P_Oxygen_Level")String P_Oxygen_Level)
	{
		List<Patient>patientList= patientservice.getPatientbyOL(P_Oxygen_Level);
		return ResponseEntity.ok(patientList);
	}
	
	
	@GetMapping("/patients/Blood_Pressure/{P_Blood_Pressure}")
	
	ResponseEntity<List<Patient>>getPatientByBP(@PathVariable("P_Blood_Pressure")String P_Blood_Pressure)
	{
		List<Patient>patientList= patientservice.getPatientbyBP(P_Blood_Pressure);
		return ResponseEntity.ok(patientList);
	}
	
	
	@GetMapping("/patients/Heart_Rate/{P_Heart_Rate}")
	ResponseEntity<List<Patient>>getPatientByHR(@PathVariable("P_Heart_Rate")String P_Heart_Rate)
	{
		List<Patient>patientList= patientservice.getPatientbyHR(P_Heart_Rate);
		return ResponseEntity.ok(patientList);
	}
	
	
	
	}

