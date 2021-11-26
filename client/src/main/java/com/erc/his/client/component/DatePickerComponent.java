package com.erc.his.client.component;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.BorderLayout;

public class DatePickerComponent extends MainPanel {
 
	private static final long serialVersionUID = 1L;
	private UtilDateModel model = new UtilDateModel();
	private JDatePanelImpl datePanel = new JDatePanelImpl(model);
	private JDatePickerImpl dtarihidatePicker = new JDatePickerImpl(datePanel);
	
	
	public DatePickerComponent() {
		setLayout(new BorderLayout(0, 0));
		add(dtarihidatePicker);
	
	}
	
}
