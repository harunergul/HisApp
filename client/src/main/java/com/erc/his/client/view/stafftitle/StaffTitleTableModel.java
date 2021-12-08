package com.erc.his.client.view.stafftitle;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.erc.his.entity.StaffTitleDTO;

public class StaffTitleTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -8272591925071178409L;

	private List<StaffTitleDTO> listData = new ArrayList<>();

	String[] columnName = { "Code", "Name" };

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
		StaffTitleDTO dto = listData.get(row);

		switch (column) {
		case 0:
			return dto.getCode();
		case 1:
			return dto.getName();

		default:
			break;
		}
		return null;

	}

	public List<StaffTitleDTO> getListData() {
		return listData;
	}

	public void setListData(List<StaffTitleDTO> listData) {
		this.listData = listData;
	}

}