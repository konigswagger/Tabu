package edu.berkeley.bid.cs160.opus;


public enum Scene {
	// SCENE					LAYOUT								CONT BUTTON? CONT SCENE 					A 	B	C	D	A					B					C				D
	END							(R.layout.end,						false,		null,							0,	0,	0,	0,	null,				null,				null,			null),
	MARKETPLACE_SHOPMENU	 	(R.layout.marketplace_shopmenu, 	false,		null,							0,	0,	0,	0,	null,				null,				null,			null),
	MARKETPLACE_SHOPDISTRICT 	(R.layout.marketplace_shopdistrict, true,		MARKETPLACE_SHOPMENU,			0,	0,	0,	0,	null,				null,				null,			null),
	POLICE_RIGHT				(R.layout.police_right,				true, 		END,							0,	0,	0,	0,	null, 				null, 				null,			null),
	POLICE_WRONG				(R.layout.police_wrong,				true,		END,							0,	0,	0,	0, 	null,				null,				null,			null),
	POLICE						(R.layout.police,					false, 		null,							0,	0,	0,	0, 	POLICE_WRONG, 		POLICE_WRONG, 		POLICE_RIGHT, 	POLICE_WRONG),
	HOTEL_RIGHT					(R.layout.hotelwater_right,			true, 		POLICE,							0,	0,	0,	0,	null, 				null, 				null, 			null),
	HOTEL_WRONG_2				(R.layout.hotelwater_wrong_2,		true, 		POLICE,							0,	0,	0,	0,	null, 				null, 				null, 			null),
	HOTEL_WRONG_1				(R.layout.hotelwater_wrong_1,		true, 		POLICE,							0,	0,	0,	0,	null, 				null, 				null, 			null),
	HOTEL_WATER					(R.layout.hotelwater,				false, 		null,							0,	0,	0,	0,	HOTEL_WRONG_1, 		HOTEL_RIGHT, 		HOTEL_WRONG_2, 	null),
	HOTEL						(R.layout.hotel,					true,		HOTEL_WATER,					0,	0,	0,	0,	null,				null,				null, 			null),
	TAXI_WRONG					(R.layout.taxi_wrong, 				true,		END,							0,	0,	0,	0, 	null,				null,				null,			null),
	TAXI_RIGHT					(R.layout.taxi_right, 				true,		END,							0,	0,	0,	0, 	null,				null,				null,			null),
	TAXI						(R.layout.taxi, 					false,		null,							0,	0,	0,	0, 	TAXI_RIGHT,			TAXI_WRONG,			null,			null),
	BIZCARD_WRONG				(R.layout.bizcard_wrong,			true,		TAXI,							0,	0,	0,	0, 	null,				null,				null,			null),
	BIZCARD_RIGHT				(R.layout.bizcard_right,			true,		TAXI,							0,	0,	0,	0, 	null,				null,				null,			null),
	BIZCARD						(R.layout.bizcard, 					false,		null,							0,	0,	0,	0, 	BIZCARD_RIGHT,		BIZCARD_WRONG,		BIZCARD_WRONG,	null),
	AIRPORT						(R.layout.airport,					true,		BIZCARD,						0,	0,	0,	0, 	null,				null,				null,			null),	
	INTRO						(R.layout.intro,					true,		END,							0,	0,	0,	0, 	null,				null,				null,			null);
	
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
	
	public int getValueB() {
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
