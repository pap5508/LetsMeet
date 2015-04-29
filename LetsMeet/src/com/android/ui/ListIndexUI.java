package com.android.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.R;
import com.android.adapter.ListIndexParsedArrayAdapter;

public class ListIndexUI extends Activity implements OnClickListener
{
	private static final String DATA = null;
	private JSONObject jObject;
	
	ListView listData;
	ImageView ivRestUI;
	ImageView ivShoppingUI;
	ImageView ivSearchUI;
	ImageView ivNightLifeUI;
	ImageView ivHealthUI;
	ImageView ivAutoMotiveUI;
	ImageView ivEducationUI;
	TextView tvTitleUI;
	TextView tvLocationUI;
	Button btnBack;
	
	public static String prmName;
	public static String prmPhotoUrl;
	public static String prmReviewCount;
	public static String prmRatingImg;
	public static String prmAddress1;
	public static String prmZip;
	public static String prmCity;
	public static String prmPhone;
	public static String prminfomobileurl;
	public static String prmrating_img_url_small;
	public static String prmusername1,prmusername2,prmusername3;
	public static String prm_review_rating1,prm_review_rating2,prm_review_rating3;
	public static String prm_text1,prm_text2,prm_text3;
	public static String prm_rreview_rating_img_url_small1,prm_rreview_rating_img_url_small2,prm_rreview_rating_img_url_small3;
	public static String prm_review_userphoto1,prm_review_userphoto2,prm_review_userphoto3;
	public static String prm_review_useurl1,prm_review_useurl2,prm_review_useurl3;
	
	
	private LinearLayout layoutLoading = null;
	private ProgressBar progressBarLoading = null;
	private TextView txtLoading = null; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.listindexui);
	        
	        ivRestUI = (ImageView)findViewById(R.id.ivRestaurant);
			ivShoppingUI = (ImageView)findViewById(R.id.ivShopping);
			ivSearchUI = (ImageView)findViewById(R.id.ivSearch);
			tvTitleUI = (TextView)findViewById(R.id.tvTitle);
			ivNightLifeUI = (ImageView)findViewById(R.id.ivNightLife);
			ivHealthUI = (ImageView)findViewById(R.id.ivHealth);
			ivAutoMotiveUI = (ImageView)findViewById(R.id.ivAutoMotive);
			ivEducationUI = (ImageView)findViewById(R.id.ivEducation);
			tvLocationUI = (TextView)findViewById(R.id.tvLocation);
			
			ivRestUI.setOnClickListener(this);
			ivShoppingUI.setOnClickListener(this);
			ivSearchUI.setOnClickListener(this);
			ivNightLifeUI.setOnClickListener(this);
			ivHealthUI.setOnClickListener(this);
	        ivAutoMotiveUI.setOnClickListener(this);
	        ivEducationUI.setOnClickListener(this);
			
	        btnBack = (Button)findViewById(R.id.btnBack);
	        
	        btnBack.setOnClickListener(new OnClickListener()
			{
				
				@Override
				public void onClick(View v) {
					Intent mIntent = new Intent(ListIndexUI.this, Search.class);
					startActivity(mIntent);  
					//GetViewBack.letzMeet.back(); 
				} 
			});
	        try  
	        {
				layoutLoading = (LinearLayout)findViewById(R.id.layoutLoading);
				progressBarLoading = (ProgressBar)findViewById(R.id.progressBarLoading);
				txtLoading = (TextView)findViewById(R.id.txtLoading);
			}
	        catch (Exception e1)  
	        {
				e1.printStackTrace();
	        }
			
	        callMe();
	        
	        

	    }
	    
		public void callMe() 
		{
			tvTitleUI.setText(Search.TERM.toUpperCase());
			
			StringBuffer strBuffer = new StringBuffer();
			strBuffer.append("http://api.yelp.com/business_review_search?location=" + Search.LOCATION + "&term=" + Search.TERM + "&ywsid=TEn3zTRSJtlSUaNUkeFPzg");
			System.out.println(strBuffer.toString());
	        
	        final ArrayList<ListIndexGetSet> listResponse = (connect(strBuffer.toString()));
	        
	        try {
				listData = (ListView) findViewById(R.id.lstListIndexView);

				listData.setAdapter(new ListIndexParsedArrayAdapter(ListIndexUI.this, listResponse)); 
				
				System.out.println("Web Services Call her");
				listData.setOnItemClickListener(new OnItemClickListener()
				{
					public void onItemClick(AdapterView<?> parent, View view, int position, long id)  
					{
				
						prmName = listResponse.get(position).name;
						prmPhotoUrl = listResponse.get(position).imgIndex;
						prmReviewCount = listResponse.get(position).review_count;
						prmRatingImg = listResponse.get(position).rating_url_small;
						prmAddress1 = listResponse.get(position).address1;
						prmZip = listResponse.get(position).zip;
						prmCity = listResponse.get(position).city;
						prmPhone = listResponse.get(position).phone;
						prminfomobileurl = listResponse.get(position).infomobileurl;
						
						prmusername1 = listResponse.get(position).review_username1;
						prmusername2 = listResponse.get(position).review_username2;
						prmusername3 = listResponse.get(position).review_username3;
						
						prm_review_rating1 = listResponse.get(position).review_rating1;
						prm_review_rating2 = listResponse.get(position).review_rating2;
						prm_review_rating3 = listResponse.get(position).review_rating3;
						
						prm_text1 = listResponse.get(position).review_text1;
						prm_text2 = listResponse.get(position).review_text2;
						prm_text3 = listResponse.get(position).review_text3;
						
						prm_rreview_rating_img_url_small1 = listResponse.get(position).review_rating_img_url_small1;
						prm_rreview_rating_img_url_small2 = listResponse.get(position).review_rating_img_url_small2;
						prm_rreview_rating_img_url_small3 = listResponse.get(position).review_rating_img_url_small3;
						
						
						prm_review_userphoto1 = listResponse.get(position).review_photo1;
						prm_review_userphoto2 = listResponse.get(position).review_photo2;
						prm_review_userphoto3 = listResponse.get(position).review_photo3;
						
						
						prm_review_useurl1 = listResponse.get(position).review_info_Review_user1;
						prm_review_useurl2 = listResponse.get(position).review_info_Review_user2;
						prm_review_useurl3 = listResponse.get(position).review_info_Review_user3;
						
						//prmrating_img_url_small = listResponse.get(position).review_rating_img_url_small1;
						//System.out.println("prmname= "+ListIndexUI.prmName);
						
						ListIndexUI.this.startActivity(new Intent(ListIndexUI.this,ListInfoUI.class));
					} 
				});
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
	
	    private ArrayList<ListIndexGetSet> connect(String url)
	    {
	    	ArrayList<ListIndexGetSet> getData = new ArrayList<ListIndexGetSet>();
	    	// Create the httpclient 
			HttpClient httpclient = new DefaultHttpClient();
			
			//Prepare a request Object
			HttpGet httpget = new HttpGet(url);
			
			//Response Declaration
			HttpResponse response;   
			
			//Return String Declaration 
			String result = null;
			
			try
			{ 
			
			 	response = httpclient.execute(httpget);   
			 	if(response.getStatusLine().getStatusCode() == 200)
	            {
			 		System.out.println("Connection successful");
	            
	             	HttpEntity entity = response.getEntity(); 
	            
	            	if(entity != null)
	            	{
	            		
	            		InputStream instream = entity.getContent();
	  
	                     
	            		jObject = new JSONObject(convertStreamToString(instream));
	            		Log.e("Resutl",""+jObject);
	            		System.out.println("Response :-- "+jObject);
	            		
	            		String strMessage = jObject.getString("message");
	            		System.out.println("JsonObject_message-->"+strMessage);
	            		JSONObject jobjMessage = new JSONObject(strMessage);
	            		
	            		String strBusinesses = jObject.getString("businesses");
	            		JSONArray jaryBusiness = new JSONArray(strBusinesses);;
	            		
	       
	            		for(int i=0;i<jaryBusiness.length();i++)
	            		{
	            			ListIndexGetSet listindexgetset = new ListIndexGetSet();
	            			listindexgetset.setName(jaryBusiness.getJSONObject(i).getString("name"));
	            			listindexgetset.setAddress1(jaryBusiness.getJSONObject(i).getString("address1"));
	            			listindexgetset.setReview_count(jaryBusiness.getJSONObject(i).getString("review_count"));
	            			listindexgetset.setZip(jaryBusiness.getJSONObject(i).getString("zip"));
	            			listindexgetset.setPhone(jaryBusiness.getJSONObject(i).getString("phone"));
	            			listindexgetset.setState(jaryBusiness.getJSONObject(i).getString("state"));
	            			
	            			listindexgetset.setImgIndex(jaryBusiness.getJSONObject(i).getString("photo_url"));
	            			listindexgetset.setRating_url_small(jaryBusiness.getJSONObject(i).getString("rating_img_url_small"));
	                		listindexgetset.setCity(jaryBusiness.getJSONObject(i).getString("city"));
	            			listindexgetset.setInfomobileurl(jaryBusiness.getJSONObject(i).getString("mobile_url"));
	            			
	            			String strNeighborhoods = jaryBusiness.getJSONObject(i).getString("neighborhoods"); 
	                    	System.out.println("strNeighborhoods:----->" + strNeighborhoods); 
	                    	JSONArray jaryNeighborhoods = new JSONArray(strNeighborhoods);;
	                    	
	                    	for(int j=0;j<jaryNeighborhoods.length();j++)
	                    	{
	                    		listindexgetset.setLocation(jaryNeighborhoods.getJSONObject(j).getString("name"));
	                    		System.out.println("name value is "+jaryNeighborhoods.getJSONObject(j).getString("name"));
	                    	}	
	                    	
	                    	String strReviews = jaryBusiness.getJSONObject(i).getString("reviews"); 
	                    	System.out.println("strReviews:----->" + strReviews); 
	                    	JSONArray jaryReviews = new JSONArray(strReviews);;
	                    	
	                    	for(int k=0;k<jaryReviews.length();k++)
	                    	{
	                    		listindexgetset.setReview_username1(jaryReviews.getJSONObject(0).getString("user_name"));
	                    		listindexgetset.setReview_username2(jaryReviews.getJSONObject(1).getString("user_name"));
	                    		listindexgetset.setReview_username3(jaryReviews.getJSONObject(2).getString("user_name"));
	                    	
	                    		listindexgetset.setReview_rating1(jaryReviews.getJSONObject(0).getString("rating"));
	                    		listindexgetset.setReview_rating2(jaryReviews.getJSONObject(1).getString("rating"));
	                    		listindexgetset.setReview_rating3(jaryReviews.getJSONObject(2).getString("rating"));
	                    	
	                    		listindexgetset.setReview_text1(jaryReviews.getJSONObject(0).getString("text_excerpt"));
	                    		listindexgetset.setReview_text2(jaryReviews.getJSONObject(1).getString("text_excerpt"));
	                    		listindexgetset.setReview_text3(jaryReviews.getJSONObject(2).getString("text_excerpt"));
	                    	
	                    		listindexgetset.setReview_rating_img_url_small1(jaryReviews.getJSONObject(0).getString("rating_img_url_small"));
	                    		listindexgetset.setReview_rating_img_url_small2(jaryReviews.getJSONObject(1).getString("rating_img_url_small"));
	                    		listindexgetset.setReview_rating_img_url_small3(jaryReviews.getJSONObject(2).getString("rating_img_url_small"));
	                    		
	                    		listindexgetset.setReview_photo1(jaryReviews.getJSONObject(0).getString("user_photo_url"));
	                    		listindexgetset.setReview_photo2(jaryReviews.getJSONObject(1).getString("user_photo_url"));
	                    		listindexgetset.setReview_photo3(jaryReviews.getJSONObject(2).getString("user_photo_url"));
	                    	
	                    		listindexgetset.setReview_info_Review_user1(jaryReviews.getJSONObject(0).getString("user_url"));
	                    		listindexgetset.setReview_info_Review_user2(jaryReviews.getJSONObject(1).getString("user_url"));
	                    		listindexgetset.setReview_info_Review_user3(jaryReviews.getJSONObject(2).getString("user_url"));
	                    		
	                    		
	                    	}	
	                    	
	             			getData.add(listindexgetset);
	                		System.out.println("data call here");
	            		}
	            		
	            		//result = "BillBoards Found:-" + jArray.length();
	            		
	            		// my comment
//	            		for(int i=0; i<jArray.length(); i++)   
//	            		{
//	            			ListIndexGetSet listindexgetset = new ListIndexGetSet();
//	            			listindexgetset.setNid(jArray.getJSONObject(i).getString("nid"));
//	                		getData.add(listindexgetset);
//	                		System.out.println("data call here");
//	            		}
	            		// my comment complate
	            		instream.getClass();
	            	}
	            	else
	            	{
	            		result = "Unable to load page - " + response.getStatusLine();
	            	}
	            }
			}
			 catch (IOException ex)
		        {
		        	// thrown by line 80 - getContent();
		        	// Connection was not established
		        	//returnString = "Connection failed; " + ex.getMessage();
		        }
			  catch (JSONException ex)
		        {    
		        	// JSON errors
		        	//returnString = "JSON failed; " + ex.getMessage();
		        	
		        }
	    	return getData;
	    }
	    
	    private static String convertStreamToString(InputStream is)
		{
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	        StringBuilder sb = new StringBuilder();

	        String line = null;
	        try 
	        {
	            while ((line = reader.readLine()) != null)
	            {
	                sb.append(line + "\n");
	            }
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        } 
	        finally 
	        {
	            try 
	            {
	                is.close();
	            } 
	            catch (IOException e)
	            {
	                e.printStackTrace();
	            }
	        }
	        return sb.toString();
	    }
	    @Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
				
			switch(v.getId())
			{
			
			case R.id.ivRestaurant:
				
				Search.TERM = "restaurant";
				callMe();
				break;
			
			case R.id.ivShopping:
			
				Search.TERM = "shopping";
				callMe();
				break;
				
			case R.id.ivNightLife:
				
				Search.TERM = "nightlife";
				callMe();
				break;
			
			case R.id.ivHealth:
				Search.TERM = "health";
				callMe();
				break;
				
			case R.id.ivAutoMotive:
				Search.TERM = "auto";
				callMe();
				break;
			
			case R.id.ivEducation:
				Search.TERM = "education";
				callMe();
				break;
				
			case R.id.ivSearch:
				
				ListIndexUI.this.startActivity(new Intent(ListIndexUI.this,Search.class));
			}
			System.out.println("LOCATION " + Search.LOCATION);
			System.out.println("TERM " + Search.TERM);
			
			
			
//			StringBuffer strBuffer = new StringBuffer();
//			strBuffer.append("http://api.yelp.com/business_review_search?location=" + Search.LOCATION + "&term=" + Search.TERM + "&ywsid=TEn3zTRSJtlSUaNUkeFPzg");
//			System.out.println("connect string is " +strBuffer.toString());
				
//			Search.this.startActivity(new Intent(Search.this,ListIndexUI.class));
			
		}
}