package com.symbysoft.transferfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityB extends Activity
{
	private static final String TAG = ActivityB.class.getSimpleName();

	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);

		if (getFragmentManager().findFragmentByTag(MoveFragment.FTAG) == null)
		{
			if (MyApp.mFragment == null)
			{
				Log.d(TAG, this + ": Existing fragment not found. " + String.valueOf(MyApp.mFragment));
				MoveFragment fr = (MoveFragment) MoveFragment.CreateFragmentInstance(this);
				MyApp.mFragment = fr;
			} else {
				Log.d(TAG, this + ": Existing mFragment found. " + String.valueOf(MyApp.mFragment));
				//MoveFragment fr = (MoveFragment)MoveFragment.AddFragmentTransaction(this,R.id.activity_b_layout_id);
				MoveFragment fr = (MoveFragment)MoveFragment.AddFragmentTransaction(this,R.id.activity_a_main_layout_id);
			}
		}
		else
		{
			Log.d(TAG, this + ": Existing fragment found." +String.valueOf(MyApp.mFragment));
		}

		btn = (Button)findViewById(R.id.activity_b_btn);
		btn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				ActivityB.this.onClick();
			}
		});
	}

	@Override
	protected void onPause()
	{
		super.onPause();

		((MoveFragment)MyApp.mFragment).RemoveFragment();
	}

	protected void onClick(){
		Log.d(TAG, this + ": btn.onClick()");
		finish();
	}

}
