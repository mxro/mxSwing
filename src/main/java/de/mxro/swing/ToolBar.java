package de.mxro.swing;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolBar() {
		super();
		this.setFloatable(false);
		this.setRollover(true);
		
	}
	
	 public void setTextLabels(boolean labelsAreEnabled) {
		   
		    for (final Component c : this.getComponents()) {
		    	System.out.println(c.getClass().getName());
		    	if (c instanceof JButton) {
		    		((JButton) c).setText("123");
		    	}
		    }
		   
		 }
}
