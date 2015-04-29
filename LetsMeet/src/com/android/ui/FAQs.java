package com.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FAQs extends Activity
{
	Button btnBack;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.faq);
		
		btnBack = (Button)findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new View.OnClickListener() { 
			public void onClick(View v) {
				FAQs.this.startActivity(new Intent(FAQs.this,LetsMeet.class));	
			}
		});
	}

}
