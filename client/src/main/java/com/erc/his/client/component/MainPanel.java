package com.erc.his.client.component;

import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	
	private String actionCommand;
	private Action action;
	
	public void showWarning(String message) {
		JOptionPane.showMessageDialog(new JFrame(), message, "Warrning", JOptionPane.WARNING_MESSAGE);
	}

	public void showError(String message) {
		JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void showSuccess(String message) {
		JOptionPane.showMessageDialog(new JFrame(), message, "Success", JOptionPane.PLAIN_MESSAGE);
	}
	
	
	public void addActionListener(ActionListener listener){
		listenerList.add(ActionListener.class, listener);
	}
	
	public void removeActionListener(ActionListener listener){
		if(listener==null)
			return;
		listenerList.remove(ActionListener.class, listener);
	}
	
	public void fireActionPerformed() {
		Object[] list = listenerList.getListenerList();
		
		
	}
	
	
	
}
