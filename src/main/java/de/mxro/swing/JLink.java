package de.mxro.swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JLink extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8629622012978664182L;

	private JLabel holdedLabel;
	
	private final String title;
	
	
	
	
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		if (enabled) {
			this.holdedLabel.setText("<html><font color='blue' ><u>"+this.title+"</u></font></html>");
		} else {
			this.holdedLabel.setText("<html><font color='#C0C0C0' ><u>"+this.title+"</u></font></html>");
		}
	}



	protected JLabel getHoldedLabel(String title) {
		if (this.holdedLabel == null) {
			this.holdedLabel = new JLabel("<html><font color='blue' ><u>"+title+"</u></font></html>");
		}
		return this.holdedLabel;
	}



	public JLink(final Action a) {
		super();
		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				a.actionPerformed(null);
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		a.addPropertyChangeListener(new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent arg0) {
				// System.out.println("propchanged "+arg0.getPropertyName());
				if (arg0.getPropertyName().equals("enabled")) {
					// de.mxro.UserError.singelton.log("enabeld changed");
					JLink.this.setEnabled((Boolean) arg0.getNewValue());
				}
				if (arg0.getPropertyName().equals("visible")) {
					JLink.this.setVisible((Boolean) arg0.getNewValue());
				}
			}
			
		});
		 this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//this.setLayout(null);
		
		this.removeAll();
		this.title = (String) a.getValue(Action.NAME);
		this.add(this.getHoldedLabel(this.title), null);
		final Dimension myDim = new Dimension(this.holdedLabel.getPreferredSize().width+8, this.holdedLabel.getPreferredSize().height);
		this.setMaximumSize(myDim);
		this.setMinimumSize(myDim);
		this.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 4));
		this.setSize(myDim);
		
		this.setEnabled(a.isEnabled());
		this.revalidate();
		this.setBackground(Color.WHITE);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//this.setBorder(null);
		
		//this.setForeground(Color.WHITE);
		//this.setBackground(Color.WHITE);
		
	}

	
	
}
