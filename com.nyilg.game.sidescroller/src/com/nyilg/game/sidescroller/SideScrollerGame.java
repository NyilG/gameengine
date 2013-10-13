package com.nyilg.game.sidescroller;

import java.util.logging.Logger;

import com.nyilg.game.sidescroller.resources.ResourceManager;

public class SideScrollerGame {
	
	private static SideScrollerGame instance;
	private static Logger logger = Logger.getLogger(SideScrollerGame.class.getName());
	private Screen mainScreen;
	private ResourceManager resourceLoader;
	
	public static SideScrollerGame getInstance() {
		if (instance == null) {
			instance = new SideScrollerGame();
		}
		return instance;
	}
	
	private SideScrollerGame(){
		logger.info("SideScrollerGame created");
	}
	
	void init() {
		resourceLoader = ResourceManager.getInstance();
		mainScreen = new Screen();
	}
	
	void start() {
		mainScreen.setVisible(true);
	}
	
	
	
}
