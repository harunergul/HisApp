package com.erc.his.client.view.appointment;

import com.erc.his.client.component.MainDialog;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class AddAppointmentDialog extends MainDialog {
	private static final long serialVersionUID = 558785195606294159L;
	private JTextField txtAppointmentDate = new JTextField();

	public AddAppointmentDialog() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblAppointmentDate = new JLabel("AppointmentDate");
		GridBagConstraints gbc_lblAppointmentDate = new GridBagConstraints();
		gbc_lblAppointmentDate.anchor = GridBagConstraints.WEST;
		gbc_lblAppointmentDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblAppointmentDate.gridx = 1;
		gbc_lblAppointmentDate.gridy = 1;
		getContentPane().add(lblAppointmentDate, gbc_lblAppointmentDate);

		GridBagConstraints gbc_txtAppointmentDate = new GridBagConstraints();
		gbc_txtAppointmentDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtAppointmentDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAppointmentDate.gridx = 4;
		gbc_txtAppointmentDate.gridy = 1;
		getContentPane().add(txtAppointmentDate, gbc_txtAppointmentDate);
		txtAppointmentDate.setColumns(10);
		
		JLabel lblPatient = new JLabel("Patient");
		GridBagConstraints gbc_lblPatient = new GridBagConstraints();
		gbc_lblPatient.anchor = GridBagConstraints.WEST;
		gbc_lblPatient.insets = new Insets(0, 0, 0, 5);
		gbc_lblPatient.gridx = 1;
		gbc_lblPatient.gridy = 2;
		getContentPane().add(lblPatient, gbc_lblPatient);
	}

}
