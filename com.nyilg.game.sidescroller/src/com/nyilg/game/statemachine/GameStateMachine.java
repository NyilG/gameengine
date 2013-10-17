package com.nyilg.game.statemachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameStateMachine {
	
	private GameState currentState = GameState.START;
	private GameStateController gameStateController;
	
	static Map<GameState, List<GameState>> stateTransitions = new HashMap<>();
	
	{
		stateTransitions.put(GameState.START, createList(GameState.START_SCREEN));
		stateTransitions.put(GameState.START_SCREEN, createList(GameState.GAME_SETUP, GameState.HIGHSCORE, GameState.LEVEL_LOADING, GameState.INTRO_VIDEO));
		stateTransitions.put(GameState.INTRO_VIDEO, createList(GameState.LEVEL_LOADING));
		stateTransitions.put(GameState.GAME_SETUP, createList(GameState.START_SCREEN));
		stateTransitions.put(GameState.HIGHSCORE, createList(GameState.START_SCREEN));
		stateTransitions.put(GameState.LEVEL_LOADING, createList(GameState.INGAME_VIDEO, GameState.LEVEL_PLAYING));
		stateTransitions.put(GameState.INGAME_VIDEO, createList(GameState.LEVEL_PLAYING, GameState.START_SCREEN));
		stateTransitions.put(GameState.LEVEL_PLAYING, createList(GameState.LEVEL_LOADING, GameState.START_SCREEN,GameState.END_VIDEO, GameState.CREDITS, GameState.INGAME_SETUP));
		stateTransitions.put(GameState.INGAME_SETUP, createList(GameState.LEVEL_PLAYING));
		stateTransitions.put(GameState.END_VIDEO, createList(GameState.CREDITS, GameState.START_SCREEN));
		stateTransitions.put(GameState.CREDITS, createList(GameState.START_SCREEN));
	}
	
	static List<GameState> createList(GameState... gameStates) {
		List<GameState> gameStateList = new ArrayList<GameState>();
		for (GameState gameState : gameStates) {
			gameStateList.add(gameState);
		}
		return gameStateList;		
	}
	
	public GameStateMachine() {
		gameStateController = new GameStateController(this);
	}
	
	List<GameState> getReachableStatesFrom(GameState gameState) {
		return stateTransitions.get(gameState);
	}
	
	void step() {
		stepTo(gameStateController.getNextState());
	}
	
	void stepTo(GameState gameState) {
		if (isStepAllowedTo(gameState)) {
			currentState = gameState;
			System.out.println("Stepping to: " + currentState.toString());
		} else {
			System.out.println("Step is not allowed!");
		}
	}	
	
	boolean isStepAllowedTo(GameState gameState) {
		List<GameState> allowedSteps = getReachableStatesFrom(currentState);
		return allowedSteps.contains(gameState); 
	}
	
	GameState getCurrentState() {
		return currentState;
	}
	
	void run() {
		while (!currentState.equals(GameState.CREDITS)) {
			step();
		}
	}
	
	public static void main(String[] args) {
		GameStateMachine gsm = new GameStateMachine();
		gsm.run();
	}
	
}
