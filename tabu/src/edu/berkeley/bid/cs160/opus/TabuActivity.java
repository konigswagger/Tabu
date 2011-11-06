package edu.berkeley.bid.cs160.opus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class TabuActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Intent intent = new Intent(this, StartActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
				| Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        
        //setContentView(R.layout.main);
    }
}