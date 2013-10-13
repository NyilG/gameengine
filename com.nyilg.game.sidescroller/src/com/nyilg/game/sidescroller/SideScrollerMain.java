package com.nyilg.game.sidescroller;

import java.util.logging.Logger;
 
public class SideScrollerMain {

	private static SideScrollerGame sideScrollerGame;
	private static Logger logger = Logger.getLogger(SideScrollerMain.class.getName());
	
	public static void main(String[] args) {	
		logger.info("SideScroller welcome");
		sideScrollerGame = SideScrollerGame.getInstance();
		sideScrollerGame.init();
		sideScrollerGame.start();
	}
	
}
