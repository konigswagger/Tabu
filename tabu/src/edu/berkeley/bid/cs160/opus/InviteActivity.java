package edu.berkeley.bid.cs160.opus;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
}