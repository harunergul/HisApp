package com.erc.his.client.view.appointment;

import java.util.Date;

import com.erc.his.entity.AppointmentDTO;

public class AppointmentRow {
	private Date date;
	private AppointmentDTO appointment;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AppointmentDTO getAppointment() {
		return appointment;
	}

	public void setAppointment(AppointmentDTO appointment) {
		this.appointment = appointment;
	}

}