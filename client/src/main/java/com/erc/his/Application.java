package com.erc.his;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.erc.his.client.view.PatientPanel;

public class Application {

	public static void main(String... args) {
		JFrame frame = new JFrame();

		PatientPanel panel = new PatientPanel();

		BorderLayout layout = new BorderLayout();
		layout.addLayoutComponent(panel, BorderLayout.CENTER);
		frame.setLayout(layout);
 		frame.setSize(400, 500);// 400 width and 500 height
		frame.setVisible(true);// making the frame visible

	}
}
