package com.erc.his.client.view.staff;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.erc.his.ClientApp;
import com.erc.his.client.component.MainDialog;
import com.erc.his.client.component.OrganizationSelectionComponent;
import com.erc.his.constant.CodeDefinitionConstant;
import com.erc.his.entity.OrganizationDTO;
import com.erc.his.entity.StaffDTO;
import com.erc.his.client.component.DatePickerComponent;
import com.erc.his.client.component.CodeValueCombobox;
import com.erc.his.client.component.StaffTypeComponent;

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

	public StaffAddDialogResult dialogResult;
	private StaffDTO staffDTO;
	private JTextField txtFirstName = new JTextField();
	private JTextField txtLastName = new JTextField();
	private JTextField txtIdentificationNo = new JTextField();
	private JTextField txtBirthPlace = new JTextField();
	private DatePickerComponent birthDatePicker = new DatePickerComponent();
	private final CodeValueCombobox cbMaritalStatus = new CodeValueCombobox(CodeDefinitionConstant.MARITALSTATUS);
	private final CodeValueCombobox cbBloodGroup = new CodeValueCombobox(CodeDefinitionConstant.BLOODGROUP);
	private final CodeValueCombobox cbMilitaryStatus = new CodeValueCombobox(CodeDefinitionConstant.MILITARYSTATUS);
	private OrganizationSelectionComponent organizationComponent = new OrganizationSelectionComponent();
	private final StaffTypeComponent staffTypeComponent = new StaffTypeComponent();
	private final DatePickerComponent startDatePicker = new DatePickerComponent();
	private final JTextField txtPhoneNumber = new JTextField();
	private final JTextField txtWorkPhoneNumber = new JTextField();

	public StaffAddDialog() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 5, 80, 5, 150, 5, 80, 70, 40, 40, 5, 0 };
		gridBagLayout.rowHeights = new int[] { 5, 0, 0, 0, 0, 5, 0, 0, 0, 5, 0, 5, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		JLabel lblStartDate = new JLabel("Start Date");
		JLabel lblPhoneNumber = new JLabel("Mobile Phone");
		JLabel lblWorkPhoneNumber = new JLabel("Work Phone");
		JLabel lblEmployeeNo = new JLabel("Employee No");
		JLabel lblStaffType = new JLabel("Staff Type");
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
		gbc_txtIdentificationNo.gridwidth = 3;
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
		gbc_txtLastName.gridwidth = 3;
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
		gbc_txtBirthPlace.gridwidth = 3;
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
		gbc_cbMaritalStatus.gridwidth = 3;
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
		gbc_cbMilitaryStatus.gridwidth = 3;
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
		gbc_organizationComponent.fill = GridBagConstraints.HORIZONTAL;
		gbc_organizationComponent.insets = new Insets(0, 0, 5, 5);
		gbc_organizationComponent.gridx = 3;
		gbc_organizationComponent.gridy = 6;
		getContentPane().add(organizationComponent, gbc_organizationComponent);

		GridBagConstraints gbc_lblStaffType = new GridBagConstraints();
		gbc_lblStaffType.insets = new Insets(0, 0, 5, 5);
		gbc_lblStaffType.anchor = GridBagConstraints.WEST;
		gbc_lblStaffType.gridx = 5;
		gbc_lblStaffType.gridy = 6;
		getContentPane().add(lblStaffType, gbc_lblStaffType);

		GridBagConstraints gbc_staffTypeComponent = new GridBagConstraints();
		gbc_staffTypeComponent.gridwidth = 3;
		gbc_staffTypeComponent.insets = new Insets(0, 0, 5, 5);
		gbc_staffTypeComponent.fill = GridBagConstraints.HORIZONTAL;
		gbc_staffTypeComponent.gridx = 6;
		gbc_staffTypeComponent.gridy = 6;
		getContentPane().add(staffTypeComponent, gbc_staffTypeComponent);

		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.anchor = GridBagConstraints.WEST;
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber.gridx = 1;
		gbc_lblPhoneNumber.gridy = 7;
		getContentPane().add(lblPhoneNumber, gbc_lblPhoneNumber);

		GridBagConstraints gbc_txtPhoneNumber = new GridBagConstraints();
		gbc_txtPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhoneNumber.gridx = 3;
		gbc_txtPhoneNumber.gridy = 7;
		txtPhoneNumber.setColumns(10);
		getContentPane().add(txtPhoneNumber, gbc_txtPhoneNumber);

		GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
		gbc_lblStartDate.anchor = GridBagConstraints.WEST;
		gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartDate.gridx = 5;
		gbc_lblStartDate.gridy = 7;
		getContentPane().add(lblStartDate, gbc_lblStartDate);

		GridBagConstraints gbc_startDatePicker = new GridBagConstraints();
		gbc_startDatePicker.gridwidth = 3;
		gbc_startDatePicker.insets = new Insets(0, 0, 5, 5);
		gbc_startDatePicker.fill = GridBagConstraints.BOTH;
		gbc_startDatePicker.gridx = 6;
		gbc_startDatePicker.gridy = 7;
		getContentPane().add(startDatePicker, gbc_startDatePicker);

		GridBagConstraints gbc_lblWorkPhoneNumber = new GridBagConstraints();
		gbc_lblWorkPhoneNumber.anchor = GridBagConstraints.WEST;
		gbc_lblWorkPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblWorkPhoneNumber.gridx = 1;
		gbc_lblWorkPhoneNumber.gridy = 8;
		getContentPane().add(lblWorkPhoneNumber, gbc_lblWorkPhoneNumber);

		GridBagConstraints gbc_txtWorkPhoneNumber = new GridBagConstraints();
		gbc_txtWorkPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_txtWorkPhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWorkPhoneNumber.gridx = 3;
		gbc_txtWorkPhoneNumber.gridy = 8;
		txtWorkPhoneNumber.setColumns(10);
		getContentPane().add(txtWorkPhoneNumber, gbc_txtWorkPhoneNumber);

		JLabel lblIsActive = new JLabel("Is Active?");
		GridBagConstraints gbc_lblIsActive = new GridBagConstraints();
		gbc_lblIsActive.anchor = GridBagConstraints.WEST;
		gbc_lblIsActive.insets = new Insets(0, 0, 5, 5);
		gbc_lblIsActive.gridx = 5;
		gbc_lblIsActive.gridy = 8;
		getContentPane().add(lblIsActive, gbc_lblIsActive);

		GridBagConstraints gbc_rdBtnIsActive = new GridBagConstraints();
		gbc_rdBtnIsActive.anchor = GridBagConstraints.WEST;
		gbc_rdBtnIsActive.insets = new Insets(0, 0, 5, 5);
		gbc_rdBtnIsActive.gridx = 6;
		gbc_rdBtnIsActive.gridy = 8;
		getContentPane().add(rdBtnIsActive, gbc_rdBtnIsActive);

		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 7;
		gbc_btnSave.gridy = 10;
		getContentPane().add(btnSave, gbc_btnSave);

		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 8;
		gbc_btnCancel.gridy = 10;
		getContentPane().add(btnCancel, gbc_btnCancel);

		addEvents();

		if (staffDTO != null) {
			boolean isSelected = (staffDTO.getActive() != null && staffDTO.getActive().equals("1"));

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

	class StaffAddDialogResult {
		public StaffDTO entity;

		public StaffAddDialogResult(StaffDTO entity) {
			this.entity = entity;
		}
	}

	private class DialogEventListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();

			if (cmd.equals(SAVE_EVENT)) {
				StaffDTO dto;

				if (staffDTO != null) {
					dto = staffDTO;
				} else {
					dto = new StaffDTO();

				}

				String employeeNo = txtEmployeeNo.getText();
				String firstName = txtFirstName.getText();
				String lastName = txtLastName.getText();
				String birthPlace = txtBirthPlace.getText();
				String identificationNo = txtIdentificationNo.getText();
				String phoneNumber = txtPhoneNumber.getText();
				String workPhoneNumber = txtWorkPhoneNumber.getText();
				Long bloodGroupId = cbBloodGroup.getSelectedId();
				Long genderId = cbGender.getSelectedId();
				Long maritalStatusId = cbMaritalStatus.getSelectedId();
				Long militaryStatusId = cbMilitaryStatus.getSelectedId();
				OrganizationDTO staffOrganization = organizationComponent.getSelectedOrganizationDTO();
				Long staffTitleId = staffTypeComponent.getSelectedId();
				
				Date birthDate = birthDatePicker.getDate();
				Date startDate =startDatePicker.getDate();
				
				String active = rdBtnIsActive.isSelected() ? "1" : "0";
				

			
				if (firstName.contentEquals("")) {
					showWarning("Please fill personnel first name!");
					return;
				}
				if (lastName.contentEquals("")) {
					showWarning("Please fill personnel last name!");
					return;
				}
				if (identificationNo.contentEquals("")) {
					showWarning("Please fill personnel identification no!");
					return;
				}

				if(staffOrganization==null) {
					showWarning("Please select staff organization!");
					return;
				}
				 
				dto.setEmployeNo(employeeNo);
				dto.setFirstName(firstName);
				dto.setLastName(lastName);
				dto.setBirthPlace(birthPlace);
				dto.setIdentificationNo(identificationNo);
				dto.setPhoneNumber(phoneNumber);
				dto.setWorkPhoneNumber(workPhoneNumber);
				dto.setActive(active);
				dto.setBloodGroupId(bloodGroupId);
				dto.setGenderId(genderId);
				dto.setMaritalStatusId(maritalStatusId);
				dto.setBirthDate(birthDate);
				dto.setWorkStartDate(startDate);
				dto.setMilitaryStatusId(militaryStatusId);
				dto.setOrganizationId(staffOrganization.getOrganizationId());
				dto.setStaffTitleId(staffTitleId);
				try {
					boolean isNew = dto.getStaffId() == null;

					dto = serviceHelper.saveStaffDTO(dto);
					dialogResult = new StaffAddDialogResult(dto);
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

	public void setEntity(StaffDTO entity) {
		this.staffDTO = entity;
		if (entity != null) {
			
			txtEmployeeNo.setText(entity.getEmployeNo());
			txtFirstName.setText(entity.getFirstName());
			txtBirthPlace.setText(entity.getBirthPlace());
			txtIdentificationNo.setText(entity.getIdentificationNo());
			txtLastName.setText(entity.getLastName());
			txtPhoneNumber.setText(entity.getPhoneNumber());
			txtWorkPhoneNumber.setText(entity.getWorkPhoneNumber());
			birthDatePicker.setDate(entity.getBirthDate());
			startDatePicker.setDate(entity.getWorkStartDate());
			cbBloodGroup.setItemById(entity.getBloodGroupId());
			cbGender.setItemById(entity.getGenderId());
			cbMaritalStatus.setItemById(entity.getMaritalStatusId());
			cbMilitaryStatus.setItemById(entity.getMilitaryStatusId());
			organizationComponent.setOrganizationId(entity.getOrganizationId());
			staffTypeComponent.setItemById(entity.getStaffTitleId());
			
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