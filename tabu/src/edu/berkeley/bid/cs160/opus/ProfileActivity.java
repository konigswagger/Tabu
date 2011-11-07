package edu.berkeley.bid.cs160.opus;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.WindowManager;

public class ProfileActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		setContentView(R.layout.profile);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.profile1menu, menu);
		//menu.findItem(R.id.profileBarEdit).setVisible(false);
		//menu.findItem(R.id.profileBarBack).setVisible(false);
		menu.findItem(R.id.profileBarSave).setVisible(false);
		menu.findItem(R.id.profileBarCancel).setVisible(false);
		return super.onCreateOptionsMenu(menu);
	}
	
	
	
	
	
}
