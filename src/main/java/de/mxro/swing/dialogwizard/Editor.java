package de.mxro.swing.dialogwizard;

import javax.swing.JComponent;
import javax.swing.JPanel;

public abstract class Editor<C extends JComponent> extends JPanel {
	protected EditField editField;
	protected C component;
	
	public Editor(EditField editField) {
		super();
		this.editField = editField;
		this.component = this.createComponent();
		this.add(this.component);
	}
	
	public abstract C createComponent();

}
