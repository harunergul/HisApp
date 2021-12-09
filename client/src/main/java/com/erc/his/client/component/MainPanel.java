package com.erc.his.client.component;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.erc.his.ClientApp;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ClientApp serviceHelper = new ClientApp();
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
		// Guaranteed to return a non-null array
		Object[] listeners = listenerList.getListenerList();
		int modifiers = 0;
		ActionEvent e = new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
				actionCommand, EventQueue.getMostRecentEventTime(), modifiers);

		// Process the listeners last to first, notifying
		// those that are interested in this event
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == ActionListener.class)
				((ActionListener) listeners[i + 1]).actionPerformed(e);
		}
	}
	public String getActionCommand() {
		return actionCommand;
	}

	public void setActionCommand(String actionCommand) {
		this.actionCommand = actionCommand;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
