package edu.berkeley.bid.cs160.opus;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
		invalidateOptionsMenu();
		showToast(currentScene.getValueA());
		currentScene = currentScene.getSceneA();
		setContentView(currentScene.getLayout());

	}

	public void onButtonBClicked(View view) {
		currentScore = currentScore + currentScene.getValueB();
		invalidateOptionsMenu();
		showToast(currentScene.getValueB());
		currentScene = currentScene.getSceneB();
		setContentView(currentScene.getLayout());
	}
	
	public void onButtonCClicked(View view) {
		currentScore = currentScore + currentScene.getValueC();
		invalidateOptionsMenu();
		showToast(currentScene.getValueC());
		currentScene = currentScene.getSceneC();
		setContentView(currentScene.getLayout());
	}
	
	public void onButtonDClicked(View view) {
		currentScore = currentScore + currentScene.getValueD();
		invalidateOptionsMenu();
		showToast(currentScene.getValueD());
		currentScene = currentScene.getSceneD();
		setContentView(currentScene.getLayout());
	}
	
	private void endLevel() {
		Intent intent = new Intent(this, LevelActivity.class); 
        intent.putExtra("Country", "China");
        intent.putExtra("Ended", true);
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
	    	text2.setText("Good Job! You gained " + points + "!");
	    }else{
	    	ImageView image = (ImageView) layout.findViewById(R.id.image_reaction);
		    image.setImageResource(R.drawable.sadface);
	    	text2.setText("Too Bad! You got " + points + "!");
	    }

	    Toast toast = new Toast(getApplicationContext());
	    toast.setGravity(Gravity.TOP, 0, 0);
	    toast.setDuration(Toast.LENGTH_LONG);
	    toast.setView(layout);
	    toast.show();
	}
	
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.menu_help:
        	// Do something when help is clicked.
        	Builder builder = new AlertDialog.Builder(this);
    		builder.setTitle("Help");
    		builder.setMessage("'TABU' on the top left takes you back to the Main Menu.\n\n" + 
    				"'?' on the top right takes you to this pop-up help screen.\n\n" +
    				"Read the text and answer the questions by clicking on the blue buttons.\n\n" +
    				"A right answer awards you positive points and a wrong answer gains you negative points." +
    				"Completing the level opens up the next level.");
    		builder.setCancelable(false);
    		builder.setNegativeButton("Close", new OnClickListener() {
    			public void onClick(DialogInterface dialog, int id) {
    				dialog.cancel();
    			}
    		});
    		AlertDialog help = builder.create();
    		help.show();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}
