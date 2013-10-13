package com.nyilg.game.sidescroller.resources;

import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.nyilg.game.sidescroller.resources.images.Image;
import com.nyilg.game.sidescroller.resources.images.ImageLoader;

public class ResourceManager {
	
	private static ResourceManager instance;
	protected HashMap<String, Resource> loadedResources;
	private static Logger logger = Logger.getLogger(ResourceManager.class.getName());
	private static ImageLoader imageLoader;
	private static Properties resourceDescriptor; 
	
	public static ResourceManager getInstance(){
		if (instance == null) {
			instance = new ResourceManager();
		}
		return instance;
	}
	
	private ResourceManager(){
		loadedResources = new HashMap<>();
		resourceDescriptor = new Properties();
		//resourceDescriptor.load(reader);
		imageLoader = ImageLoader.getInstance();
		logger.info("ResourceLoader created");
	}
	
	public Resource getResourceWithId(String resourceId) {
		return loadedResources.get(resourceId);
	}
	
	public Image getImageWithId(String imageId) {
		Resource loadedImage = loadedResources.get(imageId);
		if (loadedImage == null) {
			String path = "C:\\gameres\\8bit.jpeg";			
			loadedImage = imageLoader.loadImageFromFile(path);
			loadedResources.put(imageId, loadedImage);
		}
		if (loadedImage instanceof Image) {				
			return (Image)loadedImage;
		} else {
			logger.log(Level.WARNING, "Resource " + imageId + " is not a valid image!");
			return null;
		}
	}
}
