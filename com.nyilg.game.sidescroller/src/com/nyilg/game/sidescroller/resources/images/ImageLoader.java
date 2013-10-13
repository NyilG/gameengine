package com.nyilg.game.sidescroller.resources.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	private static ImageLoader instance;
	private static Logger logger = Logger.getLogger(ImageLoader.class.getName());
		
	public static ImageLoader getInstance(){
		if (instance == null) {
			instance = new ImageLoader();
		}
		return instance;
	}
	
	private ImageLoader(){
		logger.info("ImageLoader instance created");
	}
	
	public Image loadImageFromFile(String path) {
		Image image = new Image();
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File(path));
		} catch (IOException e) {
		}
		image.setImage(bufferedImage);
		return image;
	}
}
