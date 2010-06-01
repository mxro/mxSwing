package de.mxro.swing.actions;

import javax.swing.Action;
import javax.swing.KeyStroke;

public class MyActionKeyStrokeAlias extends MyActionAlias {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyActionKeyStrokeAlias(MyAction myAction, final KeyStroke keyStroke) {
		super(myAction);
		this.putValue(Action.ACCELERATOR_KEY, keyStroke);
	}
	
	
}
