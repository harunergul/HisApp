package com.erc.his.client.view.codevalue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.erc.his.ClientApp;
import com.erc.his.client.component.MainDialog;
import com.erc.his.entity.CodeValueDTO;

public class CodeValueDialog extends MainDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtCode;
	private JTextArea txtDescription;
	private JRadioButton rdBtnIsActive = new JRadioButton("");
	private JButton btnCancel = new JButton("Cancel");
	private JButton btnSave = new JButton("Save");
	private final String SAVE_EVENT = "SAVE_EVENT";
	private final String CANCEL_EVENT = "CANCEL_EVENT";
	private final String IS_ACTIVE_EVENT = "IS_ACTIVE_EVENT";
	private final ClientApp serviceHelper = new ClientApp();

	public CodeValueDialogResult dialogResult;
	private CodeValueDTO codeValue;
	private Long codeDefinitionId;

	public CodeValueDialog() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 5, 150, 5, 97, 100, 100, 5, 0 };
		gridBagLayout.rowHeights = new int[] { 5, 0, 0, 0, 5, 0, 5, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblCodeValue = new JLabel("Code Value");
		GridBagConstraints gbc_lblCodeValue = new GridBagConstraints();
		gbc_lblCodeValue.anchor = GridBagConstraints.WEST;
		gbc_lblCodeValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodeValue.gridx = 1;
		gbc_lblCodeValue.gridy = 1;
		getContentPane().add(lblCodeValue, gbc_lblCodeValue);

		txtCode = new JTextField();
		GridBagConstraints gbc_txtCode = new GridBagConstraints();
		gbc_txtCode.gridwidth = 3;
		gbc_txtCode.insets = new Insets(0, 0, 5, 5);
		gbc_txtCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCode.gridx = 3;
		gbc_txtCode.gridy = 1;
		getContentPane().add(txtCode, gbc_txtCode);
		txtCode.setColumns(10);

		JLabel lblDescription = new JLabel("Description");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.WEST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 1;
		gbc_lblDescription.gridy = 2;
		getContentPane().add(lblDescription, gbc_lblDescription);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 2;
		getContentPane().add(scrollPane, gbc_scrollPane);

		txtDescription = new JTextArea();
		scrollPane.setViewportView(txtDescription);
		txtDescription.setRows(40);
		txtDescription.setColumns(10);

		JLabel lblIsActive = new JLabel("Is Active?");
		GridBagConstraints gbc_lblIsActive = new GridBagConstraints();
		gbc_lblIsActive.anchor = GridBagConstraints.WEST;
		gbc_lblIsActive.insets = new Insets(0, 0, 5, 5);
		gbc_lblIsActive.gridx = 1;
		gbc_lblIsActive.gridy = 3;
		getContentPane().add(lblIsActive, gbc_lblIsActive);

		GridBagConstraints gbc_rdBtnIsActive = new GridBagConstraints();
		gbc_rdBtnIsActive.anchor = GridBagConstraints.WEST;
		gbc_rdBtnIsActive.insets = new Insets(0, 0, 5, 5);
		gbc_rdBtnIsActive.gridx = 3;
		gbc_rdBtnIsActive.gridy = 3;
		getContentPane().add(rdBtnIsActive, gbc_rdBtnIsActive);

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

		if (codeValue != null) {
			boolean isSelected = (codeValue.getActive() != null && codeValue.getActive().equals("1"));

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

	class CodeValueDialogResult {
		public CodeValueDTO codeValueDTO;

		public CodeValueDialogResult(CodeValueDTO entity) {
			this.codeValueDTO = entity;
		}
	}

	private class DialogEventListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();

			if (cmd.equals(SAVE_EVENT)) {
				CodeValueDTO codeValueDTO;

				if (codeValue != null) {
					codeValueDTO = codeValue;
				} else {
					codeValueDTO = new CodeValueDTO();
					codeValueDTO.setCodeDefinitionId(codeDefinitionId);
				}

				String codeDef = txtCode.getText();
				String description = txtDescription.getText();

				String active = rdBtnIsActive.isSelected() ? "1" : "0";

				if (codeDef.contentEquals("")) {
					showWarning("Please fill Code value field!");
					return;
				}

				if (description.contentEquals("")) {
					showWarning("Please fill description!");
					return;
				}

				codeValueDTO.setCode(codeDef);
				codeValueDTO.setDescription(description);
				codeValueDTO.setActive(active);

				try {
					boolean isNew = codeValueDTO.getCodeValueId() == null;

					codeValueDTO = serviceHelper.saveCodeValueDTO(codeValueDTO);
					dialogResult = new CodeValueDialogResult(codeValueDTO);
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

	public void setCodeDefinition(CodeValueDTO entity) {
		this.codeValue = entity;
		if (codeValue != null) {
			txtCode.setEditable(false);
			txtCode.setText(entity.getCode());
			txtDescription.setText(entity.getDescription());
			boolean isSelected = entity.getActive().equals("1") ? true : false;
			rdBtnIsActive.setSelected(isSelected);
		}
	}

	public void setCodeDefinitionId(Long codeDefinitionId) {
		this.codeDefinitionId = codeDefinitionId;
	}

}
