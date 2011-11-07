package edu.berkeley.bid.cs160.opus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void onArcadeClicked(View view) {
    	Intent intent = new Intent(this, ArcadeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
				| Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    
    public void onOnlineClicked(View view) {
    }
    
    public void onInviteClicked(View view) {
    	Intent intent = new Intent(this, ArcadeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
				| Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
