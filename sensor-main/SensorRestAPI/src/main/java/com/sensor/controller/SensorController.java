package com.sensor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sensor.model.Sensor;
import com.sensor.service.SensorService;


@RestController
@RequestMapping("/Patients-api")
public class SensorController {
	
SensorService sensorservice;
@PostMapping("/patients")

  
ResponseEntity<Sensor>addPatient(@RequestBody Sensor sensor) {
	  Sensor patient = sensorservice.addPatient(sensor);
	  return ResponseEntity.ok(patient);
	}
@GetMapping("/patients/get-one/{patient_id}")
ResponseEntity<Sensor> getpatientById(@PathVariable("patient_id")Integer patient_id) {
    Sensor patient = sensorservice.getPatientById(patient_id);
    return ResponseEntity.status(HttpStatus.OK).body(patient);
}

   

@GetMapping("/patients/name/{patient_name}")
ResponseEntity<List<Sensor>>getPatientByName(@PathVariable("patient_name")String patient_name){
	 List<Sensor> sensorList =  sensorservice.getPatientByName(patient_name);
	    return ResponseEntity.ok(sensorList);
}

@GetMapping("/patients/blood-pressure/{blood_pressure}")
ResponseEntity<List<Sensor>>getPatientByBloodpressure(@PathVariable("blood_pressure")String blood_pressure){
	 List<Sensor> sensorList =sensorservice. getPatientByBloodpressure(blood_pressure);
	return  ResponseEntity.ok(sensorList);
}
@GetMapping("/patients/age/{patient_age}")
ResponseEntity<List<Sensor>> findByAge(@PathVariable("patient_age")Integer patient_age) {
    List<Sensor> sensorList =  sensorservice.findByAge(patient_age);
    return ResponseEntity.ok(sensorList);
}


@GetMapping("/patients/ oxygen_level/{ oxygen_level}")
ResponseEntity<List<Sensor>> getPatientByOxygenLevel(@PathVariable(" oxygen_level")String  oxygen_level){
	List<Sensor> sensorList = sensorservice.getPatientByOxygenLevel( oxygen_level);
	  return ResponseEntity.ok(sensorList);
}
@GetMapping("/patients/heartbeat_rate/{heartbeat_rate}")
ResponseEntity<List<Sensor>> getPatientByHeartBeatRate(@PathVariable("heartbeat_rate")String heartbeat_rate){
	List<Sensor> sensorList =sensorservice.getPatientByHeartBeatRate( heartbeat_rate);
	  return ResponseEntity.ok(sensorList);
}

}

