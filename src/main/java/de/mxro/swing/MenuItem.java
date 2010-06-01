package de.mxro.swing;

import java.awt.Image;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

public class MenuItem extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuItem(Action arg0) {
		super(arg0);
		
		if (this.getIcon() instanceof ImageIcon) {
			if (this.getIcon().getIconWidth() > 16 || this.getIcon().getIconHeight() > 16) {
				this.setIcon(new ImageIcon(((ImageIcon)this.getIcon()).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
			}
		}
	}
	
}
