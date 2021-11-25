package com.erc.his.entity;

import java.io.Serializable;
import java.util.Date;

public class AdmissionDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long admissionId;
	private Long patientId;
	private Long admissionNo;
	private Date admissionDate;
	private String treatmentType;
	private Long organizationId;
	private Long staffId;
	private String note;
	private String status;
	private String closeStatus;
	
	private String scalarOrganizationCode;
	private String scalarOrganizationName;
	private String scalarDoctorName;
	private String scalarDoctorSurname;
	private Long scalarDoctorRegistry;
	private Long patientNo;
	private String scalarPatientName;
	private String scalarPatientSurname;
	private Date scalarPatientBirthday;
	private String scalarPatientGender;
	private Long scalarPatientTC;
	
	
	public Long getScalarDoctorRegistry() {
		return scalarDoctorRegistry;
	}
	public void setScalarDoctorRegistry(Long scalarDoctorRegistry) {
		this.scalarDoctorRegistry = scalarDoctorRegistry;
	}
	public Long getScalarPatientTC() {
		return scalarPatientTC;
	}
	public void setScalarPatientTC(Long scalarPatientTC) {
		this.scalarPatientTC = scalarPatientTC;
	}
	public String getScalarOrganizationCode() {
		return scalarOrganizationCode;
	}
	public void setScalarOrganizationCode(String scalarOrganizationCode) {
		this.scalarOrganizationCode = scalarOrganizationCode;
	}
	public String getScalarPatientGender() {
		return scalarPatientGender;
	}
	public void setScalarPatientGender(String scalarPatientGender) {
		this.scalarPatientGender = scalarPatientGender;
	}
	public String getScalarPatientName() {
		return scalarPatientName;
	}
	public void setScalarPatientName(String scalarPatientName) {
		this.scalarPatientName = scalarPatientName;
	}
	public String getScalarPatientSurname() {
		return scalarPatientSurname;
	}
	public void setScalarPatientSurname(String scalarPatientSurname) {
		this.scalarPatientSurname = scalarPatientSurname;
	}
	public Date getScalarPatientBirthday() {
		return scalarPatientBirthday;
	}
	public void setScalarPatientBirthday(Date scalarPatientBirthday) {
		this.scalarPatientBirthday = scalarPatientBirthday;
	}
	public String getCloseStatus() {
		return closeStatus;
	}
	public void setCloseStatus(String closeStatus) {
		this.closeStatus = closeStatus;
	}
	public String getScalarDoctorSurname() {
		return scalarDoctorSurname;
	}
	public void setScalarDoctorSurname(String scalarDoctorSurname) {
		this.scalarDoctorSurname = scalarDoctorSurname;
	}
	public String getScalarDoctorName() {
		return scalarDoctorName;
	}
	public void setScalarDoctorName(String scalarDoctorName) {
		this.scalarDoctorName = scalarDoctorName;
	}
	public String getScalarOrganizationName() {
		return scalarOrganizationName;
	}
	public void setScalarOrganizationName(String scalarOrganizationName) {
		this.scalarOrganizationName = scalarOrganizationName;
	}
	public Long getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(Long patientNo) {
		this.patientNo = patientNo;
	}
	public Long getAdmissionId() {
		return admissionId;
	}
	public void setAdmissionId(Long admissionId) {
		this.admissionId = admissionId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Long getAdmissionNo() {
		return admissionNo;
	}
	public void setAdmissionNo(Long admissionNo) {
		this.admissionNo = admissionNo;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getTreatmentType() {
		return treatmentType;
	}
	public void setTreatmentType(String treatmentType) {
		this.treatmentType = treatmentType;
	}
	public Long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
