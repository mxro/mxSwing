package de.mxro.swing.dialogwizard;

import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JPanel;

public abstract class Area extends JPanel {
	protected Vector<JComponent> contains;
	
	public void addComponent(JComponent a) {
		this.contains.add(a);
	}

	public Area() {
		super();
		this.contains = new Vector<JComponent>();
	}
	
	
}
