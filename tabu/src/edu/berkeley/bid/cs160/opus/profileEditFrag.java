package edu.berkeley.bid.cs160.opus;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class profileEditFrag extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.profile_edit_frag, container, false);
	}
	
	public void onFacebookConnectClicked(View view) {
		Toast toast = Toast.makeText(getApplicationContext(), "Connection to Facebook not implemented yet.", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.show();
    }
	private Context getApplicationContext() {
		// TODO Auto-generated method stub
		return null;
	}
}
