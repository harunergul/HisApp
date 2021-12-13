package com.erc.his.client.view.staff;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.erc.his.entity.StaffDTO;

public class StaffTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -8272591925071178409L;

	private List<StaffDTO> listData = new ArrayList<>();

	String[] columnName = { "Employee No", "Identification No", "First Name", "Last Name", "Working Organization",
			"Staff Type", "Is Active" };

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
		StaffDTO dto = listData.get(row);

		switch (column) {
		case 0:
			return dto.getEmployeNo();
		case 1:
			return dto.getIdentificationNo();
		case 2:
			return dto.getFirstName();
		case 3:
			return dto.getLastName();
		case 4:
			return dto.getScalarOrganizationName();
		case 5:
			return dto.getScalarStaffTitle();
		case 6:
			return dto.getActive().equals("1") ? "ACTIVE" : "PASSIVE";

		default:
			break;
		}
		return null;

	}

	public List<StaffDTO> getListData() {
		return listData;
	}

	public void setListData(List<StaffDTO> listData) {
		this.listData = listData;
	}

}