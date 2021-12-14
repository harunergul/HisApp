package com.erc.his.entity;

import java.sql.Timestamp;

public class AppointmentDTO extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Long appointmentId;
	private Long patientId;
	private Long organizationId;
	private Long doctorId;
	private String note;
	private Timestamp appointmentDate;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String status;

	private String scalarPatientName;
	private String scalarDoctorName;

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Timestamp getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Timestamp appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getScalarPatientName() {
		return scalarPatientName;
	}

	public void setScalarPatientName(String scalarPatientName) {
		this.scalarPatientName = scalarPatientName;
	}

	public String getScalarDoctorName() {
		return scalarDoctorName;
	}

	public void setScalarDoctorName(String scalarDoctorName) {
		this.scalarDoctorName = scalarDoctorName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
