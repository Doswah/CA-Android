package ca.android;

import java.util.ArrayList;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
//import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class OneActivity extends ListActivity {
	
	private ProgressDialog m_ProgressDialog = null;
	private ArrayList<Exercises> s_Exercises = null;
	private ExercisesAdapter m_adapter;
	private Runnable viewExercises;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		
		// Declare lists of Exercise objects
		s_Exercises = new ArrayList<Exercises>(); 	
		
		// Create ListView Adapter
		this.m_adapter = new ExercisesAdapter(this, R.layout.row, s_Exercises);	
		setListAdapter(this.m_adapter);  
		//final Handler handler = new Handler(); 
	    viewExercises = new Runnable() {
	        public void run() {
	        	getExercises();
	        }
	    };
	    //handler.postDelayed(viewExercises, 5000);	    
	    // Downlading from server dialog
	    Thread thread = new Thread(null, viewExercises,"MagnetoBackground");
	    	thread.start();
	    	m_ProgressDialog = ProgressDialog.show(OneActivity.this, 
	    			"Please wait...", "Putting sand in bags...",true);	    	
	}
	
	private Runnable returnRes = new Runnable() 
	{
		public void run() {
		if(s_Exercises != null && s_Exercises.size() > 0) {
			m_adapter.notifyDataSetChanged();
			for(int i=0; i < s_Exercises.size(); i++) {
				m_adapter.add(s_Exercises.get(i));
				}
			}
			m_ProgressDialog.dismiss();
			m_adapter.notifyDataSetChanged();
		}
	};

	private void getExercises() {
		try{
			s_Exercises = new ArrayList<Exercises>();
			
			Exercises E1 = new Exercises();
			E1.setName("Chair Dips");
			
			//Exercises E1 = new Exercises("Chair Dips","9:00am","Done","15");
			Exercises E2 = new Exercises("Leg Lifts","11:30am","Done","25");
			Exercises E3 = new Exercises("Backstroke Stetch","1:00pm","Pending","10");
			Exercises E4 = new Exercises("#selfie","1:30pm","Pending","10");
			Exercises E5 = new Exercises("Da Damo","4:20pm","Pending","10");
			
			s_Exercises.add(E1);
			s_Exercises.add(E2);
			s_Exercises.add(E3);
			s_Exercises.add(E4);
			s_Exercises.add(E5);
			
			Thread.sleep(2000);
			Log.i("ARRAY", "" + s_Exercises.size());
		}
		catch(Exception e) {
			Log.e("BACKGROUND_PROC", e.getMessage());
		}
		runOnUiThread(returnRes);
	}

	
	public class ExercisesAdapter extends ArrayAdapter<Exercises> {
		
		public ExercisesAdapter(Context context, int txtViewResourceId, ArrayList<Exercises> items) {
			super(context, txtViewResourceId, items);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if(v == null) {
				LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.row, null);
			}
			Exercises o = getItem(position);
			if(o != null) {
				TextView tt = (TextView) v.findViewById(R.id.toptext);
				TextView mt = (TextView) v.findViewById(R.id.midtext);
				TextView bt = (TextView) v.findViewById(R.id.bottomtext);
				
				if(tt != null) {
					tt.setText(o.getName() + " - " + o.getStatus() ); 
				}
				if(mt != null) { 
					mt.setText(o.getReps() + " Reps");
				}
				if(bt != null) { 
					bt.setText(o.getTime());
				}
		
				}
			return v;
		}
	}
	
	//@Override
	//public void onBackPressed() {
	//	this.getParent().onBackPressed();
	//}

	
}
