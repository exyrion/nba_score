package com.example.fragmentsdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

public class MyDialogFragment extends DialogFragment{
	public interface DialogListener {
		public void changeText(DialogFragment dialog);
	}
	
	DialogListener mListener;
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity); //I was missing this in the live demo,
			// and this is what caused it to crash
		mListener = (DialogListener)activity;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState){
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		builder.setView(inflater.inflate(R.layout.text_dialog, null));
		
		builder.setMessage("Choose your text to display");
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		
		builder.setPositiveButton("Choose", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				mListener.changeText(MyDialogFragment.this);
			}
		});
		
		return builder.create();
		
		
	}
	
}
