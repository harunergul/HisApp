package com.erc.his.client.view.stafftitle;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.erc.his.ClientApp;
import com.erc.his.client.component.MainPanel;
import com.erc.his.client.view.organization.OrganizationAddDialog;
import com.erc.his.client.view.organization.OrganizationTableModel;
import com.erc.his.entity.OrganizationDTO;
import com.erc.his.entity.StaffTitleDTO;

public class StaffTitlePanel extends MainPanel {

	private static final long serialVersionUID = -1536233362545908337L;
	private JButton btnAdd = new JButton("Add");
	private JButton btnUpdate = new JButton("Update");
	private JButton btnDelete = new JButton("Delete");
	private final JTable table = new JTable();
	private final StaffTitleTableModel tableModel = new StaffTitleTableModel();
	private final JScrollPane scrollPane = new JScrollPane();

	private final String ADD_EVENT = "ADD_EVENT";
	private final String UPDATE_EVENT = "UPDATE_EVENT";
	private final String DELETE_EVENT = "DELETE_EVENT";
	private final ClientApp serviceHelper = new ClientApp();

	public StaffTitlePanel() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 5, 100, 0, 0, 0, 5, 0 };
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
		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		addEvents();
		getAllStaffTitles();

	}

	public void getAllStaffTitles() {
		ArrayList<StaffTitleDTO> list;
		try {
			list = serviceHelper.getAllStaffTitles();
			tableModel.setListData(list);
			tableModel.fireTableDataChanged();
		} catch (Exception e) {
			showError(e.getLocalizedMessage());
		}

	}

	private void addEvents() {
		PanelEventListener listener = new PanelEventListener();
		btnAdd.addActionListener(listener);
		btnUpdate.addActionListener(listener);
		btnDelete.addActionListener(listener);

		btnAdd.setActionCommand(ADD_EVENT);
		btnUpdate.setActionCommand(UPDATE_EVENT);
		btnDelete.setActionCommand(DELETE_EVENT);
	}

	private class PanelEventListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();

			if (cmd.equals(ADD_EVENT)) {
				StaffTitleAddDialog dialog = new StaffTitleAddDialog();
				dialog.setModal(true);
				dialog.setSize(560, 250);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);

				if (dialog.dialogResult != null) {
					StaffTitleDTO dto = dialog.dialogResult.entity;
					tableModel.getListData().add(dto);
					tableModel.fireTableDataChanged();
				}

			} else if (cmd.equals(UPDATE_EVENT)) {

				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					showWarning("Please select a row for update operation!");
					return;
				}

				StaffTitleDTO dto = tableModel.getListData().get(selectedRow);
				StaffTitleAddDialog dialog = new StaffTitleAddDialog();
				dialog.setModal(true);
				dialog.setSize(560, 250);
				dialog.setEntity(dto);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);

				if (dialog.dialogResult != null) {
					tableModel.getListData().set(selectedRow, dialog.dialogResult.entity);
					tableModel.fireTableDataChanged();
				}

			} else if (cmd.equals(DELETE_EVENT)) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					showWarning("Please select a row for delete operation!");
					return;
				}

				StaffTitleDTO dto = tableModel.getListData().get(selectedRow);
				try {
					serviceHelper.deleteStaffTitleDTO(dto);
					tableModel.getListData().remove(dto);
					tableModel.fireTableDataChanged();
				} catch (Exception ee) {
					ee.printStackTrace();
					showError("Cannot delete staff title!");

				}
			}
		}
	}

}
