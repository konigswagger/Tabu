package edu.berkeley.bid.cs160.opus;

import android.graphics.drawable.Drawable;

public class User {
	private String name;
	private int drawable;
	
	public User(String name, int drawable) {
		this.name = name;
		this.drawable = drawable;
	}
	
	public String getName() {
		return name;
	}
	
	public int getDrawable() {
		return drawable;
	}

}
