package edu.berkeley.bid.cs160.opus;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InviteActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	 private Button facebook;
	 private Button contacts;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invite_from);
        contacts = (Button) findViewById(R.id.contacts);
        facebook = (Button) findViewById(R.id.facebook);
//        facebook.setOnClickListener(this);
//        contacts.setOnClickListener(this);
        /*
        facebook.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) 
            {
            	
            }
          });

        contacts.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) 
            {
            	
            }
          });
	*/
    }
	
	void showDialog() {

	    // DialogFragment.show() will take care of adding the fragment
	    // in a transaction.  We also want to remove any currently showing
	    // dialog, so make our own transaction and take care of that here.
	    FragmentTransaction ft = getFragmentManager().beginTransaction();
	    Fragment prev = getFragmentManager().findFragmentByTag("dialog");
	    if (prev != null) {
	        ft.remove(prev);
	    }
	    ft.addToBackStack(null);

	    // Create and show the dialog.
	    DialogFragment newFragment = InviteFrom.newInstance("Invite Friend");
	    newFragment.show(ft, "dialog");
	}
	/*

	void showDialog(String choice) {
	    DialogFragment newFragment = InviteFrom.newInstance(
	            choice);
	    newFragment.show(getFragmentManager(), "dialog");
	}
*/
	public void doPositiveClick() {
	    // Do stuff here.
	    Log.i("FragmentAlertDialog", "Positive click!");
	}

	public void doNegativeClick() {
	    // Do stuff here.
	    Log.i("FragmentAlertDialog", "Negative click!");
	}




	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
			case R.id.contacts:
				showDialog();
				break;
			case R.id.facebook:
				showDialog();
				break;
		}
	}
	@Override
    protected Dialog onCreateDialog(int id) {
		Context mContext = getApplicationContext();
		Dialog dialog = new Dialog(mContext);

		dialog.setContentView(R.layout.password_dialog);
		dialog.setTitle("Enter Password:");
        //Button EnterButton = (Button) findViewById(R.id.enter);
        //Button CancelButton = (Button) findViewById(R.id.cancel);
        /*
        EnterButton.setOnClickListener( new View.OnClickListener()
        {
			public void onClick(View v)
			{
				Uri uri = Uri.parse( "http://www.facebook.com" );
				startActivity( new Intent( Intent.ACTION_VIEW, uri ) );
			}
        });
		
        CancelButton.setOnClickListener( new View.OnClickListener()
        {
			public void onClick(View v)
			{
				Uri uri = Uri.parse( "http://www.google.com" );
				startActivity( new Intent( Intent.ACTION_VIEW, uri ) );
			}
        });
        */
        // We save off the progress dialog in a field so that we can dismiss
        // it later. We can't just call dismissDialog(0) because the system
        // can lose track of our dialog if there's an orientation change.
        return dialog;
		
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.default_menu, menu);
      return super.onCreateOptionsMenu(menu);
    }
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.help:
// Do something when help is clicked.
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }

	
}