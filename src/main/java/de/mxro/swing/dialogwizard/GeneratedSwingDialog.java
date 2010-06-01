package de.mxro.swing.dialogwizard;

import java.awt.Frame;
import java.awt.HeadlessException;

import javax.swing.JDialog;

public class GeneratedSwingDialog<O> extends JDialog implements SwingEditor<O> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final EditPanel<O> editPanel; 
	
	public O editObject(O object) {
		
		return object;
	}

	public void updateObject() {
		
		
	}

	public void updateView() {
		
		
	}

	public GeneratedSwingDialog(Frame arg0, EditPanel editPanel) throws HeadlessException {
		super(arg0);
		this.editPanel = editPanel;
	}

	
	
	
	
}
