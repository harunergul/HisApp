package com.erc.his.entity;

import java.util.Date;

public class StaffDTO extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Long staffId;
	private String employeNo; // sicil no
	private String firstName;
	private String lastName;
	private String identificationNo;
	private Date birthDate;
	private String birthPlace;
	private Long genderId;
	private Long organizationId;
	private Long staffTitleId;
	private Long maritalStatusId;
	private Long bloodGroupId;
	private String workPhoneNumber;
	private String phoneNumber;
	private Long militaryStatusId;
	private Date workStartDate;
	private String status;

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public String getEmployeNo() {
		return employeNo;
	}

	public void setEmployeNo(String employeNo) {
		this.employeNo = employeNo;
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

	public String getIdentificationNo() {
		return identificationNo;
	}

	public void setIdentificationNo(String identificationNo) {
		this.identificationNo = identificationNo;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Long getGenderId() {
		return genderId;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getStaffTitleId() {
		return staffTitleId;
	}

	public void setStaffTitleId(Long staffTitleId) {
		this.staffTitleId = staffTitleId;
	}

	public Long getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(Long maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public Long getBloodGroupId() {
		return bloodGroupId;
	}

	public void setBloodGroupId(Long bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}

	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}

	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getMilitaryStatusId() {
		return militaryStatusId;
	}

	public void setMilitaryStatusId(Long militaryStatusId) {
		this.militaryStatusId = militaryStatusId;
	}

	public Date getWorkStartDate() {
		return workStartDate;
	}

	public void setWorkStartDate(Date workStartDate) {
		this.workStartDate = workStartDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
