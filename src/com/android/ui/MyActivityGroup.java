package com.android.ui;

import android.app.ActivityGroup;
import android.view.View;

public abstract class MyActivityGroup extends ActivityGroup
{
	protected abstract void back(); 
	protected abstract void replaceView(View view);
}
