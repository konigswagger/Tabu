package edu.berkeley.bid.cs160.opus;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class InviteActivity extends OpusActivity {
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.invite_from);
	}
	
	public void onFacebookClicked(View view) {
		Toast toast = Toast.makeText(getApplicationContext(), "Connection to Facebook not implemented yet.", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.show();
    }
	
	public void onContactsClicked(View view) {
		Toast toast = Toast.makeText(getApplicationContext(), "Connection to Contacts not implemented yet.", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.show();
    }

	public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.menu_help:
        	// Do something when help is clicked.
        	Builder builder = new AlertDialog.Builder(this);
    		builder.setTitle("Invite Friends Help");
    		builder.setMessage("'TABU' on the top left takes you back to the Main Menu.\n" + 
    				"'?' on the top right takes you to this pop-up help screen.\n" +
    				"'(Your name)' on top right takes you to your profile.\n" +
    				"‘Facebook’ will take you to your Facebook friends so you can select who to invite.\n" +
    				"‘Contacts’ will take you to your Contacts so you can select which friends you want to invite.\n" +
    				"Note: Connections to ‘Facebook’ and ‘Contacts’ have not been implemented yet.");
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