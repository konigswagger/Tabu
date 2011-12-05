package edu.berkeley.bid.cs160.opus;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends OpusActivity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void onArcadeClicked(View view) {
    	Intent intent = new Intent(this, SelectCountryActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
				| Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("User", user);
        startActivity(intent);
    }
    
    public void onOnlineClicked(View view) {
    	Toast toast = Toast.makeText(getApplicationContext(), "Online gameplay currently not available.", Toast.LENGTH_SHORT);
    	toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
    	toast.show();
    }
    
    public void onProfileClicked(View view) {
    	Intent intent = new Intent(this, ProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
				| Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("User", user);
        intent.putExtra("New", false);
        intent.putExtra("Edit", false);
        startActivityForResult(intent, 10);
    }
    
    public void onInviteClicked(View view) {
    	Intent intent = new Intent(this, InviteActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
				| Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("User", user);
        startActivity(intent);
    }
    
	public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.menu_help:
        	// Do something when help is clicked.
        	Builder builder = new AlertDialog.Builder(this);
    		builder.setTitle("Main Menu Help");
    		builder.setMessage("'TABU' in top left takes you back to the Main Menu, which you are currently on.\n\n" +
    				"'?' in top right takes you to this help screen.\n\n" +
    				"'(Your name)' on top right takes you to your profile where you can view or edit it.\n\n" +
    				"'ARCADE' allows you to start playing the game.\n\n" +	
    				"'ONLINE' will allow you to play online with other users, but it is not implemented yet.\n\n" +	
    				"'PROFILE' takes you to your profile where you can view or edit it.\n\n" +
    				"'INVITE FRIENDS' allows you to choose to invite friends from Facebook or your contacts.");
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
