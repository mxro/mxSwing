package de.mxro.swing.dialogwizard;

import javax.swing.BoxLayout;

public class Column extends Area {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Column() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
}
