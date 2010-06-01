package de.mxro.swing.dialogwizard;

public abstract class EditField<ObjectType, FieldType> {
	protected EditPanel panel;
	
	public EditField(EditPanel panel) {
		super();
		this.panel = panel;
	}
	
	public abstract void setValue(FieldType o);
	public abstract FieldType getValue();
}
