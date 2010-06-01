package de.mxro.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;



public class JImage extends javax.swing.JPanel {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = -8215214998365260498L;
	private final Image img;  

	  public JImage(Image image) { 
		 super();
		 this.img = image;
		 this.setLayout(null);
		 this.setSize(new Dimension(this.img.getWidth(this), this.img.getHeight(this)));
		 this.setMaximumSize(this.getSize());
		 this.setMinimumSize(this.getSize());
		 this.setPreferredSize(this.getSize());
		 this.setOpaque(true);
		 this.setBackground(Color.WHITE);
		 //this.setAlignmentX(Component.LEFT_ALIGNMENT);
		 //this.setAlignmentY(Component.TOP_ALIGNMENT);
	  } 

	  @Override
	public void paintComponent (Graphics g) { 
	  
	   super.paintComponent (g); 

	   // Use the image width & height to find the starting point
	 //  int msgX = getSize ().width/2 - img.getWidth (this); 
	 //  int msgY = getSize ().height/2 - img.getHeight (this);

	       
	   //g.drawImage (img, msgX, msgY, this); 
	   g.drawImage(this.img, 0, 0, this);
	  } // paintComponent

}
