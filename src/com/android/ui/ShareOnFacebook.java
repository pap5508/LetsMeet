package com.android.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.android.facebook.DialogError;
import com.android.facebook.Facebook;
import com.android.facebook.FacebookError;
import com.android.facebook.Facebook.DialogListener;

public class ShareOnFacebook extends Activity
{ 
	//private static final String APP_ID = "201493903215543";
	//private static final String APP_ID = "175729095772478"; Sample Android App
	 
	private static final String APP_ID = "219384708076308";
	//209062665770465
	
	     
	private static final String[] PERMISSIONS = new String[] {"publish_stream"};   

	private static final String TOKEN = "access_token";
	private static final String EXPIRES = "expires_in";
	private static final String KEY = "facebook-credentials";

	private Facebook facebook;  
	private String messageToPost;
	public static final String KEY_MESSAGE = "message_key";

	public boolean saveCredentials(Facebook facebook)
	{
		Editor editor = getApplicationContext().getSharedPreferences(KEY, Context.MODE_PRIVATE).edit(); 
		editor.putString(TOKEN, facebook.getAccessToken());
		editor.putLong(EXPIRES, facebook.getAccessExpires());
		return editor.commit();
	}

	public boolean restoreCredentials(Facebook facebook)
	{
		SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(KEY, Context.MODE_PRIVATE);
		facebook.setAccessToken(sharedPreferences.getString(TOKEN, null));
		facebook.setAccessExpires(sharedPreferences.getLong(EXPIRES, 0));
		return facebook.isSessionValid(); 
	}

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		facebook = new Facebook(APP_ID);
		restoreCredentials(facebook);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		setContentView(R.layout.facebook_dialog);
		messageToPost = getIntent().getExtras().getString(KEY_MESSAGE);
		share();
	}

	public void doNotShare(View button)
	{
		finish();
	}

	public void share(View button)
	{
		if(!facebook.isSessionValid())
		{
			loginAndPostToWall();
		}
		else
		{
			postToWall(messageToPost);
		}
	}
	public void share()
	{
		if(!facebook.isSessionValid())
		{
			loginAndPostToWall();
		}
		else
		{
			postToWall(messageToPost);
		}
	}

	public void loginAndPostToWall()
	{
		facebook.authorize(this, PERMISSIONS, new LoginDialogListener());
	}

	public void postToWall(String message)
	{
		Bundle parameters = new Bundle();
		//message=message+Html.fromHtml("<a href=\"http://www.google.com/\">"+"Visit google"+"</a>").toString();

	     parameters.putString("message", message + " ");
//		parameters.putString("link", "test"+ "\""+"http://www.google.com"+"\"");
//		 parameters.putString("attachment", "{\"name\":\"My Test Image\","
//		+"\"href\":\""+"http://www.google.com"+"\","
//		+"\"media\":[{\"type\":\"image\",\"src\":\""+"http://www.google.com/logos/mucha10-hp.jpg"+"\",\"href\":\""+"http://www.google.com"+"\"}]"
//		+"}");
		//facebook.dialog(this, "stream.publish", parameters, this);
	//	Log.e("MSSS", message);
		facebook.dialog(this, "stream.publish", parameters, new WallPostDialogListener());
	}

	class LoginDialogListener implements DialogListener
	{
		public void onComplete(Bundle values)
		{
			saveCredentials(facebook);
			if(messageToPost != null)
			{

				postToWall(messageToPost);
			}
		}

		public void onFacebookError(FacebookError error)
		{
			showToast("Authentication with Facebook failed!");
			finish();
		}

		public void onError(DialogError error)
		{
			showToast("Authentication with Facebook failed!");
			finish();
		}

		public void onCancel()
		{
			showToast("Authentication with Facebook cancelled!");
			finish();
		}
	}

	class WallPostDialogListener implements DialogListener
	{
		public void onComplete(Bundle values)
		{
			final String postId = values.getString("post_id");
			if(postId != null)
			{
				showToast("Message posted to your facebook wall!");
			}
			else
			{
				showToast("Wall post cancelled!");
			}
			finish();
		}

		public void onFacebookError(FacebookError e)
		{
			showToast("Failed to post to wall!");
			e.printStackTrace();
			finish();
		}

		public void onError(DialogError e)
		{
			showToast("Failed to post to wall!");
			e.printStackTrace();
			finish();
		}

		public void onCancel()
		{
			showToast("Wall post cancelled!");
			finish();
		}
	}

	private void showToast(String message)
	{
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
	}
}