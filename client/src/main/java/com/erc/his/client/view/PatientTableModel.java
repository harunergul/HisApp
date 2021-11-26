package com.erc.his.client.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.erc.his.entity.PatientDTO;

public class PatientTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -8272591925071178409L;

	private List<PatientDTO> listData = new ArrayList<>();

	String[] columnName = { "Patient No", "Full name", "Identification No", "Birth Date", "Age", "Gender",
			"Blood Group", "Marital Status" };

	@Override
	public int getRowCount() {
		return listData.size();
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
		PatientDTO patientDTO = listData.get(row);

		switch (column) {
		case 0:
			return patientDTO.getPatientNo();
		case 1:
			return patientDTO.getFirstName() + " " + patientDTO.getLastName();
		case 2:
			return patientDTO.getIdentificationNo();
		case 3:
			return patientDTO.getBirthDate();
		case 4:
			return patientDTO.getCalculatedAge();
		case 5:
			return patientDTO.getGender();
		case 6:
			return patientDTO.getBloodGroup();
		case 7:
			return patientDTO.getMaritalStatus();
		default:
			break;
		}
		return null;

	}

	public List<PatientDTO> getListData() {
		return listData;
	}

	public void setListData(List<PatientDTO> listData) {
		this.listData = listData;
	}

}
