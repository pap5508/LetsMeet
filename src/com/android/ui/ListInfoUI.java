package com.android.ui;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListInfoUI  extends Activity implements OnClickListener
{
	
	ImageView ivRestUI,ivEducationUI,ivEventUI,ivReligiousUI,ivAutoMotiveUI;
	ImageView ivShoppingUI,ivHomeUI,ivSearchUI,ivNightLifeUI,ivHotelnTravelUI,ivHealthUI;
	
	
	TextView tvNameUI;
	ImageView imgPhoto;
	TextView tvReviewCountUI;
	ImageView imgRatingUI;
	TextView tvAddress1UI;
	TextView tvZipUI;
	TextView tvCityUI;
	TextView tvPhoneUI;
	TextView tvUserUrlUI;
	private Button faceBook;
	
	TextView tvusername1UI,tvusername2UI,tvusername3UI;
	TextView tvReviewRating1,tvReviewRating2,tvReviewRating3;
	TextView tvReviewText1,tvReviewText2,tvReviewText3;
	ImageView review_img_rating1,review_img_rating2,review_img_rating3;
	
	Button btnInfoMUrl,btnBack;
	Button btnReviewMWeb1,btnReviewMWeb2,btnReviewMWeb3;
	
	ImageView imgReviewPhoto1,imgReviewPhoto2,imgReviewPhoto3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listinfoui);
		
		
		 ivRestUI = (ImageView)findViewById(R.id.ivRestaurant);
		 ivShoppingUI = (ImageView)findViewById(R.id.ivShopping);
		 ivHomeUI = (ImageView)findViewById(R.id.ivHome);
		 ivSearchUI = (ImageView)findViewById(R.id.ivSearch);
		 ivNightLifeUI = (ImageView)findViewById(R.id.ivNightLife);
		 ivHotelnTravelUI = (ImageView)findViewById(R.id.ivHotelnTravel);
		 ivHealthUI = (ImageView)findViewById(R.id.ivHealth);
		 ivEducationUI = (ImageView)findViewById(R.id.ivEducation);
		 ivEventUI = (ImageView)findViewById(R.id.ivEvent);
		 ivReligiousUI = (ImageView)findViewById(R.id.ivReligious);
		 ivAutoMotiveUI = (ImageView)findViewById(R.id.ivAutoMotive);
		 
		 ivRestUI.setOnClickListener(this);
		 ivShoppingUI.setOnClickListener(this);
		 ivNightLifeUI.setOnClickListener(this);
		 ivHotelnTravelUI.setOnClickListener(this);
		 ivHealthUI.setOnClickListener(this);
		 ivEducationUI.setOnClickListener(this);
		 ivEventUI.setOnClickListener(this);
		 ivReligiousUI.setOnClickListener(this);
		 ivAutoMotiveUI.setOnClickListener(this);
		 
		 ivHomeUI.setOnClickListener(new View.OnClickListener()
			{
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					ListInfoUI.this.startActivity(new Intent(ListInfoUI.this,LetsMeet.class));
				}
			});
	        ivSearchUI.setOnClickListener(new View.OnClickListener()
			{
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					ListInfoUI.this.startActivity(new Intent(ListInfoUI.this,Search.class));
				}
			});
	        
	        
		faceBook = (Button) findViewById(R.id.btnFacebook);
		
		tvNameUI = (TextView)findViewById(R.id.tvName);
		imgPhoto = (ImageView)findViewById(R.id.imgIndex);
		tvReviewCountUI = (TextView)findViewById(R.id.tvReviewCount);
		imgRatingUI = (ImageView)findViewById(R.id.imgRatingMain);
		tvAddress1UI = (TextView)findViewById(R.id.tvAddress1);
		tvZipUI = (TextView)findViewById(R.id.tvZip);
		tvCityUI = (TextView)findViewById(R.id.tvCity);
		tvPhoneUI = (TextView)findViewById(R.id.tvPhone);
		btnInfoMUrl = (Button)findViewById(R.id.btnMobileWeb);
		
		btnReviewMWeb1 = (Button)findViewById(R.id.btnReviewMobileWeb1);
		btnReviewMWeb2 = (Button)findViewById(R.id.btnReviewMobileWeb2);
		btnReviewMWeb3 = (Button)findViewById(R.id.btnReviewMobileWeb3);
		
		
	
		tvusername1UI = (TextView)findViewById(R.id.tvUserName1);
		tvusername2UI = (TextView)findViewById(R.id.tvUserName2);
		tvusername3UI = (TextView)findViewById(R.id.tvUserName3);
		
		tvReviewRating1 = (TextView)findViewById(R.id.tvRating1);
		tvReviewRating2 = (TextView)findViewById(R.id.tvRating2);
		tvReviewRating3 = (TextView)findViewById(R.id.tvRating3);
		
		tvReviewText1 = (TextView)findViewById(R.id.tvText1);
		tvReviewText2 = (TextView)findViewById(R.id.tvText2);
		tvReviewText3 = (TextView)findViewById(R.id.tvText3);
		
		review_img_rating1 = (ImageView)findViewById(R.id.imgRating1);
		review_img_rating2 = (ImageView)findViewById(R.id.imgRating2);
		review_img_rating3 = (ImageView)findViewById(R.id.imgRating3);
		
		imgReviewPhoto1 = (ImageView)findViewById(R.id.imgReview1);
		imgReviewPhoto2 = (ImageView)findViewById(R.id.imgReview2);
		imgReviewPhoto3 = (ImageView)findViewById(R.id.imgReview3);
		
		
		//System.out.println("prmname in ListInfoUI= "+ListIndexUI.prmName);
		
		
		tvNameUI.setText(ListIndexUI.prmName.toUpperCase());
		
	    BitmapFactory.Options bmOptions;
	    bmOptions = new BitmapFactory.Options();
	    bmOptions.inSampleSize = 1;
	    Bitmap bm = LoadImage(ListIndexUI.prmPhotoUrl, bmOptions);
	    imgPhoto.setImageBitmap(bm);
		
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(ListIndexUI.prmReviewCount + " Review");
	    tvReviewCountUI.setText(strBuffer.toString());
	    
	    bmOptions = new BitmapFactory.Options();
	    bmOptions.inSampleSize = 1;
	    Bitmap bmrating = LoadImage(ListIndexUI.prmRatingImg, bmOptions);
	    imgRatingUI.setImageBitmap(bmrating);
		
	    tvAddress1UI.setText(ListIndexUI.prmAddress1);
	    tvZipUI.setText(ListIndexUI.prmZip);
	    tvCityUI.setText(ListIndexUI.prmCity);
	    tvPhoneUI.setText(ListIndexUI.prmPhone);
	    
	  
	    tvusername1UI.setText(ListIndexUI.prmusername1);
	    tvusername2UI.setText(ListIndexUI.prmusername2);
	    tvusername3UI.setText(ListIndexUI.prmusername3);
	    
	    tvReviewRating1.setText(ListIndexUI.prm_review_rating1);
	    tvReviewRating2.setText(ListIndexUI.prm_review_rating2);
	    tvReviewRating3.setText(ListIndexUI.prm_review_rating3);
	    
	    tvReviewText1.setText(ListIndexUI.prm_text1);
	    tvReviewText2.setText(ListIndexUI.prm_text2);
	    tvReviewText3.setText(ListIndexUI.prm_text3);
	    
	    
	    bmOptions = new BitmapFactory.Options();
	    bmOptions.inSampleSize = 1;
	    Bitmap bmrating1 = LoadImage(ListIndexUI.prm_rreview_rating_img_url_small1, bmOptions);
	    review_img_rating1.setImageBitmap(bmrating1);
	    
	    
	    bmOptions = new BitmapFactory.Options();
	    bmOptions.inSampleSize = 1;
	    Bitmap bmrating2 = LoadImage(ListIndexUI.prm_rreview_rating_img_url_small2, bmOptions);
	    review_img_rating2.setImageBitmap(bmrating2);
	    
	    bmOptions = new BitmapFactory.Options();
	    bmOptions.inSampleSize = 1;
	    Bitmap bmrating3 = LoadImage(ListIndexUI.prm_rreview_rating_img_url_small3, bmOptions);
	    review_img_rating3.setImageBitmap(bmrating3);
	    
	    bmOptions = new BitmapFactory.Options();
	    bmOptions.inSampleSize = 1;
	    Bitmap bmreviewphoto1 = LoadImage(ListIndexUI.prm_review_userphoto1, bmOptions);
	    imgReviewPhoto1.setImageBitmap(bmreviewphoto1);
	    
	    bmOptions = new BitmapFactory.Options();
	    bmOptions.inSampleSize = 1;
	    Bitmap bmreviewphoto2 = LoadImage(ListIndexUI.prm_review_userphoto2, bmOptions);
	    imgReviewPhoto2.setImageBitmap(bmreviewphoto2);
	    
	    bmOptions = new BitmapFactory.Options();
	    bmOptions.inSampleSize = 1;
	    Bitmap bmreviewphoto3 = LoadImage(ListIndexUI.prm_review_userphoto3, bmOptions);
	    imgReviewPhoto3.setImageBitmap(bmreviewphoto3);
	    
	    
	    
	    
	    
	    btnBack = (Button)findViewById(R.id.btnBack);
        
        btnBack.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				ListInfoUI.this.startActivity(new Intent(ListInfoUI.this,ListIndexUI.class));
			}
		});
	    
	    btnInfoMUrl.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse(ListIndexUI.prminfomobileurl);
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);		
			}
		});
	    
	    faceBook.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v) 
			{
				Intent intent = new Intent(ListInfoUI.this,ShareOnFacebook.class);
				intent.putExtra(ShareOnFacebook.KEY_MESSAGE, ListIndexUI.prmName + "\n\n" + ListIndexUI.prmAddress1 + ", " + ListIndexUI.prmZip + "\n\n" + ListIndexUI.prmPhone + "\n\n" +  ListIndexUI.prminfomobileurl);
				startActivity(intent);
			}
		});
	    
	    btnReviewMWeb1.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse(ListIndexUI.prm_review_useurl1);
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);		
			}
		});
	    
	    btnReviewMWeb2.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse(ListIndexUI.prm_review_useurl2);
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);		
			}
		});
	    
	    btnReviewMWeb3.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse(ListIndexUI.prm_review_useurl3);
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);		
			}
		});
	    
	    
	}
	private Bitmap LoadImage(String URL, BitmapFactory.Options options)
	   {       
	    Bitmap bitmap = null;
	    InputStream in = null;       
	       try {
	           in = OpenHttpConnection(URL);
	           bitmap = BitmapFactory.decodeStream(in, null, options);
	           in.close();
	       } catch (IOException e1) {
	       }
	       return bitmap;               
	   }

	private InputStream OpenHttpConnection(String strURL) throws IOException{
	 InputStream inputStream = null;
	 URL url = new URL(strURL);
	 URLConnection conn = url.openConnection();

	 try{
	  HttpURLConnection httpConn = (HttpURLConnection)conn;
	  httpConn.setRequestMethod("GET");
	  httpConn.connect();

	  if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
	   inputStream = httpConn.getInputStream();
	  }
	 }
	 catch (Exception ex)
	 {
	 }
	 return inputStream;
	}
	
	 @Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
			
		switch(v.getId())
		{
		
		case R.id.ivRestaurant:
			
			Search.TERM = "restaurant";
			break;
		
		case R.id.ivNightLife:
			
			Search.TERM = "nightlife";
			break;
		
		case R.id.ivShopping:
		
			Search.TERM = "shopping";
			break;
			
		case R.id.ivHotelnTravel:
			
			Search.TERM = "hotels";
			break;
			
		case R.id.ivHealth:
			
			Search.TERM = "health";
			break;
		
		case R.id.ivEducation:
		
			Search.TERM = "education";
			break;
			
		case R.id.ivEvent:
	
			Search.TERM = "events";
			break;
			
		case R.id.ivAutoMotive:
			
			Search.TERM = "auto";
			break;
			
		case R.id.ivReligious:
	
			Search.TERM = "religious";
			break;
	
		}
		System.out.println("LOCATION " + Search.LOCATION);
		System.out.println("TERM " + Search.TERM);

		ListInfoUI.this.startActivity(new Intent(ListInfoUI.this,ListIndexUI.class));
	}
}
