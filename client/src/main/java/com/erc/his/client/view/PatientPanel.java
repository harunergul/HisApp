package com.erc.his.client.view;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;

import com.erc.his.ClientApp;
import com.erc.his.client.component.MainPanel;
import com.erc.his.entity.PatientDTO;

import javax.swing.JScrollPane;

public class PatientPanel extends MainPanel {

	private static final long serialVersionUID = -1536233362545908337L;
	private JButton btnAdd = new JButton("Add");
	private JButton btnUpdate = new JButton("Update");
	private JButton btnDelete = new JButton("Delete");
	private final JTable patientTable = new JTable();
	private final PatientTableModel patientTableModel = new PatientTableModel();
	private final JScrollPane scrollPane = new JScrollPane();

	private final String ADD_EVENT = "ADD_EVENT";
	private final String UPDATE_EVENT = "UPDATE_EVENT";
	private final String DELETE_EVENT = "DELETE_EVENT";
	private final ClientApp serviceHelper = new ClientApp();

	public PatientPanel() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 5, 0, 0, 0, 0, 5, 0 };
		gridBagLayout.rowHeights = new int[] { 5, 0, 0, 5, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 2;
		gbc_btnAdd.gridy = 1;
		add(btnAdd, gbc_btnAdd);

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 1;
		add(btnUpdate, gbc_btnNewButton);

		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 1;
		add(btnDelete, gbc_btnNewButton_1);

		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.gridwidth = 4;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 2;
		add(scrollPane, gbc_table);
		patientTable.setModel(patientTableModel);
		scrollPane.setViewportView(patientTable);

		addEvents();
		getAllPatients();

	}

	private void getAllPatients() {
		ArrayList<PatientDTO> patientList = serviceHelper.getAllPatients();
		patientTableModel.setListData(patientList);
		patientTableModel.fireTableDataChanged();
	}

	private void addEvents() {
		PatientPanelEventListener listener = new PatientPanelEventListener();
		btnAdd.addActionListener(listener);
		btnUpdate.addActionListener(listener);
		btnDelete.addActionListener(listener);

		btnAdd.setActionCommand(ADD_EVENT);
		btnUpdate.setActionCommand(UPDATE_EVENT);
		btnDelete.setActionCommand(DELETE_EVENT);

	}

	private class PatientPanelEventListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();

			if (cmd.equals(ADD_EVENT)) {
				AddPatientDialog dialog = new AddPatientDialog();
				dialog.setModal(true);
				dialog.setSize(560, 250);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);

				if (dialog.dialogResult != null) {
					PatientDTO patientDTO = dialog.dialogResult.patientDTO;
					patientTableModel.getListData().add(patientDTO);
					patientTableModel.fireTableDataChanged();
				}

			} else if (cmd.equals(UPDATE_EVENT)) {

				int selectedRow = patientTable.getSelectedRow();
				if (selectedRow == -1) {
					showWarning("Please select a row for update operation!");
					return;
				}

				PatientDTO patient = patientTableModel.getListData().get(selectedRow);
				AddPatientDialog dialog = new AddPatientDialog();
				dialog.setModal(true);
				dialog.setSize(560, 250);
				dialog.setPatient(patient);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);

				if (dialog.dialogResult != null) {
					PatientDTO patientDTO = dialog.dialogResult.patientDTO;
					patientTableModel.getListData().set(selectedRow, patientDTO);
					patientTableModel.fireTableDataChanged();
				}

			} else if (cmd.equals(DELETE_EVENT)) {
				int selectedRow = patientTable.getSelectedRow();
				if (selectedRow == -1) {
					showWarning("Please select a row for delete operation!");
					return;
				}

				PatientDTO patientDTO = patientTableModel.getListData().get(selectedRow);
				try {
					serviceHelper.deletePatient(patientDTO);
					patientTableModel.getListData().remove(patientDTO);
					patientTableModel.fireTableDataChanged();
				} catch (Exception ee) {
					ee.printStackTrace();
					showError("Cannot delete patient!");

				}

			}

		}

	}
}
