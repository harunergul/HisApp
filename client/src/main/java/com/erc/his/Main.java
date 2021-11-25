package com.erc.his;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Toolkit;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\caglak\\Desktop\\Icons\\hospital.png"));
		getContentPane().setFont(new Font("Century Gothic", Font.PLAIN, 20));
		setSize(1942, 1097);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
