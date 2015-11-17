package com.symbysoft.transferfragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MoveFragment extends Fragment
{
	public static final String FTAG = "move_fragment";
	private final String TAG = MoveFragment.class.getSimpleName();

	private Activity mActivity;
    private String stored_text = "";

	public static Fragment CreateFragmentInstance(Context ctx) {
		Activity activity = (Activity)ctx;

		FragmentManager fm = activity.getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();

		MoveFragment fragment = new MoveFragment();
		fragment.mActivity = activity;
		ft.add(R.id.activity_a_main_layout_id, fragment , FTAG);
		ft.commit();

		return fragment;
    }

	public static Fragment AddFragmentTransaction(Context ctx, int id) {
		MoveFragment fragment = (MoveFragment)MyApp.mFragment;
        if( fragment != null )
        {
	        Activity activity = (Activity) ctx;
	        fragment.mActivity = activity;
	        FragmentManager fm = activity.getFragmentManager();
	        FragmentTransaction ft = fm.beginTransaction();
	        if( ! fragment.isAdded() )
	        {
		        //ft.remove(fragment);
		        ft.add(id, fragment, FTAG);
	        }
	        if ( fragment.isDetached() )
		        ft.attach(fragment);
	        ft.commit();
        }
		return fragment;
	}

	public void RemoveFragment(){
		if( mActivity != null )
		{
			FragmentManager fm = mActivity.getFragmentManager();
			Fragment fragment = fm.findFragmentByTag(MoveFragment.FTAG);
			if( fragment != null )
			{
				FragmentTransaction fragTransaction = fm.beginTransaction();
				if( ! fragment.isDetached() )
				   fragTransaction.detach(fragment);
				//if( fragment.isAdded() )
				//   fragTransaction.remove(fragment);
				fragTransaction.commit();
			}
			//mActivity = null;
		}
	}

	public MoveFragment()
	{
		super();
		Log.d(TAG, this + ": this() " + this);
	}

	public void setFragmentText(String text){
		if( mActivity != null ){
			stored_text = text;
			TextView view = (TextView)mActivity.findViewById(R.id.fragment_text);
			if( view != null )
				view.setText(text);
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Log.d(TAG, this + ": onCreate()");
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.fragment_move, container, false);
		Log.d(TAG, this + ": onCreateView()");
		return v;
	}

	@Override
	public void onAttach(Context context)
	{
		super.onAttach(context);
		Log.d(TAG, this + ": onAttach(" + context + ")");
		mActivity = (Activity)context;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		Log.d(TAG, this + ": onActivityCreated()");
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);
		Log.d(TAG, this + ": onViewCreated()");

		if( stored_text != "" )
			setFragmentText(stored_text);
	}

	@Override
	public void onDestroyView()
	{
		super.onDestroyView();
		Log.d(TAG, this + ": onDestroyView()");
	}

	@Override
	public void onDetach()
	{
		super.onDetach();
		Log.d(TAG, this + ": onDetach()");
	}

	@Override
	public void onStart()
	{
		super.onStart();
		Log.d(TAG, this + ": onStart()");
	}

	@Override
	public void onResume()
	{
		super.onResume();
		Log.d(TAG, this + ": onResume()");
	}

	@Override
	public void onPause()
	{
		super.onPause();
		Log.d(TAG, this + ": onPause()");
		RemoveFragment();
	}

	@Override
	public void onStop()
	{
		super.onStop();
		Log.d(TAG, this + ": onStop()");
		RemoveFragment();
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		Log.d(TAG, this + ": onDestroy()");
	}
}
