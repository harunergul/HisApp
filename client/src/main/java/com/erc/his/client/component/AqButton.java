package com.erc.his.client.component;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AqButton extends JButton {

	public Dimension dimension = new Dimension(10, 10);

	public AqButton() {
	}

	public AqButton(String icon) {
		setIcon(ButtonIcon.CLOSE);
	}

	private static final long serialVersionUID = 1L;

	public void setIcon(String iconType) {
		ImageIcon imageIcon = new ImageIcon(AqButton.class.getResource(iconType + ".png"));
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance((int) dimension.getWidth(), (int) dimension.getHeight(),
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		setIcon(imageIcon);
	}

}
