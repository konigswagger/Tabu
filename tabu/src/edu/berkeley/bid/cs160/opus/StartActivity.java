package edu.berkeley.bid.cs160.opus;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class StartActivity extends OpusActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.start);
    }   
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.open_camera:
            Intent intent = new Intent(this, CameraSample.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
    				| Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        case R.id.menu_help:
        	// Do something when help is clicked.
        	Builder builder = new AlertDialog.Builder(this);
    		builder.setTitle("Select User Help");
    		builder.setMessage("'TABU' on the top left takes you back to the Main Menu.\n\n" + 
    				"'?' on the top right takes you to this pop-up help screen.\n\n" +
    				"You may scroll through the list of users to select your user account.\n\n" +
    				"'New User' let's you create a new account.\n\n" +
    				"'Guest' let's you play Tabu without an account.");
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