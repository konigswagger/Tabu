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
		currentScore = currentScore + currentScene.getValueA();
		showToast(currentScene.getValueA());
		currentScene = currentScene.getSceneA();
		setContentView(currentScene.getLayout());

	}

	public void onButtonBClicked(View view) {
		currentScore = currentScore + currentScene.getValueB();
		showToast(currentScene.getValueB());
		currentScene = currentScene.getSceneB();
		setContentView(currentScene.getLayout());
	}
	
	public void onButtonCClicked(View view) {
		currentScore = currentScore + currentScene.getValueC();
		showToast(currentScene.getValueC());
		currentScene = currentScene.getSceneC();
		setContentView(currentScene.getLayout());
	}
	
	public void onButtonDClicked(View view) {
		currentScore = currentScore + currentScene.getValueD();
		showToast(currentScene.getValueD());
		currentScene = currentScene.getSceneD();
		setContentView(currentScene.getLayout());
	}
	
	private void endLevel() {
		Intent intent = new Intent(this, LevelActivity.class); 
        intent.putExtra("Country", "China");
        intent.putExtra("Ended", "true");
        intent.putExtra("User", user);
        intent.putExtra("Score", String.valueOf(currentScore));
        startActivity(intent);
	}

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Bundle b = getIntent().getExtras();
        String level = b.getString("level");
        
        currentScene = Scene.valueOf(level);
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
