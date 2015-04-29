package com.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactUs extends Activity
{
	Button btnEmailUs;
	Button btnBack;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contactus);
		
		btnEmailUs = (Button)findViewById(R.id.btnEmailUs);
		btnBack = (Button)findViewById(R.id.btnBack);
		
		btnEmailUs.setOnClickListener(new View.OnClickListener() { 
			public void onClick(View v) {
				Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
				emailIntent.setType("plain/text");
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
						new String[] { "kashyap@dasinfomedia.com" });
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "");     
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");
				startActivity(Intent.createChooser(emailIntent, "Send mail..."));
			}
		});
		
		btnBack.setOnClickListener(new View.OnClickListener() { 
			public void onClick(View v) {
				ContactUs.this.startActivity(new Intent(ContactUs.this,LetsMeet.class));	
			}
		});
		
	}

}
