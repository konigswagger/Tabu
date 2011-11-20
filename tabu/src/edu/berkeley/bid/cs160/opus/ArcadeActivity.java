package edu.berkeley.bid.cs160.opus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

public class ArcadeActivity extends Activity {
	RelativeLayout rl_arcade;
	Scene currentScene;
	
	
	public void onContinueClicked(View view) {
		currentScene = currentScene.getContinueScene();
		setContentView(currentScene.getLayout());
	}
	
	public void onButtonAClicked(View view) {
		currentScene = currentScene.getSceneA();
		setContentView(currentScene.getLayout());
	}
	
	public void onButtonBClicked(View view) {
		currentScene = currentScene.getSceneB();
		setContentView(currentScene.getLayout());
	}
	
	public void onButtonCClicked(View view) {
		currentScene = currentScene.getSceneC();
		setContentView(currentScene.getLayout());
	}
	
	public void onButtonDClicked(View view) {
		currentScene = currentScene.getSceneD();
		setContentView(currentScene.getLayout());
	}
	
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.default_menu, menu);
      return super.onCreateOptionsMenu(menu);
    }
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.menu_help:
// Do something when help is clicked.
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // The activity is being created.
        
        currentScene = Scene.AIRPORT;
        setContentView(currentScene.getLayout());
        
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
