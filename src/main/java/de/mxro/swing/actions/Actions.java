package de.mxro.swing.actions;

import java.util.Vector;

import javax.swing.AbstractAction;



public class Actions {
	private final Vector<AbstractAction> actions;
	private final WindowInterface windowInterface;
	
	public final Vector<AbstractAction> getActions() {
		return this.actions;
	}

	public final boolean addAction(AbstractAction action) {
		if (this.getAction(action.getClass()) != null) {
			de.mxro.utils.log.UserError.singelton.log("Actions.addAction: Cannot add multiple instances of one class: "+action.getClass());
			return false;
		}
		if (action instanceof MyAction) {
			((MyAction) action).setActions(this);
			
			this.check();
		}
		return this.actions.add(action);
	}
	
	public final AbstractAction getAction(Class<? extends AbstractAction> clazz) {
		for (final AbstractAction a : this.actions) {
			if (a.getClass().equals(clazz))
				return a;
		}
		return null;
	}

	
	public void checkEnabled() {
		for (final AbstractAction a : this.getActions()) {
			if (a instanceof MyAction) {
				((MyAction) a).checkEnabled();
			}
		}
	}
	
	public void check() {
		this.windowInterface.check();
	}

	public Actions(WindowInterface windowInterface) {
		super();
		this.windowInterface = windowInterface;
		this.actions = new Vector<AbstractAction>();
	}
	
	
}
