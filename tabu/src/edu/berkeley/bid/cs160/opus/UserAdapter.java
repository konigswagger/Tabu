package edu.berkeley.bid.cs160.opus;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class UserAdapter extends BaseAdapter {
	private ArrayList<User> users = new ArrayList<User>();
	private static final String[] usernames = {"New User", "Guest", "Josef", "Gautam", "Hussein", "Austin", "Nancy"};
	
	public UserAdapter() {
		for (int i = 0; i < usernames.length; i++) {
			users.add(new User(usernames[i], null));
		}
	}

	public int getCount() {
		return users.size();
	}

	public Object getItem(int position) {
		return users.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView= inflater.inflate(R.layout.user_list_item, parent, false);
		}
		
		User user = users.get(position);
		
		TextView userName = (TextView) convertView.findViewById(R.id.tv_user_name);
		userName.setText(user.getName());
	
		return convertView;
	}
	
	
}