package edu.berkeley.bid.cs160.opus;

import java.util.Arrays;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Level extends OpusActivity {

	HorizontalScrollView sv;
	LinearLayout ll;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    // TODO Auto-generated method stub
	    setContentView(R.layout.levels);
	    sv = (HorizontalScrollView) findViewById(R.id.level_scroll_ll);
	    
	    ll = (LinearLayout) findViewById(R.id.levels_ll);
	    
	   
	    Bundle b = getIntent().getExtras();
	    Log.i("LEVEL","Country " + b.getString("Country"));
	    String[] temp = Arrays.copyOf(((TabuApplication)getApplication()).getStructure().get(b.getString("Country")).keySet().toArray(), ((TabuApplication)getApplication()).getStructure().get(b.getString("Country")).keySet().toArray().length, String[].class);
	    String t = temp[2];
	    temp[2] = temp[3];
	    temp[3] = t;
	    for(String x : temp)
	    {
	    	Log.i("LEVEL","Level: " + x);
	    	
	    	ImageView iv = new ImageView(this);
	    	iv.setPadding(200, 100, 200, 10);
	    	switch (x.toLowerCase().charAt(0))
		    {
	    		case 'i':
			    		iv.setImageDrawable(getResources().getDrawable(R.drawable.intro_icon));
			    		iv.setOnClickListener(new OnClickListener() 
			            {
			                public void onClick(View v) 
			                {
			                	Intent intent = new Intent(Level.this, ArcadeActivity.class);
			                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
			                    intent.putExtra("User",  user);
			                    startActivity(intent);
			                }
			            });
			    
			    	break;
	    		case 'a':
	    			if (((TabuApplication)getApplication()).getStructure().get(b.getString("Country")).get(x))
			    	{
			    		iv.setImageDrawable(getResources().getDrawable(R.drawable.airport_icon));
			    	}
			    	else
			    	{
			    		iv.setImageDrawable(getResources().getDrawable(R.drawable.airport_icon_locked));
			    	}
	    			break;
	    		case 's':
	    			if (((TabuApplication)getApplication()).getStructure().get(b.getString("Country")).get(x))
			    	{
			    		iv.setImageDrawable(getResources().getDrawable(R.drawable.shopping_icon_unlocked));
			    	}
			    	else
			    	{
			    		iv.setImageDrawable(getResources().getDrawable(R.drawable.shopping_icon_locked));
			    	}
	    			break;
	    		case 'h':
	    			if (((TabuApplication)getApplication()).getStructure().get(b.getString("Country")).get(x))
			    	{
			    		iv.setImageDrawable(getResources().getDrawable(R.drawable.hotel_icon_unlocked));
			    	}
			    	else
			    	{
			    		iv.setImageDrawable(getResources().getDrawable(R.drawable.hotel_icon_locked));
			    	}
	    			break;
		    }
	    	ll.addView(iv);

	    }
	    
	}

}
