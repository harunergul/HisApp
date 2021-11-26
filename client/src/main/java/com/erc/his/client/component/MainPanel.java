package com.erc.his.client.component;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public void showWarning(String message) {
		JOptionPane.showMessageDialog(new JFrame(), message, "Warrning", JOptionPane.WARNING_MESSAGE);
	}

	public void showError(String message) {
		JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void showSuccess(String message) {
		JOptionPane.showMessageDialog(new JFrame(), message, "Success", JOptionPane.PLAIN_MESSAGE);
	}
}
