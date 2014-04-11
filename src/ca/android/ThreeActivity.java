package ca.android;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.LegendAlign;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.LinearLayout;

public class ThreeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_three);
		
		// first init data
		// sin curve
		int num = 150;
		GraphViewData[] average_data = new GraphViewData[num];
		GraphViewData[] user_data = new GraphViewData[num];
		double v=0;
		
		// Average curve
		average_data = new GraphViewData[num];
		v=0;
		for (int i=0; i<num; i++) {
		   v += 0.2;
		   average_data[i] = new GraphViewData(i, Math.sin(Math.random()*v));
		}
		// Color.rgb(90, 250, 00)
		GraphViewSeries seriesAvg = new GraphViewSeries("Average", null, average_data);
		 
		// User's curve
		num = 1000;
		user_data = new GraphViewData[num];
		v=0;
		for (int i=0; i<num; i++) {
		   v += 0.2;
		   user_data[i] = new GraphViewData(i, Math.sin(Math.random()*v));
		}
		GraphViewSeries seriesUsr = new GraphViewSeries("Me", null, user_data);
		 
		/*
		 * create graph
		 */
		GraphView graphView = new LineGraphView(
		      this
		      , "Recent Activity"
		);
		
		
		// Add Data
		graphView.addSeries(seriesAvg);
		graphView.addSeries(seriesUsr);
		
		//--------------------------------------------
		//	Graph Settings
		//--------------------------------------------
		// Set view port, start=0, size=10
		graphView.setViewPort(0, 10);
		graphView.setScrollable(true);
		graphView.setScalable(true);
		
		// Legend Settings
		graphView.setShowLegend(true);
		graphView.setLegendAlign(LegendAlign.BOTTOM);
		graphView.getGraphViewStyle().setLegendBorder(20);
		graphView.getGraphViewStyle().setLegendSpacing(30);
		graphView.getGraphViewStyle().setLegendWidth(300);
		
		// Add GraphView to LinearLayout "activity_CA"
		LinearLayout layout = (LinearLayout) findViewById(R.id.activity_CA);
		layout.addView(graphView);

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.three, menu);
		return true;
	}

}
