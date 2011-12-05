package edu.berkeley.bid.cs160.opus;

import android.content.Context;
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

	    Toast toast2 = new Toast(getApplicationContext());
	    toast2.setGravity(Gravity.TOP, 0, 0);
	    toast2.setDuration(Toast.LENGTH_LONG);
	    toast2.setView(layout);
	    toast2.show();
		
		
		
	}
	
}
