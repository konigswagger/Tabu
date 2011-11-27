package edu.berkeley.bid.cs160.opus;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class SelectUserFragment extends ListFragment {
	ListView lv;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		

		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setListAdapter(new UserAdapter());		
	}
	
	@Override
	public void onStart() {
		super.onStart();
		
		lv = getListView();
				
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				LinearLayout ll = (LinearLayout) view;
				TextView tv = (TextView) ll.getChildAt(1);
				if (tv.getText() == "New User") {
					Intent intent = new Intent(SelectUserFragment.this.getActivity(), ProfileActivity.class);
		            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
		            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		            intent.putExtra("Edit", true);
		            intent.putExtra("New", true);

		            startActivityForResult(intent, 0);

					
				} else {
					Intent intent = new Intent(SelectUserFragment.this.getActivity(), MainActivity.class);
		            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
		            intent.putExtra("User", String.valueOf(tv.getText()));
		            startActivityForResult(intent, 0);
				}
			}
		});
		
	}

}
