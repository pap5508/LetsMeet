package com.android.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GetViewBack extends MyActivityGroup 
{
	private ArrayList<View> history;
	public static GetViewBack letzMeet; 

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.history = new ArrayList<View>();
		//letzMeet.this; 
		
		View view = null;
		try {
			view = getLocalActivityManager()
			.startActivity("Search", new Intent(this, Search.class) 
			.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
			.getDecorView();
		} catch (Exception e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		
		replaceView(view);      
	}  
		 
	
	protected void replaceView(View v)
	{
		
		// Adds the old one to history
		((ArrayList<View>) history).add(v);  

		v.setFocusable(true);
		v.setFocusableInTouchMode(true);
		v.requestFocus();
		// Changes this Groups View to the new View.
		setContentView(v);
	}

	protected void back() 
	{
		if ( history.size() > 1 ) 
		{
			history.remove(history.size() - 1);
			View v = history.get(history.size() - 1);
			v.setFocusable(true);
			v.setFocusableInTouchMode(true);
			v.requestFocus();
			setContentView(v);
		}
		else
		{
			this.finish();
		}
	}
}
	
