package com.erc.his.client.view.organization;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import com.erc.his.client.component.AqButton;
import com.erc.his.client.component.ButtonIcon;
import com.erc.his.client.component.MainPanel;
import com.erc.his.client.constant.CustomEvent;
import com.erc.his.entity.OrganizationDTO;

import java.awt.Dimension;

public class OrganizationSelectionComponent extends MainPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtCode = new JTextField();
	private JTextField txtName = new JTextField();
	private AqButton btnSearch = new AqButton();
	private String CLEAR_EVENT = "CLEAR_EVENT";
	private String SEARCH_EVENT = "SEARCH_EVENT";
	private AqButton btnClear = new AqButton();
	private OrganizationDTO selectedOrganizationDTO;

	public OrganizationSelectionComponent() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 86, 150, 20, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 20, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		GridBagConstraints gbc_txtCode = new GridBagConstraints();
		gbc_txtCode.fill = GridBagConstraints.BOTH;
		gbc_txtCode.insets = new Insets(0, 0, 0, 5);
		gbc_txtCode.gridx = 0;
		gbc_txtCode.gridy = 0;
		add(txtCode, gbc_txtCode);
		txtCode.setColumns(10);

		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 0, 5);
		gbc_txtName.fill = GridBagConstraints.BOTH;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 0;
		add(txtName, gbc_txtName);
		txtName.setColumns(10);
		txtName.setEditable(false);

		btnSearch.dimension = new Dimension(14, 14);
		btnSearch.setIcon(ButtonIcon.SEARCH);
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSearch.gridx = 2;
		gbc_btnSearch.gridy = 0;
		add(btnSearch, gbc_btnSearch);

		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnClear.gridx = 3;
		gbc_btnClear.gridy = 0;
		btnClear.setIcon(ButtonIcon.CLOSE);
		btnClear.dimension = new Dimension(14, 14);
		add(btnClear, gbc_btnClear);

		addEvents();

	}

	public OrganizationDTO getSelectedOrganizationDTO() {
		return selectedOrganizationDTO;
	}

	public void setSelectedOrganizationDTO(OrganizationDTO selectedOrganizationDTO) {
		if (selectedOrganizationDTO != null) {
			txtCode.setText(selectedOrganizationDTO.getCode());
			txtName.setText(selectedOrganizationDTO.getName());
		} else {
			txtCode.setText(null);
			txtName.setText(null);
		}
		this.selectedOrganizationDTO = selectedOrganizationDTO;
	}

	private void addEvents() {
		btnSearch.setActionCommand(SEARCH_EVENT);
		btnClear.setActionCommand(CLEAR_EVENT);

		ComponentEventListener listener = new ComponentEventListener();
		btnSearch.addActionListener(listener);
		btnClear.addActionListener(listener);

	}

	class ComponentEventListener extends KeyAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals(CLEAR_EVENT)) {
				setSelectedOrganizationDTO(null);
				setActionCommand(CustomEvent.ORGANIZATION_DESELECTED);
				fireActionPerformed();
			} else if (e.getActionCommand().equals(SEARCH_EVENT)) {
				if (txtCode.getText().isEmpty()) {
					showWarning("Please enter organization code");
					return;
				}
				try {
					OrganizationDTO dto = serviceHelper.getOrganizationByOrganizationCode("organizationCode");
					setSelectedOrganizationDTO(dto);
					setActionCommand(CustomEvent.ORGANIZATION_SELECTED);
					fireActionPerformed();
				} catch (Exception e1) {
					showError(e1.getLocalizedMessage());
					e1.printStackTrace();
				}

			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (txtCode.getText().isEmpty()) {
					showWarning("Please enter organization code");
					return;
				}

				try {
					OrganizationDTO dto = serviceHelper.getOrganizationByOrganizationCode("organizationCode");
					setSelectedOrganizationDTO(dto);
					setActionCommand(CustomEvent.ORGANIZATION_SELECTED);
					fireActionPerformed();
				} catch (Exception e1) {
					showError(e1.getLocalizedMessage());
					e1.printStackTrace();
				}
			}

		}

	}

}
