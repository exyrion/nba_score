package edu.ucsb.cs.cs185.justinliang.justinliangscoring;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class GameFragment extends DialogFragment
{
	public GameFragment()
	{
		super();
	}
	// define interface so that mainactivity can use it
	public interface GameFragmentListener
	{
		public void onDoneClick(DialogFragment dialog);
	}
	
	// initiate instance of GameFragmentListener
	GameFragmentListener mListener;
	
	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
		mListener = (GameFragmentListener)activity;
	}
	
//	public View onCreateView(LayoutInflater inflater, ViewGroup container,
//            Bundle savedInstanceState)
//	{
//		View view = inflater.inflate(R.layout.game_fragment, null);
//		String[] teams = getResources().getStringArray(R.array.team_array);
//	    AutoCompleteTextView team1 = (AutoCompleteTextView) view.findViewById(R.id.team1_textviewF);
//	    AutoCompleteTextView team2 = (AutoCompleteTextView) view.findViewById(R.id.team2_textviewF);
//	    ArrayAdapter<String> adapter = 
//	    		new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, teams);
//	    
//	    team1.setAdapter(adapter);
//	    team2.setAdapter(adapter);
//	    return view;
//	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) 
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	    LayoutInflater inflater = getActivity().getLayoutInflater();	 
	    
	    // set title of fragment to "enter game"
	    builder.setTitle("Enter Game");
	    
	    // inflate view
	    //builder.setView(inflater.inflate(R.layout.game_fragment, null));
	    View v = inflater.inflate(R.layout.game_fragment, null);
	    builder.setView(v);
	    
	    // autocomplete stuff
	    String[] teams = getResources().getStringArray(R.array.team_array);
	    AutoCompleteTextView team1 = (AutoCompleteTextView) v.findViewById(R.id.team1_textviewF);
	    AutoCompleteTextView team2 = (AutoCompleteTextView) v.findViewById(R.id.team2_textviewF);
	    ArrayAdapter<String> adapter = 
	    		new ArrayAdapter<String>(builder.getContext(), android.R.layout.simple_list_item_1, teams);
	    
	    team1.setAdapter(adapter);
	    team2.setAdapter(adapter);
	    
	    // define button
	    builder.setPositiveButton("Done", new DialogInterface.OnClickListener(){
	    	@Override
	    	public void onClick(DialogInterface dialog, int id)
	    	{
	    		mListener.onDoneClick(GameFragment.this);
	    	}
	    });
	    return builder.create();
	   
	}
}
