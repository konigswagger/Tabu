package edu.berkeley.bid.cs160.opus;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class InviteFrom extends OpusActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.invite_from);
	}

	public void onFacebookClicked(View view) {
		Toast toast = Toast.makeText(getApplicationContext(), "Connection to Facebook not implemented yet.", Toast.LENGTH_SHORT);
		toast.show();
    }
	
	public void onContactsClicked(View view) {
		Toast toast = Toast.makeText(getApplicationContext(), "Connection to Contacts not implemented yet.", Toast.LENGTH_SHORT);
		toast.show();
    }

}