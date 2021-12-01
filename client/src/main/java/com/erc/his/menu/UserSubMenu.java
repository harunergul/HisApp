package com.erc.his.menu;

import javax.swing.JPanel;

public class UserSubMenu {
	private Class<? extends JPanel> clazz;
	private String actionCommand;
	private String menuName;

	public UserSubMenu(String menuName, Class<? extends JPanel> clazz) {
		this.menuName = menuName;
		this.actionCommand = menuName;
		this.clazz = clazz;
	}

	public UserSubMenu(String menuName, String actionCommand, Class<? extends JPanel> clazz) {
		this.menuName = menuName;
		this.actionCommand = actionCommand;
		this.clazz = clazz;
	}

	public Class<? extends JPanel> getClazz() {
		return clazz;
	}

	public void setClazz(Class<? extends JPanel> clazz) {
		this.clazz = clazz;
	}

	public String getActionCommand() {
		return actionCommand;
	}

	public void setActionCommand(String actionCommand) {
		this.actionCommand = actionCommand;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

}
