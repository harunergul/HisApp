package com.erc.his.client.view.codedefinition;

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
import com.erc.his.entity.CodeDefinitionDTO;

public class CodeDefinitionDialog extends MainDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtCodeDefinition;
	private JTextArea txtDescription;
	private JRadioButton rdBtnIsActive = new JRadioButton("");
	private JButton btnCancel = new JButton("Cancel");
	private JButton btnSave = new JButton("Save");
	private final String SAVE_EVENT = "SAVE_EVENT";
	private final String CANCEL_EVENT = "CANCEL_EVENT";
	private final String IS_ACTIVE_EVENT = "IS_ACTIVE_EVENT";
	private final ClientApp serviceHelper = new ClientApp();

	public CodeDefintionDialogResult dialogResult;
	private CodeDefinitionDTO codeDefinition;

	public CodeDefinitionDialog() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 5, 150, 5, 97, 100, 100, 5, 0 };
		gridBagLayout.rowHeights = new int[] { 5, 0, 0, 0, 5, 0, 5, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblCodeDefinition = new JLabel("Code Definition");
		GridBagConstraints gbc_lblCodeDefinition = new GridBagConstraints();
		gbc_lblCodeDefinition.anchor = GridBagConstraints.WEST;
		gbc_lblCodeDefinition.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodeDefinition.gridx = 1;
		gbc_lblCodeDefinition.gridy = 1;
		getContentPane().add(lblCodeDefinition, gbc_lblCodeDefinition);

		txtCodeDefinition = new JTextField();
		GridBagConstraints gbc_txtCodeDefinition = new GridBagConstraints();
		gbc_txtCodeDefinition.gridwidth = 3;
		gbc_txtCodeDefinition.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodeDefinition.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodeDefinition.gridx = 3;
		gbc_txtCodeDefinition.gridy = 1;
		getContentPane().add(txtCodeDefinition, gbc_txtCodeDefinition);
		txtCodeDefinition.setColumns(10);

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

		if (codeDefinition != null) {
			boolean isSelected = (codeDefinition.getActive() != null && codeDefinition.getActive().equals("1"));

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

	class CodeDefintionDialogResult {
		public CodeDefinitionDTO codeDefinitionDTO;

		public CodeDefintionDialogResult(CodeDefinitionDTO entity) {
			this.codeDefinitionDTO = entity;
		}
	}

	private class DialogEventListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();

			if (cmd.equals(SAVE_EVENT)) {
				CodeDefinitionDTO codeDefinitionDTO;

				if (codeDefinition != null) {
					codeDefinitionDTO = codeDefinition;
				} else {
					codeDefinitionDTO = new CodeDefinitionDTO();
				}

				String codeDef = txtCodeDefinition.getText();
				String description = txtDescription.getText();

				String active = rdBtnIsActive.isSelected() ? "1" : "0";

				if (codeDef.contentEquals("")) {
					showWarning("Please fill Code Definition field!");
					return;
				}

				if (description.contentEquals("")) {
					showWarning("Please fill description!");
					return;
				}

				codeDefinitionDTO.setCodeDefinition(codeDef);
				codeDefinitionDTO.setDescription(description);
				codeDefinitionDTO.setActive(active);

				try {
					boolean isNew = codeDefinitionDTO.getCodeDefinitionId() == null;

					codeDefinitionDTO = serviceHelper.saveCodeDefinition(codeDefinitionDTO);
					dialogResult = new CodeDefintionDialogResult(codeDefinitionDTO);
					if (isNew) {
						showSuccess("Successfully created.");
					} else {
						showSuccess("Successfully updated.");
					}
					dispose();

				} catch (Exception e1) {
					showError("Error during the saving!");
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

	public void setCodeDefinition(CodeDefinitionDTO entity) {
		this.codeDefinition = entity;
		if (codeDefinition != null) {
			txtCodeDefinition.setEditable(false);
			txtCodeDefinition.setText(entity.getCodeDefinition());
			txtDescription.setText(entity.getDescription());
			boolean isSelected = entity.getActive().equals("1") ? true : false;
			rdBtnIsActive.setSelected(isSelected);
		}
	}

}
