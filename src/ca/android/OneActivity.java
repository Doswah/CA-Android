package ca.android;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class OneActivity extends Activity {
	
	String user_name;
	Exercises[] ExerciseList = new Exercises[5];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		
		// TextView for welcome prompt
		//TextView txtName = (TextView) findViewById(R.id.welcome);
		
		// TextView for Exercises
		TextView Ex1 = (TextView) findViewById(R.id.Exercise1);
		TextView Ex2 = (TextView) findViewById(R.id.Exercise2);
		TextView Ex3 = (TextView) findViewById(R.id.Exercise3);
		TextView Ex4 = (TextView) findViewById(R.id.Exercise4);
		TextView Ex5 = (TextView) findViewById(R.id.Exercise5);
		
		ExerciseList[0] = new Exercises("Chair Dips","9:00am","Done","15");
		ExerciseList[1] = new Exercises("Leg Lifts","11:30am","Done","25");
		ExerciseList[2] = new Exercises("Backstroke Stetch","1:00pm","Pending","10");
		ExerciseList[3] = new Exercises("#selfie","1:30pm","Pending","10");
		ExerciseList[4] = new Exercises("Da Damo","4:20pm","Pending","10");
		
		Ex1.setText("   " + ExerciseList[0].getName() +  " - " + ExerciseList[0].getTime());
		Ex2.setText("   " + ExerciseList[1].getName() +  " - " + ExerciseList[1].getTime());
		Ex3.setText("   " + ExerciseList[2].getName() +  " - " + ExerciseList[2].getTime());
		Ex4.setText("   " + ExerciseList[3].getName() +  " - " + ExerciseList[3].getTime());
		Ex5.setText("   " + ExerciseList[4].getName() +  " - " + ExerciseList[4].getTime());
		
		// Get and set username value from Login activity
		//Intent i = getIntent();
		//String nameOfUser = i.getStringExtra("login_nameOfUser");
		//Log.e("Second Screen",nameOfUser);
		//txtName.setText("Christian");
		   	
	}
	
	
	@Override
	public void onBackPressed() {
		this.getParent().onBackPressed();
	}

	
}
