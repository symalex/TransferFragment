package com.symbysoft.transferfragment;

import android.app.Application;
import android.app.Fragment;
import android.util.Log;

public class MyApp extends Application
{
	private static final String TAG = MyApp.class.getSimpleName();
	static Fragment mFragment;

	@Override
	public void onCreate()
	{
		super.onCreate();
		Log.d(TAG, this + ": onCreate()");
	}
}
