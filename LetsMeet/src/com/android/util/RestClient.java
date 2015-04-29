package com.android.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.util.Log;

public class RestClient 
{
	private static String result = "";
    /** 
     * Parses the JSON file from the remote location and 
     * returns result in the String format 
    */
	
	public static String parseJSON(String url)
	{
		HttpGet request = null;
		// Prepares a request object
		try 
		{
			request = new HttpGet(url);
			Log.i("RestClient", "Url: " + url);
		}
		catch (IllegalArgumentException e1) 
		{
			e1.printStackTrace();
		}

		// Response handler
		ResponseHandler<String> responseHandler = new BasicResponseHandler();

		HttpParams httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters, Constant.CONNECTION_TIMEOUT);
		HttpConnectionParams.setSoTimeout(httpParameters, Constant.SOCKET_TIMEOUT);
		HttpClient httpClient = new DefaultHttpClient(httpParameters);
		
		// Executes the request and return resulted string
		try
		{
			result = httpClient.execute(request, responseHandler);			
			if(result.equalsIgnoreCase(Constant.NO_PERFORMANCES_DATA_FOUND))
			{
				result = "[]";
			}
			return result;
		}
		catch (ClientProtocolException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
