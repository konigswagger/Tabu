package edu.berkeley.bid.cs160.opus;

import java.util.LinkedList;

public enum Scene {
	TAXI_WRONG		(R.layout.intro, 			false,	null,		0,	0,	0,	0, null,	null,	null,	null),
	TAXI_RIGHT		(R.layout.intro, 			false,	null,		0,	0,	0,	0, null,	null,	null,	null),
	TAXI			(R.layout.intro, 			false,	null,		0,	0,	0,	0, TAXI_RIGHT,	TAXI_WRONG,	null,	null),
	BIZCARD_WRONG	(R.layout.intro, 			true,	TAXI,		0,	0,	0,	0, null,	null,	null,	null),
	BIZCARD_RIGHT	(R.layout.intro, 			true,	TAXI,		0,	0,	0,	0, null,	null,	null,	null),
	BIZCARD			(R.layout.bizcard, 			false,	null,		0,	0,	0,	0, null,	null,	null,	null),
	AIRPORT			(R.layout.airport,			true,	BIZCARD,	0,	0,	0,	0, BIZCARD_RIGHT,	BIZCARD_WRONG,	null,	null),	
	INTRO			(R.layout.intro,			true,	null,		0,	0,	0,	0, null,	null,	null,	null);
		
	private int layout;
	private int valueA;
	private int valueB;
	private int valueC;
	private int valueD;
	private Scene sceneA;
	private Scene sceneB;
	private Scene sceneC;
	private Scene sceneD;
	private Scene sceneCont;
	private boolean contButton;
	
	private Scene (int layout, boolean contButton, Scene sceneCont, int valueA, int valueB, int valueC, int valueD, 
			Scene sceneA, Scene sceneB, Scene sceneC, Scene sceneD) {
		this.layout = layout;
		this.valueA = valueA;
		this.valueB = valueB;
		this.valueC = valueC;
		this.valueD = valueD;
		this.sceneA = sceneA;
		this.sceneB = sceneB;
		this.sceneC = sceneC;
		this.sceneD = sceneD;
		this.sceneCont = sceneCont;
		this.contButton = contButton;
	}
	
	public int getLayout() {
		return layout;
	}
	
	public Scene getSceneA() {
		return sceneA;
	}

	public Scene getSceneB() {
		return sceneB;
	}
	
	public Scene getSceneC() {
		return sceneC;
	}
	
	public Scene getSceneD() {
		return sceneD;
	}
	
	public int getValueA() {
		return valueA;
	}
	
	public int getValueV() {
		return valueB;
	}
	
	public int getValueC() {
		return valueC;
	}
	
	public int getValueD() {
		return valueD;
	}
	
	public Scene getContinueScene() {
		return sceneCont;
	}
	
	public boolean isContinue() {
		return contButton;
	}

	
}
