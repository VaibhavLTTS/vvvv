package com.ltts.model;

public class Patient {
	String P_name;
	String P_id;
	String P_Blood_Pressure;
	String P_Oxygen_Level;
	String P_Heart_Rate;
	
	
	
	
	
	public Patient() {
		super();
	}
	public Patient(String p_name, String p_id, String p_Blood_Pressure, String p_Oxygen_Level, String p_Heart_Rate) {
		super();
		this.P_name = p_name;
		this.P_id = p_id;
		this.P_Blood_Pressure = p_Blood_Pressure;
		this.P_Oxygen_Level = p_Oxygen_Level;
		this.P_Heart_Rate = p_Heart_Rate;
	}
	public String getP_name() {
		return P_name;
	}
	public void setP_name(String p_name) {
		P_name = p_name;
	}
	public String getP_id() {
		return P_id;
	}
	public void setP_id(String p_id) {
		P_id = p_id;
	}
	public String getP_Blood_Pressure() {
		return P_Blood_Pressure;
	}
	public void setP_Blood_Pressure(String p_Blood_Pressure) {
		P_Blood_Pressure = p_Blood_Pressure;
	}
	public String getP_Oxygen_Level() {
		return P_Oxygen_Level;
	}
	public void setP_Oxygen_Level(String p_Oxygen_Level) {
		P_Oxygen_Level = p_Oxygen_Level;
	}
	public String getP_Heart_Rate() {
		return P_Heart_Rate;
	}
	public void setP_Heart_Rate(String p_Heart_Rate) {
		P_Heart_Rate = p_Heart_Rate;
	}
	@Override
	public String toString() {
		return "Patient [P_name=" + P_name + ", P_id=" + P_id + ", P_Blood_Pressure=" + P_Blood_Pressure
				+ ", P_Oxygen_Level=" + P_Oxygen_Level + ", P_Heart_Rate=" + P_Heart_Rate + "]";
	}
	
	
	
		
	
	

}
