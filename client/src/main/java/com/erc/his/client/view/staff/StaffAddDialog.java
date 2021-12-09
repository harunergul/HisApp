package com.erc.his.client.view.staff;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.erc.his.ClientApp;
import com.erc.his.client.component.MainDialog;
import com.erc.his.client.component.OrganizationSelectionComponent;
import com.erc.his.constant.CodeDefinitionConstant;
import com.erc.his.entity.OrganizationDTO;
import com.erc.his.client.component.DatePickerComponent;
import com.erc.his.client.component.CodeValueCombobox;

public class StaffAddDialog extends MainDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtEmployeeNo = new JTextField();

	private CodeValueCombobox cbGender = new CodeValueCombobox(CodeDefinitionConstant.GENDER);
	private JRadioButton rdBtnIsActive = new JRadioButton("");

	private JButton btnCancel = new JButton("Cancel");
	private JButton btnSave = new JButton("Save");
	private final String SAVE_EVENT = "SAVE_EVENT";
	private final String CANCEL_EVENT = "CANCEL_EVENT";
	private final String IS_ACTIVE_EVENT = "IS_ACTIVE_EVENT";
	private final ClientApp serviceHelper = new ClientApp();

	public OrganizationAddDialogResult dialogResult;
	private OrganizationDTO organization;
	private JTextField txtFirstName = new JTextField();
	private JTextField txtLastName = new JTextField();
	private JTextField txtIdentificationNo = new JTextField();
	private JTextField txtBirthPlace = new JTextField();
	private DatePickerComponent birthDatePicker = new DatePickerComponent();
	private final CodeValueCombobox cbMaritalStatus = new CodeValueCombobox(CodeDefinitionConstant.MARITALSTATUS);
	private final CodeValueCombobox cbBloodGroup = new CodeValueCombobox(CodeDefinitionConstant.BLOODGROUP);
	private final CodeValueCombobox cbMilitaryStatus = new CodeValueCombobox(CodeDefinitionConstant.MILITARYSTATUS);
	private OrganizationSelectionComponent organizationComponent = new OrganizationSelectionComponent();

	public StaffAddDialog() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 5, 90, 5, 150, 5, 90, 150, 0, 0, 5, 0 };
		gridBagLayout.rowHeights = new int[] { 5, 0, 0, 0, 0, 5, 0, 0, 0, 5, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblEmployeeNo = new JLabel("Employee No");
		GridBagConstraints gbc_lblEmployeeNo = new GridBagConstraints();
		gbc_lblEmployeeNo.anchor = GridBagConstraints.WEST;
		gbc_lblEmployeeNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmployeeNo.gridx = 1;
		gbc_lblEmployeeNo.gridy = 1;
		getContentPane().add(lblEmployeeNo, gbc_lblEmployeeNo);
		JLabel lblMilitaryStatus = new JLabel("Military Status");
		GridBagConstraints gbc_txtEmployeeNo = new GridBagConstraints();
		gbc_txtEmployeeNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmployeeNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmployeeNo.gridx = 3;
		gbc_txtEmployeeNo.gridy = 1;
		getContentPane().add(txtEmployeeNo, gbc_txtEmployeeNo);
		txtEmployeeNo.setColumns(10);
		JLabel lblBloodGroup = new JLabel("Blood Group");
		JLabel lblMaritalStatus = new JLabel("Marital Status");
		JLabel lblIdentificationNo = new JLabel("Identification No");
		GridBagConstraints gbc_lblIdentificationNo = new GridBagConstraints();
		gbc_lblIdentificationNo.anchor = GridBagConstraints.WEST;
		gbc_lblIdentificationNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdentificationNo.gridx = 5;
		gbc_lblIdentificationNo.gridy = 1;
		getContentPane().add(lblIdentificationNo, gbc_lblIdentificationNo);
		JLabel lblOrganization = new JLabel("Organization");
		txtIdentificationNo.setColumns(10);
		GridBagConstraints gbc_txtIdentificationNo = new GridBagConstraints();
		gbc_txtIdentificationNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtIdentificationNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdentificationNo.gridx = 6;
		gbc_txtIdentificationNo.gridy = 1;
		getContentPane().add(txtIdentificationNo, gbc_txtIdentificationNo);

		JLabel lblName = new JLabel("First Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 2;
		getContentPane().add(lblName, gbc_lblName);

		txtFirstName.setColumns(10);
		GridBagConstraints gbc_txtFirstName = new GridBagConstraints();
		gbc_txtFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirstName.gridx = 3;
		gbc_txtFirstName.gridy = 2;
		getContentPane().add(txtFirstName, gbc_txtFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.WEST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 5;
		gbc_lblLastName.gridy = 2;
		getContentPane().add(lblLastName, gbc_lblLastName);

		txtLastName.setColumns(10);
		GridBagConstraints gbc_txtLastName = new GridBagConstraints();
		gbc_txtLastName.insets = new Insets(0, 0, 5, 5);
		gbc_txtLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastName.gridx = 6;
		gbc_txtLastName.gridy = 2;
		getContentPane().add(txtLastName, gbc_txtLastName);

		JLabel lblBirthDate = new JLabel("Birth Date");
		GridBagConstraints gbc_lblBirthDate = new GridBagConstraints();
		gbc_lblBirthDate.anchor = GridBagConstraints.WEST;
		gbc_lblBirthDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthDate.gridx = 1;
		gbc_lblBirthDate.gridy = 3;
		getContentPane().add(lblBirthDate, gbc_lblBirthDate);

		GridBagConstraints gbc_birthDatePicker = new GridBagConstraints();
		gbc_birthDatePicker.insets = new Insets(0, 0, 5, 5);
		gbc_birthDatePicker.fill = GridBagConstraints.BOTH;
		gbc_birthDatePicker.gridx = 3;
		gbc_birthDatePicker.gridy = 3;
		getContentPane().add(birthDatePicker, gbc_birthDatePicker);

		JLabel lblBirthPlace = new JLabel("Birth Place");
		GridBagConstraints gbc_lblBirthPlace = new GridBagConstraints();
		gbc_lblBirthPlace.anchor = GridBagConstraints.WEST;
		gbc_lblBirthPlace.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthPlace.gridx = 5;
		gbc_lblBirthPlace.gridy = 3;
		getContentPane().add(lblBirthPlace, gbc_lblBirthPlace);

		txtBirthPlace.setColumns(10);
		GridBagConstraints gbc_txtBirthPlace = new GridBagConstraints();
		gbc_txtBirthPlace.insets = new Insets(0, 0, 5, 5);
		gbc_txtBirthPlace.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBirthPlace.gridx = 6;
		gbc_txtBirthPlace.gridy = 3;
		getContentPane().add(txtBirthPlace, gbc_txtBirthPlace);

		JLabel lblGender = new JLabel("Gender");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.WEST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 1;
		gbc_lblGender.gridy = 4;
		getContentPane().add(lblGender, gbc_lblGender);

		GridBagConstraints gbc_cbGender = new GridBagConstraints();
		gbc_cbGender.insets = new Insets(0, 0, 5, 5);
		gbc_cbGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbGender.gridx = 3;
		gbc_cbGender.gridy = 4;
		getContentPane().add(cbGender, gbc_cbGender);

		GridBagConstraints gbc_lblMaritalStatus = new GridBagConstraints();
		gbc_lblMaritalStatus.anchor = GridBagConstraints.WEST;
		gbc_lblMaritalStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaritalStatus.gridx = 5;
		gbc_lblMaritalStatus.gridy = 4;
		getContentPane().add(lblMaritalStatus, gbc_lblMaritalStatus);

		GridBagConstraints gbc_cbMaritalStatus = new GridBagConstraints();
		gbc_cbMaritalStatus.insets = new Insets(0, 0, 5, 5);
		gbc_cbMaritalStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbMaritalStatus.gridx = 6;
		gbc_cbMaritalStatus.gridy = 4;
		getContentPane().add(cbMaritalStatus, gbc_cbMaritalStatus);

		GridBagConstraints gbc_lblBloodGroup = new GridBagConstraints();
		gbc_lblBloodGroup.anchor = GridBagConstraints.WEST;
		gbc_lblBloodGroup.insets = new Insets(0, 0, 5, 5);
		gbc_lblBloodGroup.gridx = 1;
		gbc_lblBloodGroup.gridy = 5;
		getContentPane().add(lblBloodGroup, gbc_lblBloodGroup);

		GridBagConstraints gbc_cbBloodGroup = new GridBagConstraints();
		gbc_cbBloodGroup.insets = new Insets(0, 0, 5, 5);
		gbc_cbBloodGroup.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbBloodGroup.gridx = 3;
		gbc_cbBloodGroup.gridy = 5;
		getContentPane().add(cbBloodGroup, gbc_cbBloodGroup);

		GridBagConstraints gbc_lblMilitaryStatus = new GridBagConstraints();
		gbc_lblMilitaryStatus.anchor = GridBagConstraints.WEST;
		gbc_lblMilitaryStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblMilitaryStatus.gridx = 5;
		gbc_lblMilitaryStatus.gridy = 5;
		getContentPane().add(lblMilitaryStatus, gbc_lblMilitaryStatus);

		GridBagConstraints gbc_cbMilitaryStatus = new GridBagConstraints();
		gbc_cbMilitaryStatus.insets = new Insets(0, 0, 5, 5);
		gbc_cbMilitaryStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbMilitaryStatus.gridx = 6;
		gbc_cbMilitaryStatus.gridy = 5;
		getContentPane().add(cbMilitaryStatus, gbc_cbMilitaryStatus);

		GridBagConstraints gbc_lblOrganization = new GridBagConstraints();
		gbc_lblOrganization.anchor = GridBagConstraints.WEST;
		gbc_lblOrganization.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrganization.gridx = 1;
		gbc_lblOrganization.gridy = 6;
		getContentPane().add(lblOrganization, gbc_lblOrganization);

		GridBagConstraints gbc_organizationComponent = new GridBagConstraints();
		gbc_organizationComponent.insets = new Insets(0, 0, 5, 5);
		gbc_organizationComponent.gridx = 3;
		gbc_organizationComponent.gridy = 6;
		getContentPane().add(organizationComponent, gbc_organizationComponent);

		JLabel lblIsActive = new JLabel("Is Active?");
		GridBagConstraints gbc_lblIsActive = new GridBagConstraints();
		gbc_lblIsActive.anchor = GridBagConstraints.WEST;
		gbc_lblIsActive.insets = new Insets(0, 0, 5, 5);
		gbc_lblIsActive.gridx = 1;
		gbc_lblIsActive.gridy = 8;
		getContentPane().add(lblIsActive, gbc_lblIsActive);

		GridBagConstraints gbc_rdBtnIsActive = new GridBagConstraints();
		gbc_rdBtnIsActive.anchor = GridBagConstraints.WEST;
		gbc_rdBtnIsActive.insets = new Insets(0, 0, 5, 5);
		gbc_rdBtnIsActive.gridx = 3;
		gbc_rdBtnIsActive.gridy = 8;
		getContentPane().add(rdBtnIsActive, gbc_rdBtnIsActive);

		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 6;
		gbc_btnSave.gridy = 8;
		getContentPane().add(btnSave, gbc_btnSave);

		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 7;
		gbc_btnCancel.gridy = 8;
		getContentPane().add(btnCancel, gbc_btnCancel);

		addEvents();

		if (organization != null) {
			boolean isSelected = (organization.getActive() != null && organization.getActive().equals("1"));

			if (isSelected) {
				rdBtnIsActive.setText("Active");
				rdBtnIsActive.setSelected(true);
			} else {
				rdBtnIsActive.setText("Passive");
			}
		} else {
			rdBtnIsActive.setText("Active");
			rdBtnIsActive.setSelected(true);
		}

	}

	private void addEvents() {
		DialogEventListener listener = new DialogEventListener();
		btnSave.addActionListener(listener);
		btnCancel.addActionListener(listener);
		rdBtnIsActive.addActionListener(listener);

		btnSave.setActionCommand(SAVE_EVENT);
		btnCancel.setActionCommand(CANCEL_EVENT);
		rdBtnIsActive.setActionCommand(IS_ACTIVE_EVENT);

	}

	class OrganizationAddDialogResult {
		public OrganizationDTO entity;

		public OrganizationAddDialogResult(OrganizationDTO entity) {
			this.entity = entity;
		}
	}

	private class DialogEventListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();

			if (cmd.equals(SAVE_EVENT)) {
				OrganizationDTO organizationDTO;

				if (organization != null) {
					organizationDTO = organization;
				} else {
					organizationDTO = new OrganizationDTO();

				}

				String code = txtEmployeeNo.getText();
				String name = txtFirstName.getText();
				String active = rdBtnIsActive.isSelected() ? "1" : "0";

				if (code.contentEquals("")) {
					showWarning("Please fill organization code field!");
					return;
				}

				if (name.contentEquals("")) {
					showWarning("Please fill organization name!");
					return;
				}

				organizationDTO.setCode(code);
				organizationDTO.setName(name);
				organizationDTO.setActive(active);

				try {
					boolean isNew = organizationDTO.getOrganizationId() == null;

					organizationDTO = serviceHelper.saveOrganizationDTO(organizationDTO);
					dialogResult = new OrganizationAddDialogResult(organizationDTO);
					if (isNew) {
						showSuccess("Successfully created.");
					} else {
						showSuccess("Successfully updated.");
					}
					dispose();

				} catch (Exception e1) {
					showError(e1.getMessage());
					e1.printStackTrace();
				}

			} else if (cmd.equals(CANCEL_EVENT)) {
				dispose();
			} else if (cmd.equals(IS_ACTIVE_EVENT)) {
				boolean isSelected = rdBtnIsActive.isSelected();

				if (isSelected) {
					rdBtnIsActive.setText("Active");
				} else {
					rdBtnIsActive.setText("Passive");
				}
			}

		}

	}

	public void setOrganization(OrganizationDTO entity) {
		this.organization = entity;
		if (organization != null) {
			txtEmployeeNo.setText(entity.getCode());
			txtFirstName.setText(entity.getName());
			boolean isSelected = entity.getActive().equals("1") ? true : false;
			rdBtnIsActive.setSelected(isSelected);
			if (isSelected) {
				rdBtnIsActive.setText("Active");
			} else {
				rdBtnIsActive.setText("Passive");
			}
		}
	}

}