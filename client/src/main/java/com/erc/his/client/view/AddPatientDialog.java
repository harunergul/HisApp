package com.erc.his.client.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JComboBox;

public class AddPatientDialog extends JPanel {
	private JTextField txtPatientNo;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtIdentificationNo;
	private UtilDateModel model = new UtilDateModel();
	private JDatePanelImpl datePanel = new JDatePanelImpl(model);
	private JDatePickerImpl dtarihidatePicker = new JDatePickerImpl(datePanel);

	//paneldtarihi.add(dtarihidatePicker);
	
	
	
	
	public AddPatientDialog() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblMaritalStatus = new JLabel("Marital Status");
		GridBagConstraints gbc_lblMaritalStatus = new GridBagConstraints();
		gbc_lblMaritalStatus.anchor = GridBagConstraints.EAST;
		gbc_lblMaritalStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaritalStatus.gridx = 4;
		gbc_lblMaritalStatus.gridy = 1;
		add(lblMaritalStatus, gbc_lblMaritalStatus);
		
		JComboBox cbMaritalStatus = new JComboBox();
		GridBagConstraints gbc_cbMaritalStatus = new GridBagConstraints();
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
		
		JComboBox cbBloodGroup = new JComboBox();
		GridBagConstraints gbc_cbBloodGroup = new GridBagConstraints();
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
		
		JComboBox cbGender = new JComboBox();
		GridBagConstraints gbc_cbGender = new GridBagConstraints();
		gbc_cbGender.insets = new Insets(0, 0, 5, 5);
		gbc_cbGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbGender.gridx = 5;
		gbc_cbGender.gridy = 3;
		add(cbGender, gbc_cbGender);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		GridBagConstraints gbc_txtLastName = new GridBagConstraints();
		gbc_txtLastName.insets = new Insets(0, 0, 0, 5);
		gbc_txtLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastName.gridx = 2;
		gbc_txtLastName.gridy = 4;
		add(txtLastName, gbc_txtLastName);
		
		JLabel lblBirthDate = new JLabel("Birth Date");
		GridBagConstraints gbc_lblBirthDate = new GridBagConstraints();
		gbc_lblBirthDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblBirthDate.gridx = 4;
		gbc_lblBirthDate.gridy = 4;
		add(lblBirthDate, gbc_lblBirthDate);
		
		JPanel panelDate = new JPanel();
		GridBagConstraints gbc_panelDate = new GridBagConstraints();
		gbc_panelDate.insets = new Insets(0, 0, 0, 5);
		gbc_panelDate.fill = GridBagConstraints.BOTH;
		gbc_panelDate.gridx = 5;
		gbc_panelDate.gridy = 4;
		add(panelDate, gbc_panelDate);
		panelDate.add(dtarihidatePicker);
	}

}
