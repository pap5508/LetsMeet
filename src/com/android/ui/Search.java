package com.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Search extends Activity implements OnClickListener
{
	public static String LOCATION;
	public static String TERM;
	public static EditText etSearchUI; 
	Button btnSearchUI;
	ImageView ivHomeUI;
	ImageView ivRestUI;
	ImageView ivShoppingUI;
	ImageView ivNightLifeUI;
	ImageView ivHealthUI;
	ImageView ivAutoMotiveUI,ivReligiousUI;
	ImageView ivEducationUI,ivHotelnTravelUI,ivEventUI;
	public static String strURI;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		
		btnSearchUI = (Button)findViewById(R.id.btnSearch);
		etSearchUI = (EditText)findViewById(R.id.etCity);
		
		ivHomeUI = (ImageView)findViewById(R.id.ivHome);
		ivRestUI = (ImageView)findViewById(R.id.ivRestaurant);
		ivShoppingUI = (ImageView)findViewById(R.id.ivShopping);
		ivNightLifeUI = (ImageView)findViewById(R.id.ivNightLife);
		ivHealthUI = (ImageView)findViewById(R.id.ivHealth);
		ivAutoMotiveUI = (ImageView)findViewById(R.id.ivAutoMotive);
		ivEducationUI = (ImageView)findViewById(R.id.ivEducation);
		ivHotelnTravelUI = (ImageView)findViewById(R.id.ivHotelnTravel);
		ivEventUI = (ImageView)findViewById(R.id.ivEvent);
		ivReligiousUI = (ImageView)findViewById(R.id.ivReligious);
	
		btnSearchUI.setOnClickListener(this);
		
		
		ivRestUI.setOnClickListener(this);
		ivShoppingUI.setOnClickListener(this);
		ivNightLifeUI.setOnClickListener(this);
		ivHealthUI.setOnClickListener(this);
		ivAutoMotiveUI.setOnClickListener(this);
		ivEducationUI.setOnClickListener(this);
		ivHotelnTravelUI.setOnClickListener(this);
		ivEventUI.setOnClickListener(this);
		ivReligiousUI.setOnClickListener(this);
	
	
		
		ivHomeUI.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Search.this.startActivity(new Intent(Search.this,LetsMeet.class));
			}
		});
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		LOCATION = etSearchUI.getText().toString();
		LOCATION = LOCATION.replaceAll(" ","%20");
		TERM = "restaurant";
		System.out.println("LOCATION " + LOCATION);
		System.out.println("TERM " + TERM);
		
		/*if(LOCATION.length() == 0)
		{
			new AlertDialog.Builder(this).setMessage(R.string.error_LocationMissing).setNeutralButton(R.string.error_Ok,null).show();
		}*/
		
		
		
		switch(v.getId())
		{
		case R.id.btnSearch:
			if(LOCATION.length() == 0)
			{
				//new AlertDialog.Builder(this).setMessage(R.string.error_LocationMissing).setNeutralButton(R.string.error_Ok,null).show();
				LOCATION = "london";
				TERM = "restaurant";
			}
			else
			{
				LOCATION = etSearchUI.getText().toString();
				LOCATION = LOCATION.replaceAll(" ","%20");
				TERM = "restaurant";
			}
			break;
			
		case R.id.ivRestaurant:
			if(LOCATION.length() == 0)
			{
				//new AlertDialog.Builder(this).setMessage(R.string.error_LocationMissing).setNeutralButton(R.string.error_Ok,null).show();
				LOCATION = "london";
			}
			else
			{
				LOCATION = etSearchUI.getText().toString();
				LOCATION = LOCATION.replaceAll(" ","%20");
				
			}
			TERM = "restaurant";
			break;
		
		case R.id.ivShopping:
			if(LOCATION.length() == 0)
			{
				//new AlertDialog.Builder(this).setMessage(R.string.error_LocationMissing).setNeutralButton(R.string.error_Ok,null).show();
				LOCATION = "london";
			}
			else
			{
				LOCATION = etSearchUI.getText().toString();
				LOCATION = LOCATION.replaceAll(" ","%20");
			}
			TERM = "shopping";
			break;
			
		case R.id.ivNightLife:
			if(LOCATION.length()==0)
			{
				LOCATION = "london";
			}
			else
			{
				LOCATION = etSearchUI.getText().toString();
				LOCATION = LOCATION.replaceAll(" ","%20");
			}
			TERM = "nightlife";
			break;
		
		case R.id.ivHotelnTravel:
			if(LOCATION.length()==0)
			{
				LOCATION = "london";
			}
			else
			{
				LOCATION = etSearchUI.getText().toString();
				LOCATION = LOCATION.replaceAll(" ","%20");
			}
			TERM = "hotels";
			break;
			
		case R.id.ivHealth:
			if(LOCATION.length()==0)
			{
				LOCATION = "london";
			}
			else
			{
				LOCATION = etSearchUI.getText().toString();
				LOCATION = LOCATION.replaceAll(" ","%20");
			}
			TERM = "health";
			break;
		
		case R.id.ivAutoMotive:
			if(LOCATION.length()==0)
			{
				LOCATION = "london";
			}
			else
			{
				LOCATION = etSearchUI.getText().toString();
				LOCATION = LOCATION.replaceAll(" ","%20");
			}
			TERM = "auto";
			break;
			
		case R.id.ivEducation:
			if(LOCATION.length()==0)
			{
				LOCATION = "london"; 
			}
			else
			{
				LOCATION = etSearchUI.getText().toString();
				LOCATION = LOCATION.replaceAll(" ","%20");
			}
			TERM = "education";
			break;
		case R.id.ivEvent:
			if(LOCATION.length()==0)
			{
				LOCATION = "london"; 
			}
			else
			{
				LOCATION = etSearchUI.getText().toString();
				LOCATION = LOCATION.replaceAll(" ","%20");
			}
			TERM = "events";
			break;
		case R.id.ivReligious:
			if(LOCATION.length()==0)
			{
				LOCATION = "london"; 
			}
			else
			{
				LOCATION = etSearchUI.getText().toString();
				LOCATION = LOCATION.replaceAll(" ","%20");
			}
			TERM = "religious";
			break;
	
			
		}
		
		System.out.println("LOCATION " + LOCATION);
		System.out.println("TERM " + TERM);
		
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("http://api.yelp.com/business_review_search?location=" + Search.LOCATION + "&term=" + Search.TERM + "&ywsid=TEn3zTRSJtlSUaNUkeFPzg");
		System.out.println("connect string is " +strBuffer.toString());
		
		

		

	
		Search.this.startActivity(new Intent(Search.this,ListIndexUI.class));
	//	GetViewBack.letzMeet.replaceView(v); 
	}
}
