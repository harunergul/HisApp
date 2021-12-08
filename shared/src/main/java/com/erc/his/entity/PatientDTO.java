package com.erc.his.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PatientDTO extends BaseEntity {

	private static final long serialVersionUID = 6024551171120968334L;
	private Long patientId;
	private String patientNo;
	private String identificationNo;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String status;
	private Long genderId;
	private String scalarGender;
	private Long bloodGroupId;
	private String scalarBloodGroup;
	private Long maritalStatusId;
	private Long scalarMaritalStatus;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getGenderId() {
		return genderId;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	public String getScalarGender() {
		return scalarGender;
	}

	public void setScalarGender(String scalarGender) {
		this.scalarGender = scalarGender;
	}

	public Long getBloodGroupId() {
		return bloodGroupId;
	}

	public void setBloodGroupId(Long bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}

	public String getScalarBloodGroup() {
		return scalarBloodGroup;
	}

	public void setScalarBloodGroup(String scalarBloodGroup) {
		this.scalarBloodGroup = scalarBloodGroup;
	}

	public Long getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(Long maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public Long getScalarMaritalStatus() {
		return scalarMaritalStatus;
	}

	public void setScalarMaritalStatus(Long scalarMaritalStatus) {
		this.scalarMaritalStatus = scalarMaritalStatus;
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
		if (period.getYears() > 0) {
			buffer.append(period.getYears());
			buffer.append("y ");

		}
		if (period.getMonths() > 0) {
			buffer.append(period.getMonths());
			buffer.append("m ");
		}
		if (period.getDays() > 0 && period.getYears() == 0) {
			buffer.append(period.getDays());
			buffer.append("d ");
		}
		return buffer.toString();
	}

}
