package edu.berkeley.bid.cs160.opus;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ArcadeActivity extends OpusActivity {
	Scene currentScene;
	
	
	public void onContinueClicked(View view) {
		currentScene = currentScene.getContinueScene();
		setContentView(currentScene.getLayout());
	}
	
	public void onButtonAClicked(View view) {
		currentScene = currentScene.getSceneA();
		setContentView(currentScene.getLayout());
		showToast(currentScene.getValueA());
	}

	public void onButtonBClicked(View view) {
		currentScene = currentScene.getSceneB();
		setContentView(currentScene.getLayout());
		showToast(currentScene.getValueB());
	}
	
	public void onButtonCClicked(View view) {
		currentScene = currentScene.getSceneC();
		setContentView(currentScene.getLayout());
		showToast(currentScene.getValueC());
	}
	
	public void onButtonDClicked(View view) {
		currentScene = currentScene.getSceneD();
		setContentView(currentScene.getLayout());
		showToast(currentScene.getValueD());
	}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        currentScene = Scene.AIRPORT;
        setContentView(currentScene.getLayout());
    }
    
	
	private void showToast(int points) {
		Context context = getApplicationContext();
		CharSequence text = points + " Points!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	
}
