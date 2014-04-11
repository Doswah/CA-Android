package ca.android;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class OneActivity extends Activity {
	
	String user_name;
	Exercises[] ExerciseList = new Exercises[5];
	
	// Notification Setup
	NotificationManager NM;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		
		
		// TextView for Exercises
		TextView Ex1 = (TextView) findViewById(R.id.Exercise1);
		TextView Ex2 = (TextView) findViewById(R.id.Exercise2);
		TextView Ex3 = (TextView) findViewById(R.id.Exercise3);
		TextView Ex4 = (TextView) findViewById(R.id.Exercise4);
		TextView Ex5 = (TextView) findViewById(R.id.Exercise5);
		
		ExerciseList[0] = new Exercises("Chair Dips","9:00am","Done","15");
		ExerciseList[1] = new Exercises("Leg Lifts","11:30am","Done","25");
		ExerciseList[2] = new Exercises("Backstroke Stretch","1:00pm","Pending","10");
		ExerciseList[3] = new Exercises("Leg Lifts","1:30pm","Pending","10");
		ExerciseList[4] = new Exercises("Backstroke Stretch","4:20pm","Pending","10");
		
		Ex1.setText("   " + ExerciseList[0].getName() +  " - " + ExerciseList[0].getTime());
		Ex2.setText("   " + ExerciseList[1].getName() +  " - " + ExerciseList[1].getTime());
		Ex3.setText("   " + ExerciseList[2].getName() +  " - " + ExerciseList[2].getTime());
		Ex4.setText("   " + ExerciseList[3].getName() +  " - " + ExerciseList[3].getTime());
		Ex5.setText("   " + ExerciseList[4].getName() +  " - " + ExerciseList[4].getTime());
		
		   	
	}
	
	
	 @Override
	   public boolean onCreateOptionsMenu(Menu menu) {
	      // Inflate the menu; this adds items to the action bar if it is present.
	      getMenuInflater().inflate(R.menu.activity_one, menu);
	      return true;
	   }
	
	@Override
	public void onBackPressed() {
		this.getParent().onBackPressed();
	}

	@SuppressWarnings("deprecation")
	   public void notify(View vobj){
	      String title = ("Time to exercise!");
	      String subject = ExerciseList[0].getName();
	      String body = ExerciseList[0].getTime();
	      NM=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
	      Notification notify=new Notification(android.R.drawable.
	      stat_notify_more,title,System.currentTimeMillis());
	      PendingIntent pending=PendingIntent.getActivity(
	      getApplicationContext(),0, new Intent(),0);
	      notify.setLatestEventInfo(getApplicationContext(),subject,body,pending);
	      NM.notify(0, notify);
	   }
	
	
	
}
