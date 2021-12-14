package com.erc.his.client.view.appointment;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.erc.his.client.component.MainPanel;
import com.erc.his.entity.AppointmentDTO;
import com.erc.his.entity.OrganizationDTO;
import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JCalendar;

public class AppointmentPanel extends MainPanel {
	private static final long serialVersionUID = 1L;
	private JCalendar dateChooser = new JCalendar();
	private final JTable tableOrganization = new JTable();
	private final AppointmentOrganizationTableModel organizationTableModel = new AppointmentOrganizationTableModel();
	private final AppointmentTableModel appointmentTableModel = new AppointmentTableModel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnMakeAppointment = new JButton("Make Appointment");
	private final JButton btnUpdateAppointment = new JButton("Update Appointment");
	private final JButton btnCancelAppointment = new JButton("Cancel Appointment");
	private final JScrollPane scrollPaneAppointments = new JScrollPane();
	private final JTable tableAppointment = new JTable();

	public AppointmentPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 10, 46, 0, 0, 0, 0, 10, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 14, 0, 0, 10, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridheight = 2;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 1;
		add(dateChooser, gbc_dateChooser);

		GridBagConstraints gbc_btnMakeAppointment = new GridBagConstraints();
		gbc_btnMakeAppointment.insets = new Insets(0, 0, 5, 5);
		gbc_btnMakeAppointment.gridx = 2;
		gbc_btnMakeAppointment.gridy = 1;
		add(btnMakeAppointment, gbc_btnMakeAppointment);

		GridBagConstraints gbc_btnUpdateAppointment = new GridBagConstraints();
		gbc_btnUpdateAppointment.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdateAppointment.gridx = 3;
		gbc_btnUpdateAppointment.gridy = 1;
		add(btnUpdateAppointment, gbc_btnUpdateAppointment);

		GridBagConstraints gbc_btnCancelAppointment = new GridBagConstraints();
		gbc_btnCancelAppointment.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelAppointment.gridx = 4;
		gbc_btnCancelAppointment.gridy = 1;
		add(btnCancelAppointment, gbc_btnCancelAppointment);

		GridBagConstraints gbc_scrollPaneAppointments = new GridBagConstraints();
		gbc_scrollPaneAppointments.gridheight = 2;
		gbc_scrollPaneAppointments.gridwidth = 4;
		gbc_scrollPaneAppointments.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneAppointments.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneAppointments.gridx = 2;
		gbc_scrollPaneAppointments.gridy = 2;
		add(scrollPaneAppointments, gbc_scrollPaneAppointments);

		scrollPaneAppointments.setViewportView(tableAppointment);

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		tableOrganization.setModel(organizationTableModel);
		scrollPane.setViewportView(tableOrganization);

		tableAppointment.setModel(appointmentTableModel);
		scrollPaneAppointments.setViewportView(tableAppointment);

		init();

	}

	private void init() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate today = LocalDate.now();
		formatter.format(today);

		dateChooser.setDate(java.util.Date.from(today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		dateChooser.getDayChooser().addDateEvaluator(new MyDateEvaluator());
		dateChooser.setDate(new Date());
		dateChooser.setForeground(Color.blue);
		dateChooser.setLocale(new Locale("tr", "TR"));
		dateChooser.getDayChooser().updateUI();
		dateChooser.setOpaque(true);
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {

				if (evt.getNewValue() != null && evt.getNewValue() instanceof GregorianCalendar) {
					GregorianCalendar value = (GregorianCalendar) evt.getNewValue();
					if (value != null) {
						organizationOrDateChanged();
					}
				}

			}
		});

		tableOrganization.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent mouseEvent) {
				if (tableOrganization.getSelectedRow() != -1) {
					organizationOrDateChanged();
				}
			}
		});
		getAllOrganizations();
		resetAppointmentTable();

	}

	private void organizationOrDateChanged() {

		int selectedRow = tableOrganization.getSelectedRow();
		OrganizationDTO organizationDTO = null;
		Date selectedDate = dateChooser.getDate();

		if (selectedRow != -1) {
			organizationDTO = organizationTableModel.getListData().get(selectedRow);
		}

		selectedDate = dateChooser.getDate();

		if (organizationDTO == null) {
			showWarning("Please select an organization!");
		}

		if (selectedDate == null) {
			showWarning("Please select a valid date!");
		}

		getAppointmentsFromService(organizationDTO, selectedDate);
	}

	private void getAppointmentsFromService(OrganizationDTO organizationDTO, Date selectedDate) {
		resetAppointmentTable();
		try {
			List<AppointmentDTO> appointments = serviceHelper.getAllAppointments(organizationDTO.getOrganizationId(),
					selectedDate);
			if (appointments != null) {
				SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm");
				appointmentTableModel.getListData().stream().map(row -> {
					String rowDate = dateFormatter.format(row);
					Optional<AppointmentDTO> appointmentHolder = appointments.stream().filter(
							appointment -> dateFormatter.format(appointment.getAppointmentDate()).equals(rowDate))
							.findFirst();
					if (appointmentHolder.isPresent()) {
						row.setAppointment(appointmentHolder.get());
					}
					return row;
				});
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getAllOrganizations() {
		ArrayList<OrganizationDTO> organizations;
		try {
			organizations = serviceHelper.getAllOrganizations();
			organizationTableModel.setListData(organizations);
			organizationTableModel.fireTableDataChanged();
		} catch (Exception e) {
			showError(e.getLocalizedMessage());
		}

	}

	private class MyDateEvaluator implements IDateEvaluator {

		@Override
		public boolean isSpecial(Date date) {
			return false;
		}

		@Override
		public Color getSpecialForegroundColor() {
			return null;
		}

		@Override
		public Color getSpecialBackroundColor() {
			return null;
		}

		@Override
		public String getSpecialTooltip() {
			return null;
		}

		@Override
		public boolean isInvalid(Date date) {

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

			cal.setTime(new Date());
			cal.set(Calendar.HOUR, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			cal.add(Calendar.DAY_OF_MONTH, -1);

			if (date.before(cal.getTime())) {
				return true;
			}

			cal.add(Calendar.DAY_OF_MONTH, 12);

			if (date.after(cal.getTime())) {
				return true;
			}

			if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
				return true;
			}
			return false;

		}

		@Override
		public Color getInvalidForegroundColor() {
			return null;
		}

		@Override
		public Color getInvalidBackroundColor() {
			return null;
		}

		@Override
		public String getInvalidTooltip() {
			return "You can not create appointment on this day!";
		}
	}

	private void resetAppointmentTable() {

		appointmentTableModel.getListData().clear();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 8);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		boolean finished = false;

		while (!finished) {

			AppointmentRow appointmentRow = new AppointmentRow();
			appointmentRow.setDate(cal.getTime());
			AppointmentDTO emptyAppointment = new AppointmentDTO();
			appointmentRow.setAppointment(emptyAppointment);
			appointmentTableModel.addAppointmentRow(appointmentRow);

			Calendar loopTime = Calendar.getInstance();

			cal.add(Calendar.MINUTE, 15);
			loopTime.setTime(cal.getTime());

			if (loopTime.get(Calendar.HOUR_OF_DAY) == 17 && loopTime.get(Calendar.MINUTE) == 15) {
				finished = true;
			}
			appointmentTableModel.fireTableDataChanged();
		}
		// getFilledAppointmentList();
	}
}
