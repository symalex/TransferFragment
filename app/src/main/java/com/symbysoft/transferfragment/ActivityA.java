package com.symbysoft.transferfragment;

import java.util.EventListener;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityA extends Activity implements View.OnClickListener
{
	private static final String TAG = ActivityA.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a);

		if (getFragmentManager().findFragmentByTag(MoveFragment.FTAG) == null)
		{
			if (MyApp.mFragment == null)
			{
				Log.d(TAG, this + ": Existing fragment not found. " + String.valueOf(MyApp.mFragment));
				MoveFragment fr = (MoveFragment) MoveFragment.CreateFragmentInstance(this);
				MyApp.mFragment = fr;
			} else {
				Log.d(TAG, this + ": Existing mFragment found. " + String.valueOf(MyApp.mFragment));
				MoveFragment fr = (MoveFragment)MoveFragment.AddFragmentTransaction(this,R.id.activity_a_main_layout_id);
			}
		}
		else
		{
			Log.d(TAG, this + ": Existing fragment found." +String.valueOf(MyApp.mFragment));
		}
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		Log.d(TAG, this + ": onPause()");
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		Log.d(TAG, this + ": onStop()");
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		Log.d(TAG, this + ": onResume()");
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Log.d(TAG, this + ": onDestroy()");
	}

	public void onBtnClick(View view){
		Log.d(TAG, this + ": btn.onClick()");
		Intent intent = new Intent(this, ActivityB.class);
		startActivity(intent);
	}

	public void onBtnClickChangeText(View view)
	{
		Log.d(TAG, this + ": onClickBtnChangeText()");
		if (MyApp.mFragment != null)
			((MoveFragment)MyApp.mFragment).setFragmentText("move fragment changed");
	}

	@Override
	public void onClick(View v)
	{
		switch( v.getId() )
		{
			case R.id.activity_a_btn:
				onBtnClick(v);
				break;

			case R.id.activity_a_btn_change_text:
				onBtnClickChangeText(v);
				break;
		}
	}
}
