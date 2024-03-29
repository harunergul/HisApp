package com.erc.his.client.view.definition.codevalue;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.erc.his.entity.CodeValueDTO;

public class CodeValueTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -8272591925071178409L;

	private List<CodeValueDTO> listData = new ArrayList<>();

	String[] columnName = { "Code Value","Display Value", "Description", "Is Active" };

	@Override
	public int getRowCount() {
		if(listData!=null) {
			return listData.size();
		}else {
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
		CodeValueDTO codeDefinitionDTO = listData.get(row);

		switch (column) {
		case 0:
			return codeDefinitionDTO.getCode();
		case 1:
			return codeDefinitionDTO.getDisplayValue();
		case 2:
			return codeDefinitionDTO.getDescription();
		case 3:
			return codeDefinitionDTO.getActive().equals("1") ? "ACTIVE" : "PASSIVE";

		default:
			break;
		}
		return null;

	}

	public List<CodeValueDTO> getListData() {
		return listData;
	}

	public void setListData(List<CodeValueDTO> listData) {
		this.listData = listData;
	}

}
