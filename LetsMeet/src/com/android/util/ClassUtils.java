package com.android.util;

import java.lang.reflect.Field;

import org.json.JSONException;
import org.json.JSONObject;

public class ClassUtils 
{
	public static void objectMapping(Object mainObj, JSONObject jsonObject) throws JSONException 
	{
		Field[] fields =  mainObj.getClass().getFields();
		
		for (Field field : fields) 
		{
			try 
			{
				field.set(mainObj, jsonObject.getString(field.getName()));
				System.out.println("Received Data :----->>>>>" + field);
			}
			catch (JSONException e) 
			{
				e.printStackTrace();
			}
			catch (IllegalArgumentException e) 
			{
				e.printStackTrace();
			}
			catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void objectMapping(Object mainObj,String key,Object value) 
	{
		Field[] fields =  mainObj.getClass().getFields();

		for (Field field : fields)
		{
			if(field.getName().equalsIgnoreCase(key))
			{
				try
				{
					field.set(mainObj, value);
					break;
				}
				catch (IllegalArgumentException e) 
				{				
					e.printStackTrace();
				}
				catch (IllegalAccessException e) 
				{				
					e.printStackTrace();
				}
			}
		}
	}
}
