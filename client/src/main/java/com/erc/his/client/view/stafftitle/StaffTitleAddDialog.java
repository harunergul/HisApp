package com.erc.his.client.view.stafftitle;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.erc.his.ClientApp;
import com.erc.his.client.component.MainDialog;
import com.erc.his.entity.StaffTitleDTO;

public class StaffTitleAddDialog extends MainDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtCode;
	private JButton btnCancel = new JButton("Cancel");
	private JButton btnSave = new JButton("Save");
	private final String SAVE_EVENT = "SAVE_EVENT";
	private final String CANCEL_EVENT = "CANCEL_EVENT";
	private final ClientApp serviceHelper = new ClientApp();

	public StaffTitleDialogResult dialogResult;
	private StaffTitleDTO entity;
	private JTextField txtName;

	public StaffTitleAddDialog() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 5, 150, 5, 97, 100, 100, 5, 0 };
		gridBagLayout.rowHeights = new int[] { 5, 0, 0, 0, 5, 0, 5, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblCode = new JLabel("Code");
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.anchor = GridBagConstraints.WEST;
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 1;
		gbc_lblCode.gridy = 1;
		getContentPane().add(lblCode, gbc_lblCode);

		txtCode = new JTextField();
		GridBagConstraints gbc_txtCode = new GridBagConstraints();
		gbc_txtCode.gridwidth = 3;
		gbc_txtCode.insets = new Insets(0, 0, 5, 5);
		gbc_txtCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCode.gridx = 3;
		gbc_txtCode.gridy = 1;
		getContentPane().add(txtCode, gbc_txtCode);
		txtCode.setColumns(10);

		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 2;
		getContentPane().add(lblName, gbc_lblName);

		txtName = new JTextField();
		txtName.setColumns(10);
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.gridwidth = 3;
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 3;
		gbc_txtName.gridy = 2;
		getContentPane().add(txtName, gbc_txtName);

		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 4;
		gbc_btnSave.gridy = 5;
		getContentPane().add(btnSave, gbc_btnSave);

		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 5;
		gbc_btnCancel.gridy = 5;
		getContentPane().add(btnCancel, gbc_btnCancel);

		addEvents();

	}

	private void addEvents() {
		DialogEventListener listener = new DialogEventListener();
		btnSave.addActionListener(listener);
		btnCancel.addActionListener(listener);

		btnSave.setActionCommand(SAVE_EVENT);
		btnCancel.setActionCommand(CANCEL_EVENT);

	}

	class StaffTitleDialogResult {
		public StaffTitleDTO entity;

		public StaffTitleDialogResult(StaffTitleDTO entity) {
			this.entity = entity;
		}
	}

	public void setEntity(StaffTitleDTO entity) {
		this.entity = entity;
		if (entity != null) {
			txtCode.setText(entity.getCode());
			txtName.setText(entity.getName());
		}
	}

	private class DialogEventListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();

			if (cmd.equals(SAVE_EVENT)) {
				StaffTitleDTO dto;

				if (entity != null) {
					dto = entity;
				} else {
					dto = new StaffTitleDTO();

				}

				String code = txtCode.getText();
				String name = txtName.getText();

				if (code.contentEquals("")) {
					showWarning("Please fill staff title code field!");
					return;
				}

				if (name.contentEquals("")) {
					showWarning("Please fill staff title name!");
					return;
				}

				dto.setCode(code);
				dto.setName(name);

				try {
					boolean isNew = dto.getStaffTitleId() == null;

					dto = serviceHelper.saveStaffTitleDTO(dto);
					dialogResult = new StaffTitleDialogResult(dto);
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
			}

		}

	}

}