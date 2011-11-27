package edu.berkeley.bid.cs160.opus;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends Activity {
	
	public boolean editMode;
	public boolean newMode;
	public FragmentManager fm;
	public FragmentTransaction ft;
	private String user;
	private TextView userName;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		
		editMode = getIntent().getBooleanExtra("Edit", false);
		newMode = getIntent().getBooleanExtra("New", false);
		setContentView(R.layout.profile);
		
		fm = getFragmentManager();
		ft = fm.beginTransaction();
		
		if (newMode) {
			ft.hide(fm.findFragmentById(R.id.profile_info_frag));
			ft.commit();
		} else {
			ft.hide(fm.findFragmentById(R.id.profile_edit_frag));
			ft.commit();
		}
		
		user = getIntent().getStringExtra("User");
		
		if (user != null) {
			userName = (TextView) fm.findFragmentById(R.id.profile_pic_frag).getView().findViewById(R.id.tv_name);
			userName.setText(user);
		}
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
        	
    		ft = fm.beginTransaction();
			ft.hide(fm.findFragmentById(R.id.profile_info_frag));
			ft.show(fm.findFragmentById(R.id.profile_edit_frag));
			ft.commit();
        	invalidateOptionsMenu();
            return true;
        case R.id.profileBarBack:
        	Intent resultIntent = new Intent();
        	resultIntent.putExtra("User", user);
        	setResult(Activity.RESULT_OK, resultIntent);
        	finish();
        	return true;
        case R.id.profileBarSave:
        	editMode = false;
        	invalidateOptionsMenu();
 
        	Fragment profileInfo = fm.findFragmentById(R.id.profile_edit_frag);
        	EditText newUserName = (EditText) profileInfo.getView().findViewById(R.id.et_user_name);
        	user = newUserName.getText().toString();
        	
        	if (newMode) {
	        	intent = new Intent(this, MainActivity.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
	    				| Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            intent.putExtra("User", user);
	            startActivity(intent);
	            Toast t = Toast.makeText(getApplicationContext(), "User Saved!", Toast.LENGTH_SHORT);
	            t.show();
	            newMode = false;
        	} else {
    			userName = (TextView) fm.findFragmentById(R.id.profile_pic_frag).getView().findViewById(R.id.tv_name);
    			userName.setText(user);
    			
        		ft = fm.beginTransaction();
    			ft.show(fm.findFragmentById(R.id.profile_info_frag));
    			ft.hide(fm.findFragmentById(R.id.profile_edit_frag));
    			ft.commit();
        	}
    	
        	return true;
        case R.id.profileBarCancel:
        	if (newMode) {
        		finish();
        	} else {
        		ft = fm.beginTransaction();
    			ft.show(fm.findFragmentById(R.id.profile_info_frag));
    			ft.hide(fm.findFragmentById(R.id.profile_edit_frag));
    			ft.commit();
        	}
        	return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
	
	
	
	
	
}
