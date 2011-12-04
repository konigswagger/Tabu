package edu.berkeley.bid.cs160.opus;

import android.app.Activity;
import android.content.Intent;
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
    
}
