package ca.android;

import android.app.Activity;
import android.os.Bundle;


public class TwoActivity extends Activity {
	
	String[] LeaderboardNames = new String[5];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
	}
	
	
	//TextView N1 = (TextView) findViewById(R.id.first_name);
	//TextView N2 = (TextView) findViewById(R.id.second_name);
	//TextView N3 = (TextView) findViewById(R.id.third_name);
	//TextView NMe = (TextView) findViewById(R.id.my_name);
		
	
	
	
	@Override
	public void onBackPressed() {
		this.getParent().onBackPressed();
	}
}
