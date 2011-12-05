package edu.berkeley.bid.cs160.opus;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;

public class SelectCountryActivity extends OpusActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.select_country);
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.menu_help:
        	// Do something when help is clicked.
        	Builder builder = new AlertDialog.Builder(this);
    		builder.setTitle("Select Country Help");
    		builder.setMessage("'TABU' on the top left takes you back to the Main Menu.\n" + 
    				"'?' on the top right takes you to this pop-up help screen.\n" +
    				"'(Your name)' on top right takes you to your profile where you can view or edit it.\n" +
    				"Scroll throught the list of Countries to Select the Country you would like to play." +
    				"Currently China is the only Country that has been implemented.");
    		builder.setCancelable(false);
    		builder.setNegativeButton("Close", new OnClickListener() {
    			public void onClick(DialogInterface dialog, int id) {
    				dialog.cancel();
    			}
    		});
    		AlertDialog help = builder.create();
    		help.show();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}