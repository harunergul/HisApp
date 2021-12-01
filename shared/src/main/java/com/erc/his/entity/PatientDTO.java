package com.erc.his.entity;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PatientDTO implements Serializable {

	private static final long serialVersionUID = 6024551171120968334L;
	private Long patientId;
	private String patientNo;
	private String identificationNo;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String gender;
	private String status;
	private String bloodGroup;
	private String maritalStatus;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getIdentificationNo() {
		return identificationNo;
	}

	public void setIdentificationNo(String identificationNo) {
		this.identificationNo = identificationNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@JsonIgnore
	public String getCalculatedAge() {
		if (getBirthDate() == null)
			return null;
		Instant instant = getBirthDate().toInstant();
		ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
		LocalDate birthDate = zone.toLocalDate();
		Period period = Period.between(birthDate, LocalDate.now());
		StringBuffer buffer = new StringBuffer();
		if(period.getYears()>0) {
			buffer.append(period.getYears());
			buffer.append("y ");
			
		}
		if(period.getMonths()>0) {
			buffer.append(period.getMonths());
			buffer.append("m ");
		}
		if(period.getDays()>0 && period.getYears()==0) {
			buffer.append(period.getDays());
			buffer.append("d ");
		}
		return buffer.toString();
	}

}
