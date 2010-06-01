package de.mxro.swing.dialogwizard;

import java.util.Vector;

import javax.swing.JPanel;

public class EditPanel<O> extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final Vector<EditField<O, ? extends Object>> editFields;
	protected final O object;
	
	public void addEditField(EditField<O, ? extends Object> editField) {
		this.editFields.add(editField);
	}
	
	public EditPanel(O object) {
		super();
		this.object = object;
		this.editFields = new Vector<EditField<O, ? extends Object>>();
		
	}
	
	
}
