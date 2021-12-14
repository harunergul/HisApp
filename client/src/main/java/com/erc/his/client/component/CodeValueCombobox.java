package com.erc.his.client.component;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import com.erc.his.ClientApp;
import com.erc.his.entity.CodeValueDTO;

public class CodeValueCombobox extends JComboBox<String> {

	private static final long serialVersionUID = 5401097445340917825L;
	private final String choose = "--Choose--";
	private List<CodeValueDTO> codeValues = new ArrayList<CodeValueDTO>();

	public CodeValueCombobox(String CODETYPE) {
		
		if (Beans.isDesignTime()) {
			return;
		}
		this.removeAllItems();
		this.addItem(choose);
		try {
			codeValues = ClientApp.getCodeValueByCodeType(CODETYPE);
			for (CodeValueDTO codeValueDTO : codeValues) {
				this.addItem(codeValueDTO.getDisplayValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CodeValueDTO getSelectedCodeValue() { 
		if (this.getSelectedItem() == null || this.getSelectedIndex()==0)
			return null;
		return codeValues.get(this.getSelectedIndex()-1);
	}

	public Long getSelectedId() {
		if (this.getSelectedItem() != null) {
			CodeValueDTO codeValue = getSelectedCodeValue();
			if (codeValue != null) {
				return getSelectedCodeValue().getCodeValueId();
			} 
		}
		return null;
	}

	public void setItemById(Long codeValueId) {
		for (CodeValueDTO codeValueDTO : codeValues) {
			if(codeValueDTO.getCodeValueId().compareTo(codeValueId)==0) {
				setSelectedItem(codeValueDTO.getDisplayValue());
				break;
			}
		}
	}

}
