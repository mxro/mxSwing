package de.mxro.swing.actions;

import java.util.Vector;



public abstract class WindowInterface {
protected Vector<Actions> actions;
	

	public WindowInterface() {
		super();
		
		this.actions = new Vector<Actions>();
		
	}
	
	public boolean addActions(Actions a) {
		return this.actions.add(a);
	}

	public abstract void check();
	
}
