package de.mxro.swing.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import de.mxro.utils.log.UserError;

public class MyActionAlias extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MyAction myAction;
	
	public void actionPerformed(ActionEvent arg0) {
		this.myAction.actionPerformed(arg0);
	}

	public MyActionAlias(final MyAction myAction) {
		super();
		if (myAction == null) {
			de.mxro.utils.log.UserError.singelton.log("MyActionAlias: myAction must not be null!", UserError.Priority.HIGH);
			throw new IllegalArgumentException("myAction must not be null");
		}
		this.myAction = myAction;
		this.myAction.addAlias(this);
		this.putValue(Action.NAME, myAction.getValue(Action.NAME));
		this.putValue(Action.SHORT_DESCRIPTION, myAction.getValue(Action.SHORT_DESCRIPTION));
	//    this.putValue(Action.LARGE_ICON_KEY, myAction.getValue(Action.LARGE_ICON_KEY));
	    this.putValue(Action.SMALL_ICON, myAction.getValue(Action.SMALL_ICON));
	    this.putValue(Action.MNEMONIC_KEY, myAction.getValue(Action.MNEMONIC_KEY));
	  //  this.putValue(Action.DISPLAYED_MNEMONIC_INDEX_KEY, myAction.getValue(Action.DISPLAYED_MNEMONIC_INDEX_KEY));
	    this.putValue(Action.ACCELERATOR_KEY, myAction.getValue(Action.ACCELERATOR_KEY));
	}

	
}
