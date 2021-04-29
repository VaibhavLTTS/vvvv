package com.example;


import java.io.Serializable;



/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/

import com.fasterxml.jackson.annotation.JsonProperty;

//@Entity
public class SensorModel {

	private Integer patientid = 2;
	private final Integer bloodoxygenlevel;
	private final Integer heartrate;
	private Integer bloodpressure;
	private String timestamp;

	public SensorModel(@JsonProperty("patientid") final Integer patientid,
			@JsonProperty("timestamp") final String timestamp,
			@JsonProperty("bloodpressure") final Integer bloodpressure,
			@JsonProperty("bloodoxygenlevel") final Integer bloodoxygenlevel,
			@JsonProperty("heartrate") final Integer heartrate) {
		this.patientid = patientid;
		this.timestamp = timestamp;
		this.bloodpressure = bloodpressure;
		this.heartrate = heartrate;
		this.bloodoxygenlevel = bloodoxygenlevel;

	}

	public Integer getPatientid() {
		return patientid;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public Integer getBloodpressure() {
		return bloodpressure;
	}


	public Integer getBloodoxygenlevel() {
		return bloodoxygenlevel;
	}

	public Integer getHeartrate() {
		return heartrate;
	}

}
