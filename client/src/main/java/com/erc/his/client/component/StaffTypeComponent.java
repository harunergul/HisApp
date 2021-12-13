package com.erc.his.client.component;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import com.erc.his.ClientApp;
import com.erc.his.entity.StaffTitleDTO;

public class StaffTypeComponent extends JComboBox<String> {

	private static final long serialVersionUID = 1L;
	private final String choose = "--Choose--";
	private List<StaffTitleDTO> titles = new ArrayList<StaffTitleDTO>();

	public StaffTypeComponent() {
		if (Beans.isDesignTime()) {
			return;
		}
		this.removeAllItems();
		this.addItem(choose);
		ClientApp app = new ClientApp();
		try {
			titles = app.getAllStaffTitles();
			for (StaffTitleDTO dto : titles) {
				this.addItem(dto.getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public StaffTitleDTO getSelectedTitle() {
		if (this.getSelectedItem() == null || this.getSelectedIndex()==0)
			return null;
		return titles.get(this.getSelectedIndex() - 1);
	}

	public Long getSelectedId() {
		if (this.getSelectedItem() != null) {
			StaffTitleDTO staffTitle = getSelectedTitle();
			if (staffTitle != null) {
				return getSelectedTitle().getStaffTitleId();
			}
		}
		return null;
	}

	public void setItemById(Long codeValueId) {
		for (StaffTitleDTO dto : titles) {
			if (dto.getStaffTitleId().compareTo(codeValueId) == 0) {
				setSelectedItem(dto.getName());
				break;
			}
		}
	}
}
