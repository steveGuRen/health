package com.health.utils;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;

import javax.imageio.ImageIO;

public class SerializableBufferedImage  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	transient BufferedImage image = null;
	
	public SerializableBufferedImage(BufferedImage image) {
		if(image == null)
			throw new NullPointerException("BufferedImage image is null");
		this.image = image;
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        ImageIO.write(image, "png", out); // png is lossless
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        image = ImageIO.read(in);
    }

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
    
    
}
