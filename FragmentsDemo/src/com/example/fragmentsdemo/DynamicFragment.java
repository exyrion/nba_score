package com.example.fragmentsdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DynamicFragment extends Fragment{
	
	public static DynamicFragment newInstance(String text){
		DynamicFragment d = new DynamicFragment();
		Bundle args = new Bundle();
		args.putString("text", text);
		d.setArguments(args);
		
		return d;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.dynamic_fragment, container, false);
		TextView text= (TextView)v.findViewById(R.id.dynamicTextView);
		String t = getArguments().getString("text");
		text.setText(t);
		
		return v;
		
	}

}
