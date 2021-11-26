package com.erc.his.client.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.erc.his.ClientApp;
import com.erc.his.client.component.DatePickerComponent;
import com.erc.his.client.component.MainDialog;
import com.erc.his.entity.PatientDTO;
import com.erc.his.enums.BloodGroup;
import com.erc.his.enums.Gender;
import com.erc.his.enums.MaritalStatus;

public class AddPatientDialog extends MainDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtPatientNo;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtIdentificationNo;
	private JComboBox<String> cbGender = new JComboBox<String>();
	private JComboBox<String> cbBloodGroup = new JComboBox<String>();
	private JComboBox<String> cbMaritalStatus = new JComboBox<String>();
	private DatePickerComponent birthDateDatePicker = new DatePickerComponent();
	private JButton btnCancel = new JButton("Cancel");
	private JButton btnSave = new JButton("Save");
	private final String choose = "--Choose--";
	private final String SAVE_EVENT = "SAVE_EVENT";
	private final String CANCEL_EVENT = "CANCEL_EVENT";
	private final ClientApp serviceHelper = new ClientApp();

	public AddPatientDialog() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 5, 0, 0, 100, 100, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 5, 0, 0, 0, 0, 0, 0, 5, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Patient No");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		txtPatientNo = new JTextField();
		GridBagConstraints gbc_txtPatientNo = new GridBagConstraints();
		gbc_txtPatientNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtPatientNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPatientNo.gridx = 2;
		gbc_txtPatientNo.gridy = 1;
		add(txtPatientNo, gbc_txtPatientNo);
		txtPatientNo.setColumns(10);
		txtPatientNo.setEditable(false);

		JLabel lblMaritalStatus = new JLabel("Marital Status");
		GridBagConstraints gbc_lblMaritalStatus = new GridBagConstraints();
		gbc_lblMaritalStatus.anchor = GridBagConstraints.EAST;
		gbc_lblMaritalStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaritalStatus.gridx = 4;
		gbc_lblMaritalStatus.gridy = 1;
		add(lblMaritalStatus, gbc_lblMaritalStatus);

		
		GridBagConstraints gbc_cbMaritalStatus = new GridBagConstraints();
		gbc_cbMaritalStatus.gridwidth = 3;
		gbc_cbMaritalStatus.insets = new Insets(0, 0, 5, 5);
		gbc_cbMaritalStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbMaritalStatus.gridx = 5;
		gbc_cbMaritalStatus.gridy = 1;
		add(cbMaritalStatus, gbc_cbMaritalStatus);

		JLabel lblNewLabel_1_1 = new JLabel("Identification No");
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 2;
		add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		txtIdentificationNo = new JTextField();
		txtIdentificationNo.setColumns(10);
		GridBagConstraints gbc_txtIdentificationNo = new GridBagConstraints();
		gbc_txtIdentificationNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtIdentificationNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdentificationNo.gridx = 2;
		gbc_txtIdentificationNo.gridy = 2;
		add(txtIdentificationNo, gbc_txtIdentificationNo);

		JLabel lblBloodGroup = new JLabel("Blood Group");
		GridBagConstraints gbc_lblBloodGroup = new GridBagConstraints();
		gbc_lblBloodGroup.anchor = GridBagConstraints.EAST;
		gbc_lblBloodGroup.insets = new Insets(0, 0, 5, 5);
		gbc_lblBloodGroup.gridx = 4;
		gbc_lblBloodGroup.gridy = 2;
		add(lblBloodGroup, gbc_lblBloodGroup);

		GridBagConstraints gbc_cbBloodGroup = new GridBagConstraints();
		gbc_cbBloodGroup.gridwidth = 3;
		gbc_cbBloodGroup.insets = new Insets(0, 0, 5, 5);
		gbc_cbBloodGroup.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbBloodGroup.gridx = 5;
		gbc_cbBloodGroup.gridy = 2;
		add(cbBloodGroup, gbc_cbBloodGroup);

		JLabel lblNewLabel_1 = new JLabel("First Name");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		GridBagConstraints gbc_txtFirstName = new GridBagConstraints();
		gbc_txtFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirstName.gridx = 2;
		gbc_txtFirstName.gridy = 3;
		add(txtFirstName, gbc_txtFirstName);

		JLabel lblGender = new JLabel("Gender");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.EAST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 4;
		gbc_lblGender.gridy = 3;
		add(lblGender, gbc_lblGender);


		GridBagConstraints gbc_cbGender = new GridBagConstraints();
		gbc_cbGender.gridwidth = 3;
		gbc_cbGender.insets = new Insets(0, 0, 5, 5);
		gbc_cbGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbGender.gridx = 5;
		gbc_cbGender.gridy = 3;
		add(cbGender, gbc_cbGender);

		JLabel lblNewLabel_2 = new JLabel("Last Name");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		GridBagConstraints gbc_txtLastName = new GridBagConstraints();
		gbc_txtLastName.insets = new Insets(0, 0, 5, 5);
		gbc_txtLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastName.gridx = 2;
		gbc_txtLastName.gridy = 4;
		add(txtLastName, gbc_txtLastName);

		JLabel lblBirthDate = new JLabel("Birth Date");
		GridBagConstraints gbc_lblBirthDate = new GridBagConstraints();
		gbc_lblBirthDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthDate.gridx = 4;
		gbc_lblBirthDate.gridy = 4;
		add(lblBirthDate, gbc_lblBirthDate);

		GridBagConstraints gbc_panelDate = new GridBagConstraints();
		gbc_panelDate.gridwidth = 3;
		gbc_panelDate.insets = new Insets(0, 0, 5, 5);
		gbc_panelDate.fill = GridBagConstraints.BOTH;
		gbc_panelDate.gridx = 5;
		gbc_panelDate.gridy = 4;
		add(birthDateDatePicker, gbc_panelDate);

		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 6;
		gbc_btnSave.gridy = 6;
		add(btnSave, gbc_btnSave);

		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 7;
		gbc_btnCancel.gridy = 6;
		add(btnCancel, gbc_btnCancel);

		
		cbMaritalStatus.addItem(choose);
		cbBloodGroup.addItem(choose);
		cbGender.addItem(choose);
		
		MaritalStatus.getAll().stream().forEach(item -> cbMaritalStatus.addItem(item));
		BloodGroup.getAll().stream().forEach(item-> cbBloodGroup.addItem(item));
		Gender.getAll().stream().forEach(item-> cbGender.addItem(item));
		

		addEvents();
		

	}

	private void addEvents() {
		AddPatientDialogEventListener listener = new AddPatientDialogEventListener();
		btnSave.addActionListener(listener);
		btnCancel.addActionListener(listener);

		btnSave.setActionCommand(SAVE_EVENT);
		btnCancel.setActionCommand(CANCEL_EVENT);

	}

	private class AddPatientDialogEventListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();

			if (cmd.equals(SAVE_EVENT)) {
				PatientDTO patientDTO = new PatientDTO();

				String firstName = txtFirstName.getText();
				String lastName = txtLastName.getText();
				String identificationNo = txtIdentificationNo.getText();
				String bloodGroup = (String)cbBloodGroup.getSelectedItem();
				String maritalStatus = (String)cbMaritalStatus.getSelectedItem();
				String gender =(String) cbGender.getSelectedItem();
				Date birthDate =  birthDateDatePicker.getDate();
				

				if (firstName.contentEquals("")) {
					showWarning("Please fill patient name!");
					return;
				}

				if (lastName.contentEquals("")) {
					showWarning("Please fill patient last name!");
					return;
				}

				if (identificationNo.contentEquals("")) {
					showWarning("Please fill patient identification no!");
					return;
				}

				if(cbBloodGroup.getSelectedIndex()==0) {
					showWarning("Please select blood group!");
					return;
				}
				
				if(cbMaritalStatus.getSelectedIndex()==0) {
					showWarning("Please select marital status!");
					return;
				}
				
				if(cbGender.getSelectedIndex()==0) {
					showWarning("Please select patient gender!");
					return;
				}
				
				if(birthDateDatePicker.getDate()==null) {
					showWarning("Please select birth date!");
					return;
				}
				
				patientDTO.setFirstName(firstName);
				patientDTO.setLastName(lastName);
				patientDTO.setIdentificationNo(identificationNo);
				patientDTO.setBloodGroup(bloodGroup);
				patientDTO.setGender(gender);
				patientDTO.setMaritalStatus(maritalStatus);

				try {
					patientDTO = serviceHelper.savePatient(patientDTO);
				} catch (Exception e1) {
					showError("Error during the saving!");
					e1.printStackTrace();
				}
			} else if (cmd.equals(CANCEL_EVENT)) {
				dispose();
			}

		}

	}

}
