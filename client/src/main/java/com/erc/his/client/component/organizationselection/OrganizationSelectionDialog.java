package com.erc.his.client.component.organizationselection;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.erc.his.ClientApp;
import com.erc.his.client.component.AqButton;
import com.erc.his.client.component.ButtonIcon;
import com.erc.his.client.component.MainDialog;
import com.erc.his.entity.OrganizationDTO;

public class OrganizationSelectionDialog extends MainDialog {
	private static final long serialVersionUID = 1L;
	private JTable tableOrganization = new JTable();
	private OrganizationSelectionTableModel tableModel = new OrganizationSelectionTableModel();
	private AqButton btnSelect = new AqButton("Select", ButtonIcon.CHECK);
	private AqButton btnCancel = new AqButton("Cancel", ButtonIcon.CLOSE);
	private OrganizationDTO selectedOrganizationDTO = null;
	private String SELECT_EVENT = "SELECT_EVENT";
	private String CANCEL_EVENT = "CANCEL_EVENT";

	public OrganizationSelectionDialog() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 10, 0, 0, 0, 10, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 0, 10, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);

		scrollPane.setViewportView(tableOrganization);

		tableOrganization.setModel(tableModel);

		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.insets = new Insets(0, 0, 5, 5);
		gbc_btnSelect.gridx = 2;
		gbc_btnSelect.gridy = 2;
		getContentPane().add(btnSelect, gbc_btnSelect);

		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 2;
		getContentPane().add(btnCancel, gbc_btnCancel);

		addEventListeners();
		getAllOrganizations();
	}

	public OrganizationDTO getSelectedOrganizationDTO() {
		return selectedOrganizationDTO;
	}

	public void setSelectedOrganizationDTO(OrganizationDTO selectedOrganizationDTO) {
		this.selectedOrganizationDTO = selectedOrganizationDTO;
	}

	private void getAllOrganizations() {
		ClientApp app = new ClientApp();
		try {
			ArrayList<OrganizationDTO> organizations = app.getAllOrganizations();
			tableModel.setListData(organizations);
			tableModel.fireTableDataChanged();
		} catch (Exception e) { 
			e.printStackTrace();
		}

	}

	private void addEventListeners() {

		DialogEventListener listener = new DialogEventListener();
		btnSelect.addActionListener(listener);
		btnCancel.addActionListener(listener);

		tableOrganization.addMouseListener(listener);

		btnSelect.setActionCommand(SELECT_EVENT);
		btnCancel.setActionCommand(CANCEL_EVENT);

	}

	public class DialogEventListener extends MouseAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String actionCommand = e.getActionCommand();
			if (actionCommand.equals(SELECT_EVENT)) {
				int selectedRow = tableOrganization.getSelectedRow();
				if (selectedRow == -1) {
					showWarning("Please select an organization!");
					return;
				} else {
					selectOrganization(selectedRow);
				}
			}else if(actionCommand.equals(CANCEL_EVENT)) {
				setSelectedOrganizationDTO(null);
				dispose();
			}	

		}

		public void mousePressed(MouseEvent mouseEvent) {
			JTable table = (JTable) mouseEvent.getSource();
			Point point = mouseEvent.getPoint();
			int selectedRow = table.rowAtPoint(point);
			if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
				selectOrganization(selectedRow);
			}
		}

		private void selectOrganization(int selectedRow) {
			selectedOrganizationDTO = tableModel.getListData().get(selectedRow);
			dispose();
		}
	}
}
