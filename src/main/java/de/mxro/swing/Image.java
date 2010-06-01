package de.mxro.swing;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import de.mxro.utils.log.UserError;



public class Image {
	
	public static BufferedImage loadBufferedImage(InputStream stream) {
	    // Create BufferedImage
		try {
			
			return ImageIO.read(stream);
		} catch (java.lang.OutOfMemoryError e) {
			
			UserError.singelton.log(e);
			UserError.singelton.log("de.mxro.gui.Image.loadBufferedImage: Not enough java heap space.", UserError.Priority.HIGH);
			return new BufferedImage(0,0,BufferedImage.TYPE_INT_RGB);
		} catch (final IOException e) {
			return null;
		}
		
	}
	
	public static BufferedImage loadBufferedImage(String fileName) {
	    // Create BufferedImage
	    BufferedImage bi = null;
	    try {
	      // load file from disk using Sun's JPEGIMageDecoder
	      final FileInputStream fis = new FileInputStream(fileName);
	      bi = loadBufferedImage(fis);
	      fis.close();
	    }
	    catch (final Exception e) {
	    	de.mxro.utils.log.UserError.singelton.log(e);
	    }
	    return bi;
	}
	
	public static BufferedImage scaleToSize(int nMaxWidth, int nMaxHeight, BufferedImage imgSrc)
	{
	  final int nHeight = imgSrc.getHeight();
	  final int nWidth = imgSrc.getWidth();
	  final double scaleX = (double)nMaxWidth / (double)nWidth;
	  final double scaleY = (double)nMaxHeight / (double)nHeight;
	  final double fScale = Math.min(scaleX, scaleY);
	  return scale(fScale, imgSrc);
	}
	 
	public static BufferedImage scale(double scale, BufferedImage srcImg)
	{
	  if (scale == 1 )
		return srcImg;
	  final AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(scale, scale), null);
	  return op.filter(srcImg, null);
	}
	
	public static boolean saveImage(BufferedImage bi, OutputStream os, String format) {
	    assert (bi != null && os != null);
	 
	    try {
			ImageIO.write(bi, format, os);
			return true;
		} catch (final IOException e) {
			return false;
		}
	    
	  }
	
	public static boolean saveImage(BufferedImage bi, String str, String format) {
	    assert (bi != null && str != null) ;
	    
	      // save image as Jpeg
	      FileOutputStream out = null;
	      try {
	        out = new FileOutputStream(str);
	      }
	      catch (final java.io.FileNotFoundException fnf) {
	        de.mxro.utils.log.UserError.singelton.log(fnf);
	      }
	      
	      if (!saveImage(bi, out, format))
			return false;
	      
	      try {
	        
	        out.close();
	      }
	      catch (final java.io.IOException io) {
	    	  de.mxro.utils.log.UserError.singelton.log(io);
	    	  return false;
	      }
	      return true;
	    }
	  
}
