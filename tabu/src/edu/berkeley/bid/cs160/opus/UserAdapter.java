package edu.berkeley.bid.cs160.opus;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class UserAdapter extends BaseAdapter {
	private ArrayList<User> users = new ArrayList<User>();
	private static final String[] usernames = {"New User", "Guest", "Gautam", "Hussein", "Austin", "Josef", "Nancy"};
	private static final int[] userpics = {R.drawable.user_picture_default, R.drawable.user_picture_default, R.drawable.gautam, R.drawable.josef, R.drawable.austin,  R.drawable.user_picture_default, R.drawable.nancy};
	
	
	
	public UserAdapter() {
		for (int i = 0; i < usernames.length; i++) {
			users.add(new User(usernames[i], userpics[i]));
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
		ImageView userPic = (ImageView) convertView.findViewById(R.id.qc_user_pic);
		userName.setText(user.getName());
		userPic.setImageResource(user.getDrawable());

		return convertView;
	}
	
	
}