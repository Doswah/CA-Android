package ca.android;

import java.net.URI;
import org.xmlrpc.android.XMLRPCClient;
import org.xmlrpc.android.XMLRPCException;
import ca.android.Dashboard;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

@SuppressLint("NewApi")
public class Login extends Activity {

	// Initialize Variables
	EditText inputUsername;
	EditText inputPassword;
	String username;
	String password;
	String result;
	Object i;
	
	// Client Declare
	private XMLRPCClient client;
	private URI myuri;
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		// Declare EditText with Variables
		inputUsername = (EditText) findViewById(R.id.username);
		inputPassword = (EditText) findViewById(R.id.password);
		
		// Create Client Connection
		myuri = URI.create("http://128.171.61.142:8008");
		client = new XMLRPCClient(myuri);
		
		// Create Button to login
		final Button btnLogin = (Button) findViewById(R.id.btnLogin);
		
		btnLogin.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View btnLogin) {
				// Create Intent to confirm screen
				//Intent next_Dashboard = new Intent(getApplicationContext(), Dashboard.class);
				Intent next_Login = new Intent(getApplicationContext(), Login.class);
				Intent next_MainController = new Intent(getApplicationContext(), MainController.class);

				try {
				  // Read TextEdit Values
				  result = inputUsername.getText().toString();
				  username = inputUsername.getText().toString();
				  password = inputPassword.getText().toString();
				  
				  // Verify User name & Password, then return result
				  result = (String) client.call("is_pass",username,password);
				  
				  
				} catch (XMLRPCException ex) {
						startActivity(next_MainController);
				}
				
				Log.e("n",result);
				
				
				// Depending on result, go to Home Activity
				if(result.equals("who_damo")) {
					startActivity(next_MainController);
				}
				if(result.equals("no_damo")) {
						startActivity(next_Login);
				}
				if(result.equals("ok_damo")) {
						startActivity(next_MainController);
				}

			}
		});
		
	} // EndOnCreate
	
}
