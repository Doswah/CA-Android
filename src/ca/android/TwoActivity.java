package ca.android;

import android.app.Activity;
import android.os.Bundle;
import java.net.URI;
import org.xmlrpc.android.XMLRPCClient;
import org.xmlrpc.android.XMLRPCException;


public class TwoActivity extends Activity {
	
	String[] LeaderboardNames = new String[5];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
	}
	
	@Override
	public void onBackPressed() {
		this.getParent().onBackPressed();
	}
}
