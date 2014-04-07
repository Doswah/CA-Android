package ca.android;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.LineGraphView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

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
