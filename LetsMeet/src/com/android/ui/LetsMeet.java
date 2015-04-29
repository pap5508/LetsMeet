package com.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LetsMeet extends Activity {
    
	Button btnStartApp;
	Button btnContactUs;
	Button btnFAQs;
	Button btnSlideBlog,btnSlideContactUs,btnSlideFAQs,btnSlideStart;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        btnStartApp = (Button)findViewById(R.id.btnStart);
        btnStartApp.setOnClickListener(new ButtonClickStart());
        
               
        btnContactUs = (Button)findViewById(R.id.btnContactUs);
        btnContactUs.setOnClickListener(new ButtonClickContactUs());
        
               
        btnFAQs = (Button)findViewById(R.id.btnFaqs);
        btnFAQs.setOnClickListener(new ButtonClickFAQs());
 
        btnSlideBlog = (Button)findViewById(R.id.btnBlog);
        btnSlideBlog.setOnClickListener(new ButtonClickBlog());
        
        btnSlideContactUs = (Button)findViewById(R.id.btnContact);
        btnSlideContactUs.setOnClickListener(new ButtonClickSlideContact());
        
        btnSlideFAQs = (Button)findViewById(R.id.btnSlideFAQs);
        btnSlideFAQs.setOnClickListener(new ButtonClickSlideFAQs());
        
        btnSlideStart = (Button)findViewById(R.id.btnLetsStart);
        btnSlideStart.setOnClickListener(new ButtonClickLetsStart());
        
    }
    class ButtonClickStart implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			LetsMeet.this.startActivity(new Intent(LetsMeet.this,Search.class));	
		}
    }
    
    class ButtonClickLetsStart implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			LetsMeet.this.startActivity(new Intent(LetsMeet.this,Search.class));	
		}
    }
    
    class ButtonClickContactUs implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			LetsMeet.this.startActivity(new Intent(LetsMeet.this,ContactUs.class));	
		}
    }
    
    class ButtonClickSlideContact implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			LetsMeet.this.startActivity(new Intent(LetsMeet.this,ContactUs.class));	
		}
    }
    
    class ButtonClickFAQs implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			LetsMeet.this.startActivity(new Intent(LetsMeet.this,FAQs.class));	
		}
    }
    
    class ButtonClickSlideFAQs implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			LetsMeet.this.startActivity(new Intent(LetsMeet.this,FAQs.class));	
		}
    }
    
    class ButtonClickBlog implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			Uri uri = Uri.parse("http://letsmeets.blogspot.com/");
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(intent);	
		}
    }
}