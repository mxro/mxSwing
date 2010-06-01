package de.mxro.swing.dialogwizard;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JDialog;

public abstract class CustomSwingDialog<O> extends JDialog implements SwingEditor<O> {
	
	private O object;

	protected void setObject(O object) {
		this.object = object;
		this.updateView();
	}
	
	protected O getObject() {
		
		return this.object;
	}
	
	public abstract void updateView();
	public abstract void updateObject();
	
	

	public final O editObject(O object) {
		if (object == null)
			throw new IllegalArgumentException("Don't create dialog with null object!");
		de.mxro.utils.Utils.centerComponent(this, null);
		this.setObject(object);
		this.setModal(true);
		this.setVisible(true);
		//this.updateObject();
		return this.getObject();
	}

	/* some constructors ... */
	
	public CustomSwingDialog() throws HeadlessException {
		super();
	}

	public CustomSwingDialog(Dialog owner, boolean modal) throws HeadlessException {
		super(owner, modal);
	}

	public CustomSwingDialog(Dialog owner, String title, boolean modal, GraphicsConfiguration gc) throws HeadlessException {
		super(owner, title, modal, gc);
	}

	public CustomSwingDialog(Dialog owner, String title, boolean modal) throws HeadlessException {
		super(owner, title, modal);
	}

	public CustomSwingDialog(Dialog owner, String title) throws HeadlessException {
		super(owner, title);
	}

	public CustomSwingDialog(Dialog owner) throws HeadlessException {
		super(owner);
	}

	public CustomSwingDialog(Frame owner, boolean modal) throws HeadlessException {
		super(owner, modal);
	}

	public CustomSwingDialog(Frame owner, String title, boolean modal, GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
	}

	public CustomSwingDialog(Frame owner, String title, boolean modal) throws HeadlessException {
		super(owner, title, modal);
	}

	public CustomSwingDialog(Frame owner, String title) throws HeadlessException {
		super(owner, title);
	}

	public CustomSwingDialog(Frame owner) throws HeadlessException {
		super(owner);
	}
	
	
	
}
