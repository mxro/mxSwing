package de.mxro.swing.actions;


import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;


public abstract class MyAction extends AbstractAction {
	private Actions actions;
	private final Vector<MyActionAlias> aliases;
	
	public final void checkEnabled() {
		this.setEnabled(this.mustBeEnabled());
		for (final MyActionAlias alias : this.aliases) {
			alias.setEnabled(this.isEnabled());
		}
	}
	
	protected abstract boolean mustBeEnabled();
	
	public final void setActions(Actions actions) {
		//de.mxro.UserError.singelton.log("set Actions "+this.getClass().getName()+" to "+actions);
		this.actions = actions;
	}

	public final Actions getActions() {
		return this.actions;
	}
	
	public final void addAlias(MyActionAlias alias) {
		this.aliases.add(alias);
	}
	
	public final void actionPerformed(ActionEvent e) {
		this.myActionPerformed(e);
		this.check();
	}

	protected abstract void myActionPerformed(java.awt.event.ActionEvent e);
	
	protected void check() {
		
		if (this.getActions() != null) {
			
			this.getActions().check();
		} else {
			de.mxro.utils.log.UserError.singelton.log("MyAction.add: Action "+this.getClass().getName()+" not added to actions");
		}
	}

	public MyAction() {
		super();
		this.aliases = new Vector<MyActionAlias>();
	}
	
	
}
