package edu.ucsb.cs.cs185.justinliang.justinliangscoring;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;

public class DateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the current date as the default date in the picker
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);

		// Create a new instance of DatePickerDialog and return it
		return new DatePickerDialog(getActivity(), this, year, month, day);
	}

	//When the "done" button is pressed
	public void onDateSet(DatePicker view, int year, int month, int day) 
	{
		TextView date = (TextView) getActivity().findViewById(R.id.date_textview);
		String monthString = "";
		switch(month)
		{
			case 0: monthString = "January"; break;
			case 1: monthString = "February"; break;
			case 2: monthString = "March"; break;
			case 3: monthString = "April"; break;
			case 4: monthString = "May"; break;
			case 5: monthString = "June"; break;
			case 6: monthString = "July"; break;
			case 7: monthString = "August"; break;
			case 8: monthString = "September"; break;
			case 9: monthString = "October"; break;
			case 10: monthString = "November"; break;
			case 11: monthString = "December"; break;
		}
		date.setText(monthString + " " + day + ", " + year);
	}
}