package com.android.util;

import android.app.Application;

public class Utils extends Application 
{
	public static String getURLForActsDetails(String actnid)
	{
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(Constant.URL.ACTS_URL);
		sBuffer.append(actnid);
		return sBuffer.toString();
	}
	
	public static String getURLForPerformancesDetails(String placenid)
	{
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(Constant.URL.PERFORMANCES_URL);
		strBuffer.append("?place_nid=" + placenid);
		return strBuffer.toString();
	}
}