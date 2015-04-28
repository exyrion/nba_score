package com.example.fragmentsdemo;

import com.example.fragmentsdemo.MyDialogFragment.DialogListener;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.os.Build;

public class FragDemoMainActivity extends ActionBarActivity implements DialogListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frag_demo_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		DynamicFragment dynamic = DynamicFragment.newInstance("I am the dynamic fragment.");
		FragmentManager fm = getSupportFragmentManager();
		fm.beginTransaction().add(R.id.dynamicFragmentContainer, dynamic).commit();
	}
	
	public void changeTextView(View v){
		MyDialogFragment confirm = new MyDialogFragment();
		FragmentManager fm = getSupportFragmentManager();
		confirm.show(fm, "Confirmation");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.frag_demo_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_frag_demo_main,
					container, false);
			return rootView;
		}
	}

	@Override
	public void changeText(DialogFragment dialog) {
		EditText edit = (EditText)dialog.getDialog().findViewById(R.id.editText);
		DynamicFragment newFragment = 
				DynamicFragment.newInstance(edit.getText().toString());
		FragmentManager fm = getSupportFragmentManager();
		fm.beginTransaction().replace(R.id.dynamicFragmentContainer, newFragment).commit();
	}

}
