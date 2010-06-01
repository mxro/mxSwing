package de.mxro.swing;

import javax.swing.Icon;
import javax.swing.JButton;

public class JIconButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JIconButton(Icon arg0) {
		super(arg0);
		//this.setSize(new Dimension(this.getIcon().getIconWidth(), this.getIcon().getIconHeight()));
		this.setContentAreaFilled(false);
	    this.setBorderPainted(false);
	    this.setFocusPainted(false);
	    this.setOpaque(false);
	    //this.setBackground(Color.BLACK);
	}
	
}
