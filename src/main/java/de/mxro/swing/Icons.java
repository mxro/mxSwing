package de.mxro.swing;

import java.awt.Image;

import javax.swing.ImageIcon;

import de.mxro.utils.log.UserError;

/**
 * Usage: place a class that extends this class into an empty package
 * Copy the image icons into this package
 * get this images by giving the name to the function
 * 
 * @author mer
 *
 */
public abstract class Icons {
	
	public ImageIcon getIcon(String name) {
		if (this.getClass().getResource(name) == null) {
			de.mxro.utils.log.UserError.singelton.log("Icons.getIcon: Could not find icon: "+name, UserError.Priority.HIGH);
			return null;
		}
		
			//URI uri = URI.create( this.getClass().getResource(name).toString());
		return new ImageIcon(this.getClass().getResource(name));
		
	}
	
	public ImageIcon getIcon(String name, int width, int height) {
		return this.getIcon(name, width, height, false);
	}
	
	/**
	 * could extend this with caching the images
	 * 
	 * @param name
	 * @param width
	 * @param height
	 * @return
	 */
	public ImageIcon getIcon(String name, int width, int height, boolean proportinal) {
		final ImageIcon temp = this.getIcon(name);
		if (temp == null)
			return null;
		Image image;
		/*if (shadow) {
			image = temp.getImage().getScaledInstance(width-5, height-5, Image.SCALE_SMOOTH);
			BufferedImage sourceImage = Utils.toBufferedImage(image);
			
			BufferedImage destImage = new BufferedImage(width, height, sourceImage.getType());
			destImage = new ShadowFilter().filter(sourceImage, destImage);
			image = destImage;
		} else */
		if (proportinal) {
			final double ratio_orig = (temp.getIconWidth()+0.0) / temp.getIconHeight();
			final double ratio_new = (width+0.0) / height;
			if ((ratio_orig - ratio_new) > 0.01) {
				if (temp.getIconWidth() < temp.getIconHeight()) {
					final int newWidth = width;
					final int newHeight = (int) Math.round ( (height*((0.0+temp.getIconWidth()) / temp.getIconHeight()) )); 
					return new ImageIcon(temp.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH));
				} else {
					final int newWidth = (int) Math.round ( (width*((0.0+temp.getIconHeight()) / temp.getIconWidth()) ));
					final int newHeight = height; 
					return new ImageIcon(temp.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH));
				}
			}
		} 
		image = temp.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH); 
		
		return new ImageIcon(image);
	}
}
