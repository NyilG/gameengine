package com.nyilg.game.statemachine;

import java.util.List;
import java.util.Random;

public class GameStateController {

	GameStateMachine gameStateMachine;	
	
	public GameStateController(GameStateMachine gameStateMachine) {
		this.gameStateMachine = gameStateMachine;
	}
	
	public GameState getNextState() {
		GameState currentState = gameStateMachine.getCurrentState();
		List<GameState> possibleNextStates = gameStateMachine.getReachableStatesFrom(currentState);
		// choose one, randomly for now:
		int numberOfPossibleSteps = possibleNextStates.size();
		Random generator = new Random();
		int nextStateOrder = generator.nextInt(numberOfPossibleSteps);
		return possibleNextStates.get(nextStateOrder);
	}
	
	
}
