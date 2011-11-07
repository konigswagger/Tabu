package edu.berkeley.bid.cs160.opus;

import java.util.LinkedList;

public enum Scene {
	INTRO			(R.layout.scenes.intro,			0, 0, 0, 0, null, null, null, null),
	AIRPORT			(R.layout.scenes.airport,		0, 0, 0, 0, null, null, null, null),
	BIZCARD			(R.layout.scenes.bizcard, 		0, 0, 0, 0, null, null, null, null),
	BIZCARD_RIGHT	(R.layout.scenes.bizcard_right, 0, 0, 0, 0, null, null, null, null),
	BIZCARD_WRONG	(R.layout.scenes.bizcard_wrong, 0, 0, 0, 0, null, null, null, null),
	TAXI			(R.layout.scenes.taxi, 			0, 0, 0, 0, null, null, null, null),
	TAXI_RIGHT		(R.layout.scenes.taxi_right, 	0, 0, 0, 0, null, null, null, null),
	TAXI_WRONG		(R.layout.scenes.taxi_wrong, 	0, 0, 0, 0, null, null, null, null);
	
	
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
		
	}
	
	public int getLayout() {
		return layout;
	}
	
}
