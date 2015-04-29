package com.android.adapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ui.ListIndexGetSet;
import com.android.ui.R;

public class ListIndexParsedArrayAdapter extends BaseAdapter 
{
	private LayoutInflater mInflater = null;
	ArrayList<ListIndexGetSet> jsonData = new ArrayList<ListIndexGetSet>();
	
	public ListIndexParsedArrayAdapter(Context context, ArrayList<ListIndexGetSet> jsonData) 
	{
		this.jsonData = jsonData;
		mInflater = LayoutInflater.from(context);	
	}	
	public int getCount() {
		// TODO Auto-generated method stub
		return jsonData.size();
	}
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent)
	{
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) 
		{
			convertView = mInflater.inflate(R.layout.listindextv, parent, false);
			holder = new ViewHolder(); 
			holder.txt_name = (TextView) convertView.findViewById(R.id.tvName); 
			holder.txt_location = (TextView)convertView.findViewById(R.id.tvLocation);
			holder.txt_radd1 = (TextView)convertView.findViewById(R.id.tvAdd1);
			holder.txt_reviewcount = (TextView)convertView.findViewById(R.id.tvReviewCount);
			holder.txt_zip = (TextView)convertView.findViewById(R.id.tvZip);
			holder.txt_phone = (TextView)convertView.findViewById(R.id.tvPhone);
			holder.txt_state = (TextView)convertView.findViewById(R.id.tvState);
			holder.img_rating = (ImageView)convertView.findViewById(R.id.imgRating); 
			holder.img_index = (ImageView)convertView.findViewById(R.id.imgIndex);
			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		} 
		if(jsonData.size() > 0)
		{
			holder.txt_name.setText(this.jsonData.get(position).getName().toString().trim()); 
			holder.txt_location.setText(this.jsonData.get(position).getLocation().toString().trim());
			holder.txt_radd1.setText(this.jsonData.get(position).getAddress1().toString().trim());
			
			
			String strreview = this.jsonData.get(position).getReview_count().toString().trim();
			StringBuffer strBuffer = new StringBuffer();
			strBuffer.append(strreview + " Review");
			holder.txt_reviewcount.setText(strBuffer.toString());
			
			holder.txt_zip.setText(this.jsonData.get(position).getZip().toString().trim());
			holder.txt_phone.setText(this.jsonData.get(position).getPhone().toString().trim());
			holder.txt_state.setText(this.jsonData.get(position).getState().toString().trim());
			
			
			//Uri uri = Uri.parse(this.jsonData.get(position).getRating_url_small().toString().trim());
			//holder.img_index.setImageResource(R.drawable.panpacific);
			
			String image_URL = this.jsonData.get(position).getImgIndex().toString().trim();
			    BitmapFactory.Options bmOptions;
			    bmOptions = new BitmapFactory.Options();
			    bmOptions.inSampleSize = 1;
			    Bitmap bm = LoadImage(image_URL, bmOptions);
			    holder.img_index.setImageBitmap(bm);
			   
			String image_Rating = this.jsonData.get(position).getRating_url_small().toString().trim();
			    bmOptions = new BitmapFactory.Options();
			    bmOptions.inSampleSize = 1;
			    Bitmap bmrating = LoadImage(image_Rating, bmOptions);
			    holder.img_rating.setImageBitmap(bmrating);
			 

		} 
		else
		{
			holder.txt_name.setText("Nothing Selected"); 
		}
		return convertView; 
	}
	
	class ViewHolder 
	{
		TextView txt_name;
		TextView txt_location;
		TextView txt_radd1;
		TextView txt_reviewcount;
		TextView txt_zip;
		TextView txt_phone;
		TextView txt_state;
		ImageView img_index;
		ImageView img_rating;
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
	

}
