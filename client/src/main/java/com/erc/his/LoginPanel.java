package com.erc.his;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private Frame frame;

	public LoginPanel(Frame _frame) {
		frame = _frame;
		setBounds(0, 0, 500, 500);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 56, 0, 0, 228, 10, 110, 0 };
		gridBagLayout.rowHeights = new int[] { 56, 0, 30, 0, 10, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblLognPage = new JLabel("LOGIN PAGE");
		lblLognPage.setFont(new Font("Impact", Font.PLAIN, 21));
		GridBagConstraints gbc_lblLognPage = new GridBagConstraints();
		gbc_lblLognPage.insets = new Insets(0, 0, 5, 5);
		gbc_lblLognPage.gridx = 3;
		gbc_lblLognPage.gridy = 1;
		add(lblLognPage, gbc_lblLognPage);

		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setForeground(Color.DARK_GRAY);
		lblUsername.setFont(new Font("Century Gothic", Font.BOLD, 16));
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.WEST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 3;
		add(lblUsername, gbc_lblUsername);

		tfUsername = new JTextField();
		tfUsername.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		GridBagConstraints gbc_tfUsername = new GridBagConstraints();
		gbc_tfUsername.insets = new Insets(0, 0, 5, 5);
		gbc_tfUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfUsername.gridx = 3;
		gbc_tfUsername.gridy = 3;
		add(tfUsername, gbc_tfUsername);
		tfUsername.setColumns(10);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 5;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 110, 0 };
		gbl_panel.rowHeights = new int[] { 84, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Century Gothic", Font.BOLD, 16));
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.fill = GridBagConstraints.BOTH;
		gbc_btnLogin.gridx = 0;
		gbc_btnLogin.gridy = 0;
		panel.add(btnLogin, gbc_btnLogin);

		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 5;
		add(lblPassword, gbc_lblPassword);

		GeneralEventListener eventListener = new GeneralEventListener();

		btnLogin.addActionListener(eventListener);
		btnLogin.setActionCommand("LOGIN_BUTTON");

		pfPassword = new JPasswordField();
		pfPassword.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		GridBagConstraints gbc_pfPassword = new GridBagConstraints();
		gbc_pfPassword.insets = new Insets(0, 0, 5, 5);
		gbc_pfPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfPassword.gridx = 3;
		gbc_pfPassword.gridy = 5;
		add(pfPassword, gbc_pfPassword);

	}

	public void initMainPanel() {
		Main main = new Main();
		main.setLocationRelativeTo(null);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
	}
	
	public static void main(String[] args) {
		
	}

	public class GeneralEventListener implements ActionListener {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent event) {
			String cmd = event.getActionCommand();

			if (cmd.equals("LOGIN_BUTTON")) {

				boolean login = true;

				if (login) {
					MenuFrame menuFrame = new MenuFrame();
					frame.dispose();
					menuFrame.startApplication();
					JOptionPane.showMessageDialog(null, "Login is success", "ALERT", JOptionPane.WARNING_MESSAGE);

					return;

				} else {
					JOptionPane.showMessageDialog(null, "Login is fail", "ALERT", JOptionPane.WARNING_MESSAGE);

				}

			}
		}
	}




}
