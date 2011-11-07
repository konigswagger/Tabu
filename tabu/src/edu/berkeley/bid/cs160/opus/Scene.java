package edu.berkeley.bid.cs160.opus;

import java.util.LinkedList;

public enum Scene {
	INTRO			(R.layout.intro,			0,	0,	0,	0, null,	null,	null,	null),
	AIRPORT			(R.layout.intro,			0,	0,	0,	0, null,	null,	null,	null),
	BIZCARD			(R.layout.intro, 			0,	0,	0,	0, null,	null,	null,	null),
	BIZCARD_RIGHT	(R.layout.intro, 			0,	0,	0,	0, null,	null,	null,	null),
	BIZCARD_WRONG	(R.layout.intro, 			0,	0,	0,	0, null,	null,	null,	null),
	TAXI			(R.layout.intro, 			0,	0,	0,	0, null,	null,	null,	null),
	TAXI_RIGHT		(R.layout.intro, 			0,	0,	0,	0, null,	null,	null,	null),
	TAXI_WRONG		(R.layout.intro, 			0,	0,	0,	0, null,	null,	null,	null);
		
	private int layout;
	private int valueA;
	private int valueB;
	private int valueC;
	private int valueD;
	private Scene sceneA;
	private Scene sceneB;
	private Scene sceneC;
	private Scene sceneD;
	
	private Scene (int layout, int valueA, int valueB, int valueC, int valueD, 
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

	
}
