package com.nyilg.game.sidescroller;

import java.awt.BorderLayout;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Screen extends JFrame{

	private static Logger logger = Logger.getLogger(Screen.class.getName());
	private final Background background;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7596177791629383509L;

	public Screen () {
		logger.info("SideScroller screen created");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel emptyLabel = new JLabel("Test");
		getContentPane().add(emptyLabel, BorderLayout.CENTER);		
		background = new Background();
		pack();
	}
}
