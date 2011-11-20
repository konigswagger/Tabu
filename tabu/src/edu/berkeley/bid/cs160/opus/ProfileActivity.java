package edu.berkeley.bid.cs160.opus;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends Activity {
	
	public boolean editMode;
	public FragmentManager fm;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		//editMode = savedInstanceState.getBoolean("Edit");
		
		editMode = getIntent().getBooleanExtra("Edit", false);
		setContentView(R.layout.profile);
		
		fm = getFragmentManager();
		
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.profile1menu, menu);	
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		if (editMode) {
			menu.findItem(R.id.profileBarEdit).setVisible(false);
			menu.findItem(R.id.profileBarBack).setVisible(false);
			menu.findItem(R.id.profileBarSave).setVisible(true);
			menu.findItem(R.id.profileBarCancel).setVisible(true);
		} else {
			menu.findItem(R.id.profileBarEdit).setVisible(true);
			menu.findItem(R.id.profileBarBack).setVisible(true);
			menu.findItem(R.id.profileBarSave).setVisible(false);
			menu.findItem(R.id.profileBarCancel).setVisible(false);
		}
		return true;
	}
	
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
    	
    	Intent intent;
    	
        switch (item.getItemId()) {
        case R.id.profileBarEdit:
        	editMode = true;
        	invalidateOptionsMenu();
            return true;
        case R.id.profileBarBack:
        	intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
    				| Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        	return true;
        case R.id.profileBarSave:
        	editMode = false;
        	invalidateOptionsMenu();
        	
        	Fragment profileInfo = fm.findFragmentById(R.id.profile_info_frag);
        	
        	TextView userName = (TextView) profileInfo.getView().findViewById(R.id.tv_user_name);
        	
        	intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
    				| Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("User", userName.getText());
            startActivityForResult(intent, 0);
            Toast t = Toast.makeText(getApplicationContext(), "User Saved!", Toast.LENGTH_LONG);
            t.show();
            startActivity(intent);
        	return true;
        case R.id.profileBarCancel:
        	finish();
        	return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
	
	
	
	
	
}
