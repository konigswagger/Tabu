package edu.berkeley.bid.cs160.opus;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;


public class SelectCountryFragment extends ListFragment {
	ListView lv;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setListAdapter(new CountryAdapter());
		
		
		
	}
	
	@Override
	public void onStart() {
		super.onStart();
		
		lv = getListView();
		lv.setScrollbarFadingEnabled(false);
				
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				LinearLayout ll = (LinearLayout) view;
				TextView tv = (TextView) ll.getChildAt(0);
				if (tv.getText() == "China") {
					/*Intent intent = new Intent(SelectCountryFragment.this.getActivity(), ArcadeActivity.class);
		            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
		            intent.putExtra("User", ((OpusActivity) getActivity()).user);*/
					Intent intent = new Intent(SelectCountryFragment.this.getActivity(), LevelActivity.class); 
		            intent.putExtra("Country", tv.getText());
		            startActivity(intent);
					
				} else {
					
					Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Country currently locked.", Toast.LENGTH_SHORT);
			    	toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
			    	toast.show();
					
					Intent intent = new Intent(SelectCountryFragment.this.getActivity(), SelectCountryActivity.class);
		            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
		            startActivity(intent);
				}
			}
		});
		
	}

	
}
