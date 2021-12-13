package com.erc.his.client.view.appointment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.erc.his.entity.AppointmentDTO;

public class AppointmentTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -8272591925071178409L;

	private List<AppointmentRow> listData = new ArrayList<>();
	private SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");

	String[] columnName = { "Time", "Patient Name", "Doctor Name", "Created at", "Updated at" };

	@Override
	public int getRowCount() {
		if (listData != null) {
			return listData.size();
		} else {
			return 0;
		}

	}

	@Override
	public String getColumnName(int column) {
		return columnName[column];
	}

	@Override
	public int getColumnCount() {
		return columnName.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		AppointmentRow dto = listData.get(row);
		AppointmentDTO appointment = dto.getAppointment();
		String patientName = "";
		String doctorName = "";
		String createdAt = "";
		String updatedAt = "";
		switch (column) {
		case 0:
			return hourFormat.format(dto.getDate());
		case 1:
			return patientName;
		case 2:
			return doctorName;
		case 3:
			return createdAt;
		case 4:
			return updatedAt;

		default:
			break;
		}
		return null;

	}

	public List<AppointmentRow> getListData() {
		return listData;
	}

	public void setListData(List<AppointmentRow> listData) {
		this.listData = listData;
	}

	public void addAppointmentRow(AppointmentRow appointmentRow) {
		this.listData.add(appointmentRow);
	}

}