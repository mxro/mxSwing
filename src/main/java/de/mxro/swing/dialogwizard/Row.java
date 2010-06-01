package de.mxro.swing.dialogwizard;

import javax.swing.BoxLayout;

public class Row extends Area {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Row() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	}
	
}
