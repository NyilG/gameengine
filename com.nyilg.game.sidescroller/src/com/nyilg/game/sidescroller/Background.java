package com.nyilg.game.sidescroller;

import com.nyilg.game.sidescroller.resources.ResourceManager;
import com.nyilg.game.sidescroller.resources.images.Image;

public class Background {
	
	private final Image backgroundImage;
	private final ResourceManager resourceManager;
	
	public Background(){
		resourceManager = ResourceManager.getInstance();
		backgroundImage = resourceManager.getImageWithId("background1");
	}
	
}
