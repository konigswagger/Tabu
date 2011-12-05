package edu.berkeley.bid.cs160.opus;

import java.util.ArrayList;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class CountryAdapter extends BaseAdapter {
	private ArrayList<Country> countries = new ArrayList<Country>();
	private static final String[] countrynames = {"Afghanistan", "Argentina", "Brazil", "Bangladesh", "Belize", "Chile", "China", "Canada", "Denmark", "Egypt", "France", "Greece", "Haiti", "India"};
	
	public CountryAdapter() {
		for (int i = 0; i < countrynames.length; i++) {
			countries.add(new Country(countrynames[i]));
		}
	}

	public int getCount() {
		return countries.size();
	}

	public Object getItem(int position) {
		return countries.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView= inflater.inflate(R.layout.country_list_item, parent, false);
		}
		
		Country country = countries.get(position);
		
		TextView countryName = (TextView) convertView.findViewById(R.id.tv_country_name);
		
		String countryText = country.getName();
		
		if (countryText != "China") {
			ImageView image = (ImageView) convertView.findViewById(R.id.image_lock);
		    image.setImageResource(R.drawable.lock);
		} else{
			ImageView image = (ImageView) convertView.findViewById(R.id.image_lock);
			image.setImageResource(R.drawable.lock_blank);
		}
		
		countryName.setText(country.getName());
	
		return convertView;
	}
	
	
	
}