package edu.berkeley.bid.cs160.opus;

public class Answer {
	private Scene nextScene;
	private int value;
	private boolean correct;
	// location of the button on the view
	
	
	public Scene getNextScene() {
		return nextScene;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isCorrect() {
		return correct;
	}
	
}
