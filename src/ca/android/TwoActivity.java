package ca.android;

import android.app.Activity;
import android.os.Bundle;

public class TwoActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
	}
	
	// Friend code goes here. This is a stub.
	
	@Override
	public void onBackPressed() {
		this.getParent().onBackPressed();
	}
}
