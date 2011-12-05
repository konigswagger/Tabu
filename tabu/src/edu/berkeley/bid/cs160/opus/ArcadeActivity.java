package edu.berkeley.bid.cs160.opus;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ArcadeActivity extends OpusActivity {
	Scene currentScene;
	
	
	public void onContinueClicked(View view) {
		Scene nextScene = currentScene.getContinueScene();

		if (nextScene == null) {
			endLevel();
		} else {
			currentScene = nextScene;
			setContentView(currentScene.getLayout());
		}
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
	
	private void endLevel() {
		Intent intent = new Intent(this, LevelActivity.class); 
        intent.putExtra("Country", "China");
        intent.putExtra("Level", "ended");
        startActivity(intent);
	}

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        currentScene = Scene.AIRPORT;
        setContentView(currentScene.getLayout());
    }
    
	
	private void showToast(int points) {
		
		LayoutInflater inflater = getLayoutInflater();
	    View layout = inflater.inflate(R.layout.toast_pos,
	                                   (ViewGroup) findViewById(R.id.toast_pos_root));
	    /*
	    ImageView image = (ImageView) layout.findViewById(R.id.flower);
	    image.setImageResource(R.drawable.flower);
	    */
	    TextView text2 = (TextView) layout.findViewById(R.id.text);
	    if (points > 0){
	    	ImageView image = (ImageView) layout.findViewById(R.id.image_reaction);
		    image.setImageResource(R.drawable.happyface);
	    	text2.setText("Good Job!");
	    }else{
	    	ImageView image = (ImageView) layout.findViewById(R.id.image_reaction);
		    image.setImageResource(R.drawable.sadface);
	    	text2.setText("Too Bad!");
	    }

	    Toast toast = new Toast(getApplicationContext());
	    toast.setGravity(Gravity.TOP, 0, 0);
	    toast.setDuration(Toast.LENGTH_LONG);
	    toast.setView(layout);
	    toast.show();
	}
	
}
