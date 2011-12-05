package edu.berkeley.bid.cs160.opus;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends OpusActivity {
	
	public boolean editMode;
	public boolean newMode;
	public FragmentManager fm;
	public FragmentTransaction ft;
	private String user;
	private TextView userName;
	private ImageView userPicture;
	
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
			
			userPicture = (ImageView) fm.findFragmentById(R.id.profile_pic_frag).getView().findViewById(R.id.iv_pic);
			
			int pic = R.drawable.user_picture_default;
			
			if (user == "Hussein") {
				pic = R.drawable.husseinpic;
			} else if (user == "Josef") {
				pic = R.drawable.josef;
			} else if (user == "Nancy") {
				pic = R.drawable.nancy;
			} else if (user == "Gautam") {
				pic = R.drawable.gautam;
			} else if (user == "Austin") {
				pic = R.drawable.austin;
			}
			
			userPicture.setImageResource(pic);
			
		}
	}
	
	public void onFacebookConnectClicked(View view) {
		Toast toast = Toast.makeText(getApplicationContext(), "Connection to Facebook not implemented yet.", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.show();
    }
	
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.profile1menu, menu);	
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		if (editMode) {
			menu.findItem(R.id.profileBarEdit).setVisible(false);
			//menu.findItem(R.id.profileBarBack).setVisible(false);
			menu.findItem(R.id.profileBarSave).setVisible(true);
			menu.findItem(R.id.profileBarCancel).setVisible(true);
		} else {
			menu.findItem(R.id.profileBarEdit).setVisible(true);
			//menu.findItem(R.id.profileBarBack).setVisible(true);
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
        case R.id.menu_help:
        	// Do something when help is clicked.
        	Builder builder = new AlertDialog.Builder(this);
    		builder.setTitle("Profile Help");
    		builder.setMessage("'TABU' on the top left takes you back to the Main Menu.\n\n" + 
    				"'?' on the top right takes you to this pop-up help screen.\n\n" +
    				"'(Your name)' on top right takes you to this profile screen where you can edit or view your profile.\n\n" +
    				"‘Edit' allows you to edit your user profile.\n\n" +
    				"‘Cancel' goes back without saving any changes.\n\n" +
    				"'Done' saves the changes you made.\n\n" +
    				"Note: Connection to Facebook and adding a profile picture not implemented yet.");
    		builder.setCancelable(false);
    		builder.setNegativeButton("Close", new OnClickListener() {
    			public void onClick(DialogInterface dialog, int id) {
    				dialog.cancel();
    			}
    		});
    		AlertDialog help = builder.create();
    		help.show();
            return true;
        case R.id.profileBarEdit:
        	editMode = true;
        	
    		ft = fm.beginTransaction();
			ft.hide(fm.findFragmentById(R.id.profile_info_frag));
			ft.show(fm.findFragmentById(R.id.profile_edit_frag));
			ft.commit();
        	invalidateOptionsMenu();
            return true;
        //case R.id.profileBarBack:
        	//Intent resultIntent = new Intent();
        	//resultIntent.putExtra("User", user);
        	//setResult(Activity.RESULT_OK, resultIntent);
        	//finish();
        	//return true;
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
	            t.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
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
