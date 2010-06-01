package de.mxro.swing.dialogwizard;

public interface SwingEditor<O> {

	
	public void updateView();
	public void updateObject();
	
	

	public O editObject(O object);
}
