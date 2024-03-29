package com.erc.his.client.view.definition.codedefinition;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.erc.his.ClientApp;
import com.erc.his.client.component.MainPanel;
import com.erc.his.client.constant.CustomEvent;
import com.erc.his.entity.CodeDefinitionDTO;

public class CodeDefinitionPanel extends MainPanel {
	private static final long serialVersionUID = -1536233362545908337L;
	private JButton btnAdd = new JButton("Add");
	private JButton btnUpdate = new JButton("Update");
	private JButton btnDelete = new JButton("Delete");
	private final JTable codeDefinitionTable = new JTable();
	private final CodeDefinitionTableModel codeDefinitionTableModel = new CodeDefinitionTableModel();
	private final JScrollPane scrollPane = new JScrollPane();

	private final String ADD_EVENT = "ADD_EVENT";
	private final String UPDATE_EVENT = "UPDATE_EVENT";
	private final String DELETE_EVENT = "DELETE_EVENT";
	private final ClientApp serviceHelper = new ClientApp();
	private CodeDefinitionDTO selectedCodeDefinitionDTO;

	public CodeDefinitionPanel() {

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
		codeDefinitionTable.setModel(codeDefinitionTableModel);
		scrollPane.setViewportView(codeDefinitionTable);

		addEvents();
		getAllPatients();

	}

	public CodeDefinitionDTO getSelectedCodeDefinitionDTO() {
		return selectedCodeDefinitionDTO;
	}

	public void setSelectedCodeDefinitionDTO(CodeDefinitionDTO selectedCodeDefinitionDTO) {
		this.selectedCodeDefinitionDTO = selectedCodeDefinitionDTO;
	}

	private void getAllPatients() {
		ArrayList<CodeDefinitionDTO> list;
		try {
			list = serviceHelper.getAllCodeDefinitions();
			codeDefinitionTableModel.setListData(list);
			codeDefinitionTableModel.fireTableDataChanged();
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

		codeDefinitionTable.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent mouseEvent) {
				Point point = mouseEvent.getPoint();
				int row = codeDefinitionTable.rowAtPoint(point);

				if (codeDefinitionTable.getSelectedRow() != -1) {
					selectedCodeDefinitionDTO = codeDefinitionTableModel.getListData().get(row);
					setActionCommand(CustomEvent.CODE_DEFINITION_SELECTED); //$NON-NLS-1$
					fireActionPerformed();
				}
			}
		});

	}

	private class PanelEventListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();

			if (cmd.equals(ADD_EVENT)) {
				CodeDefinitionDialog dialog = new CodeDefinitionDialog();
				dialog.setModal(true);
				dialog.setSize(560, 250);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);

				if (dialog.dialogResult != null) {
					CodeDefinitionDTO codeDefinitionDTO = dialog.dialogResult.codeDefinitionDTO;
					codeDefinitionTableModel.getListData().add(codeDefinitionDTO);
					codeDefinitionTableModel.fireTableDataChanged();
				}

			} else if (cmd.equals(UPDATE_EVENT)) {

				int selectedRow = codeDefinitionTable.getSelectedRow();
				if (selectedRow == -1) {
					showWarning("Please select a row for update operation!");
					return;
				}

				CodeDefinitionDTO codeDefinitionDTO = codeDefinitionTableModel.getListData().get(selectedRow);
				CodeDefinitionDialog dialog = new CodeDefinitionDialog();
				dialog.setModal(true);
				dialog.setSize(560, 250);
				dialog.setCodeDefinition(codeDefinitionDTO);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);

				if (dialog.dialogResult != null) {
					codeDefinitionDTO = dialog.dialogResult.codeDefinitionDTO;
					codeDefinitionTableModel.getListData().set(selectedRow, codeDefinitionDTO);
					codeDefinitionTableModel.fireTableDataChanged();
				}

			} else if (cmd.equals(DELETE_EVENT)) {
				int selectedRow = codeDefinitionTable.getSelectedRow();
				if (selectedRow == -1) {
					showWarning("Please select a row for delete operation!");
					return;
				}

				CodeDefinitionDTO codeDefinitionDTO = codeDefinitionTableModel.getListData().get(selectedRow);
				try {
					serviceHelper.deleteCodeDefinition(codeDefinitionDTO);
					codeDefinitionTableModel.getListData().remove(codeDefinitionDTO);
					codeDefinitionTableModel.fireTableDataChanged();
				} catch (Exception ee) {
					ee.printStackTrace();
					showError("Cannot delete code definition!");

				}

			}

		}

	}

}
