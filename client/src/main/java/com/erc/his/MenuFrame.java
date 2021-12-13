package com.erc.his;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.erc.his.client.view.PatientPanel;
import com.erc.his.client.view.appointment.AppointmentPanel;
import com.erc.his.client.view.definition.ParameterDefinitionPanel;
import com.erc.his.client.view.organization.OrganizationPanel;
import com.erc.his.client.view.staff.StaffPanel;
import com.erc.his.client.view.stafftitle.StaffTitlePanel;
import com.erc.his.menu.UserMenu;
import com.erc.his.menu.UserSubMenu;

public class MenuFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel toolbarPanel = new JPanel();
	private JPanel contentPanel = new JPanel();

	public MenuFrame() {
		toolbarPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel.setLayout(new BorderLayout());
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		getContentPane().add(toolbarPanel, BorderLayout.NORTH);
		getContentPane().add(contentPanel, BorderLayout.CENTER);

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

	private void addMenuBar() {

		List<UserMenu> userMenus = getUserMenus();
		JMenuBar toolbar = new JMenuBar();

		MenuEventListener eventListener = new MenuEventListener(userMenus);
		userMenus.stream().forEach(item -> {
			JMenu menu = new JMenu(item.menuName);
			toolbar.add(menu);

			item.subMenus.forEach(subMenu -> {
				JMenuItem menuItem = new JMenuItem(subMenu.getMenuName());
				menuItem.setActionCommand(subMenu.getActionCommand());
				menuItem.setFont(new Font("Century Gothic", Font.PLAIN, 10));
				menu.add(menuItem);
				menuItem.addActionListener(eventListener);
			});
		});

		toolbarPanel.add(toolbar);

	}

	private List<UserMenu> getUserMenus() {
		UserMenu patientMenu = new UserMenu("Patient");
		patientMenu.subMenus.add(new UserSubMenu("Prs001: Patient Screen", PatientPanel.class));
		
		UserMenu appointmentMenu = new  UserMenu("Appointments");
		appointmentMenu.subMenus.add(new UserSubMenu("Rss001: Appointment", AppointmentPanel.class));
		

		UserMenu settingsMenu = new UserMenu("Settings");
		settingsMenu.subMenus.add(new UserSubMenu("Organizations", OrganizationPanel.class));
		settingsMenu.subMenus.add(new UserSubMenu("Parameter Definition", ParameterDefinitionPanel.class));
		settingsMenu.subMenus.add(new UserSubMenu("Titles", StaffTitlePanel.class));
		settingsMenu.subMenus.add(new UserSubMenu("Staffs", StaffPanel.class));

		
		
		List<UserMenu> menuList = new ArrayList<UserMenu>();
		menuList.add(patientMenu);
		menuList.add(appointmentMenu);
		menuList.add(settingsMenu);

		return menuList;
	}

	private class MenuEventListener implements ActionListener {
		private List<UserMenu> userMenus;

		public MenuEventListener(List<UserMenu> userMenus) {
			this.userMenus = userMenus;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			userMenus.stream().filter(userMenu -> userMenu.subMenus.size() > 0).anyMatch(userMenu -> {
				Optional<UserSubMenu> subMenu = userMenu.subMenus.stream()
						.filter(subMenuItem -> subMenuItem.getActionCommand().equals(e.getActionCommand())).findFirst();
				subMenu.ifPresent(menu -> {
					addPanelToScreen(menu.getClazz());
				});
				return subMenu.isPresent();
			});

		}

		@SuppressWarnings("unchecked")
		private void addPanelToScreen(Class<? extends JPanel> panel) {
			contentPanel.removeAll();
			contentPanel.setLayout(new BorderLayout());
			if (panel != null) {

				try {
					Class<? extends JPanel> clazz = (Class<? extends JPanel>) Class.forName(panel.getCanonicalName());
					Constructor<?> ctor = clazz.getConstructor();
					JPanel object = (JPanel) ctor.newInstance(new Object[] {});
					contentPanel.add(object, BorderLayout.CENTER);
				} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			contentPanel.revalidate();
		}

	}
}
