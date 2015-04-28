package edu.ucsb.cs.cs185.justinliang.justinliangscoring;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
//Date picker is widget, do not need XML, do not need to have separate datefragment.java file
//Enter game needs an xml file, and entergame.java
//Need autocomplete textview, scores is regular edittext
//Autocomplete is just a string array
//getActivity().findbyid
//in oncreateview, very first thing is getDialog().setTitle
//Make your class for date picker, extend dialogfragment, implements the ondatesetlistener
//Attach onclicklistener for done button in date class
//Use getActvity() to retrieve resources from main_activity.xml

public class MainActivity extends ActionBarActivity implements GameFragment.GameFragmentListener {
	
	public void changeDate (View view)
	{
	    DialogFragment dateFragment = new DateFragment();
	    dateFragment.show(getSupportFragmentManager(), "datePicker");
	}

	public void changeGame(View view)
	{
		DialogFragment gameFragment = new GameFragment();
		gameFragment.show(getSupportFragmentManager(), "gamePicker");
	}
	
	public void nextGame(View view)
	{
		TextView date = (TextView) findViewById(R.id.date_textview);
		date.setText("Date");
		TextView team1 = (TextView) findViewById(R.id.team1_textview);
		team1.setText("Team 1");
		TextView team2 = (TextView) findViewById(R.id.team2_textview);
		team2.setText("Team 2");
		TextView score1 = (TextView) findViewById(R.id.score1);
		score1.setText("0");
		TextView score2 = (TextView) findViewById(R.id.score2);
		score2.setText("0");
	}
	
	public void onDoneClick(DialogFragment dialog)
	{
		TextView team1 = (TextView) findViewById(R.id.team1_textview);
		TextView team2 = (TextView) findViewById(R.id.team2_textview);
		TextView score1 = (TextView) findViewById(R.id.score1);
		TextView score2 = (TextView) findViewById(R.id.score2);
		
		AutoCompleteTextView team1F = (AutoCompleteTextView) dialog.getDialog().findViewById(R.id.team1_textviewF);
		AutoCompleteTextView team2F = (AutoCompleteTextView) dialog.getDialog().findViewById(R.id.team2_textviewF);
		EditText score1F = (EditText) dialog.getDialog().findViewById(R.id.score1_textviewF);
		EditText score2F = (EditText) dialog.getDialog().findViewById(R.id.score2_textviewF);
		
		team1.setText(team1F.getText());
		team2.setText(team2F.getText());
		score1.setText(score1F.getText());
		score2.setText(score2F.getText());
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    

}
