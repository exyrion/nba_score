package com.example.fragmentsdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StaticFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			ViewGroup container, Bundle savedInstance){
		return inflater.inflate(R.layout.static_fragment, container,false);
	}

}
