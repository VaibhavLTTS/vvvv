package com.sensor.model;
public class Sensor {
	String patient_name;
	String patient_id;
	Integer patient_age;
	Integer blood_pressure;
	Integer oxygen_level;
	Integer heartbeat_rate;
	public Sensor(String patient_name, String patient_id, Integer patient_age, Integer blood_pressure,
			Integer oxygen_level, Integer heartbeat_rate) {
		super();
		this.patient_name = patient_name;
		this.patient_id = patient_id;
		this.patient_age = patient_age;
		this.blood_pressure = blood_pressure;
		this.oxygen_level = oxygen_level;
		this.heartbeat_rate = heartbeat_rate;
	}
	public Sensor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}
	public Integer getPatient_age() {
		return patient_age;
	}
	public void setPatient_age(Integer patient_age) {
		this.patient_age = patient_age;
	}
	public Integer getBlood_pressure() {
		return blood_pressure;
	}
	public void setBlood_pressure(Integer blood_pressure) {
		this.blood_pressure = blood_pressure;
	}
	public Integer getOxygen_level() {
		return oxygen_level;
	}
	public void setOxygen_level(Integer oxygen_level) {
		this.oxygen_level = oxygen_level;
	}
	public Integer getHeartbeat_rate() {
		return heartbeat_rate;
	}
	public void setHeartbeat_rate(Integer heartbeat_rate) {
		this.heartbeat_rate = heartbeat_rate;
	}
	@Override
	public String toString() {
		return "Sensor [patient_name=" + patient_name + ", patient_id=" + patient_id + ", patient_age=" + patient_age
				+ ", blood_pressure=" + blood_pressure + ", oxygen_level=" + oxygen_level + ", heartbeat_rate="
				+ heartbeat_rate + "]";
	}
	
	

}
