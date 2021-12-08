package com.erc.his.client.view.definition;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import com.erc.his.client.component.MainPanel;
import com.erc.his.client.view.definition.codedefinition.CodeDefinitionPanel;
import com.erc.his.client.view.definition.codevalue.CodeValuePanel;

public class ParameterDefinitionPanel extends MainPanel {
	private static final long serialVersionUID = 1L;
	private CodeDefinitionPanel panelCodeDefinition = new CodeDefinitionPanel();
	private CodeValuePanel panelCodeValue = new CodeValuePanel();
	
	public ParameterDefinitionPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		GridBagConstraints gbc_panelCodeDefinition = new GridBagConstraints();
		gbc_panelCodeDefinition.fill = GridBagConstraints.BOTH;
		gbc_panelCodeDefinition.insets = new Insets(0, 0, 5, 0);
		gbc_panelCodeDefinition.gridx = 0;
		gbc_panelCodeDefinition.gridy = 0;
		add(panelCodeDefinition, gbc_panelCodeDefinition);
		
		
		GridBagConstraints gbc_panelCodeValue = new GridBagConstraints();
		gbc_panelCodeValue.fill = GridBagConstraints.BOTH;
		gbc_panelCodeValue.gridx = 0;
		gbc_panelCodeValue.gridy = 1;
		add(panelCodeValue, gbc_panelCodeValue);
		
		addEvents();
	}

	private void addEvents() {
  
	}

	 
	

}
