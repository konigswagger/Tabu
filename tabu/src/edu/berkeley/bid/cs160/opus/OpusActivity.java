package edu.berkeley.bid.cs160.opus;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OpusActivity extends Activity {
	public String user;
	private FragmentManager fm;
	private FragmentTransaction ft;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		user = getIntent().getStringExtra("User");
		
		fm = getFragmentManager();
		ft = fm.beginTransaction();
	}
	
	@Override
	public void onResume() {
		super.onResume();

	}

	public boolean onPrepareOptionsMenu(Menu menu) {
		MenuItem profileButton = menu.findItem(R.id.menu_profile);
		
		if(user != null) {
			profileButton.setVisible(true);
			profileButton.setTitle(user);
		} else {
			profileButton.setVisible(false);
		}
			
		return true;
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.default_menu, menu);
		
		MenuItem profileButton = menu.findItem(R.id.menu_profile);
		
		if(user != null) {
			profileButton.setVisible(true);
			profileButton.setTitle(user);
		} else {
			profileButton.setVisible(false);
		}
		
		return super.onCreateOptionsMenu(menu);
	}
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.menu_help:
        	// Do something when help is clicked.
            return true;
        case R.id.menu_profile:
        	// Do something when profile is clicked.
        	Intent intent = new Intent(this, ProfileActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
    				| Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("User", user);
            intent.putExtra("New", false);
            intent.putExtra("Edit", false);
            startActivityForResult(intent, 10);
        	return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    
    @Override 
    public void onActivityResult(int requestCode, int resultCode, Intent data) {     
      super.onActivityResult(requestCode, resultCode, data); 
      switch(requestCode) { 
        case (10) : { 
          if (resultCode == Activity.RESULT_OK) { 
	          user = data.getStringExtra("User");
	          invalidateOptionsMenu();
          } 
          break; 
        } 
      } 
    }
	
}
