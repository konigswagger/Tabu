package edu.berkeley.bid.cs160.opus;

import java.util.LinkedList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class ArcadeActivity extends Activity {
	RelativeLayout rl_arcade;
	LinkedList<Scene> scenes;
	
	int	currentScene;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // The activity is being created.
        
        rl_arcade = (RelativeLayout) findViewById(R.id.rl_arcade);
        button1 = (Button);
        
        if (scenes.isEmpty()) {
        	// fill from database or something
        	// setup current scene
        } else {
        	currentScene = 1;
        }
        
        setBackground(currentScene);
        setButtons(currentScene);
    }
    private void setButtons(int scene) {
		// TODO Auto-generated method stub
		
	}
	private void setBackground(int scene) {
		 rl_arcade.setBackgroundResource(scenes.get(scene).getImage());
		
	}
	@Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
    }
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
    }
	
}
