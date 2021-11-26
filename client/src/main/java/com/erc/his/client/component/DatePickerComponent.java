package com.erc.his.client.component;

import java.awt.BorderLayout;
import java.util.Date;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class DatePickerComponent extends MainPanel {

	private static final long serialVersionUID = 1L;
	private UtilDateModel model = new UtilDateModel();
	private JDatePanelImpl datePanel = new JDatePanelImpl(model);
	private JDatePickerImpl dtarihidatePicker = new JDatePickerImpl(datePanel);

	public DatePickerComponent() {
		setLayout(new BorderLayout(0, 0));
		add(dtarihidatePicker);
	}

	public Date getDate() {
		return (Date) dtarihidatePicker.getModel().getValue();
	}

	public void setDate(Date date) {
		model.setValue(date);
	}

}
