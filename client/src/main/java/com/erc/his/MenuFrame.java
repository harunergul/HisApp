package com.erc.his;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private static Frame instance = null;
	private JMenu mnDefntons;
	private JMenuItem menuOrganization;
	private JMenuItem menuAppellation;
	private JMenuItem menuStaff;

	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JMenuItem menuPatient;
	private JMenu mnStaff;
	private JMenu mnNewMenu;
	private JMenuItem menuAppointment;

	private JMenu mnAdmission;
	private JMenuItem menuPatientAdmission;

	public MenuFrame() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\caglak\\Desktop\\Icons\\hospital.png"));
		getContentPane().setFont(new Font("Century Gothic", Font.PLAIN, 20));

		setSize(1942, 1097);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		MenuFrame menuFrame = new MenuFrame();
		menuFrame.startApplication();
	}

	public void startApplication() {
		MenuFrame frame = new MenuFrame();
		frame.addMenuBar();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 560);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static Frame getInstance() {
		return instance;
	}

	private void addMenuBar() {
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(204, 204, 255));
		setJMenuBar(menuBar);

		mnMenu = new JMenu("PATIENT");
		mnMenu.setFont(new Font("Century Gothic", Font.BOLD, 12));
		menuBar.add(mnMenu);

		menuPatient = new JMenuItem("PATIENT TABLE");
		menuPatient.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		mnMenu.add(menuPatient);

		mnStaff = new JMenu("STAFF");
		mnStaff.setFont(new Font("Century Gothic", Font.BOLD, 12));
		menuBar.add(mnStaff);

		menuStaff = new JMenuItem("STAFF TABLE");
		mnStaff.add(menuStaff);
		menuStaff.setFont(new Font("Century Gothic", Font.PLAIN, 10));

		mnNewMenu = new JMenu("APPOINTMENT");
		mnNewMenu.setFont(new Font("Century Gothic", Font.BOLD, 12));
		menuBar.add(mnNewMenu);

		menuAppointment = new JMenuItem("APPOINTMENT OPERATIONS");
		menuAppointment.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		mnNewMenu.add(menuAppointment);

		mnDefntons = new JMenu("DEFINITIONS");
		mnDefntons.setFont(new Font("Century Gothic", Font.BOLD, 12));
		menuBar.add(mnDefntons);

		menuOrganization = new JMenuItem("ORGANIZATION");
		menuOrganization.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		mnDefntons.add(menuOrganization);

		menuAppellation = new JMenuItem("APPELLATION");
		menuAppellation.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		mnDefntons.add(menuAppellation);

		mnAdmission = new JMenu("ADMISSION");
		mnAdmission.setFont(new Font("Century Gothic", Font.BOLD, 12));
		menuBar.add(mnAdmission);

		menuPatientAdmission = new JMenuItem("ADMISSION OPERATIONS");
		menuPatientAdmission.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		mnAdmission.add(menuPatientAdmission);

		clickMenuItem();
	}

	public void clickMenuItem() {
		menuPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				PatientPanel panel = new PatientPanel();
//				getContentPane().removeAll();
//				getContentPane().add(panel);
//				setLocationRelativeTo(null);
//				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				setExtendedState(JFrame.MAXIMIZED_BOTH);
//				setVisible(true);
			}
		});
		
		
		mnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				StaffPanel panel = new StaffPanel();
//				getContentPane().removeAll();
//				getContentPane().add(panel);
//				setLocationRelativeTo(null);
//				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				setExtendedState(JFrame.MAXIMIZED_BOTH);
//				setVisible(true);
			}
		});

	}
}
