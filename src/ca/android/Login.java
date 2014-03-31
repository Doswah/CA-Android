package ca.android;

import java.net.URI;
import org.xmlrpc.android.XMLRPCClient;
import org.xmlrpc.android.XMLRPCException;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {

	// Initialize Variables
	EditText	inputUsername;
	EditText	inputPassword;
	String		username;
	String		password;
	String		result;
	
	// Client Declare
	private XMLRPCClient client;
	private URI myuri;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		// Declare EditText with Variables
		inputUsername = (EditText) findViewById(R.id.username);
		inputPassword = (EditText) findViewById(R.id.password);
		
		// Create Client Connection
		myuri = URI.create("http://128.171.61.142:8008");
		client = new XMLRPCClient(myuri);
		
		// Create Button to login
		Button btnLogin = (Button) findViewById(R.id.btnLogin);
		
		btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View btnLogin) {
				// Create Intent to confirm screen
				Intent Home = new Intent(getApplicationContext(), Dashboard.class);
				Intent Login = new Intent(getApplicationContext(), Login.class);
				// Send data to confirm screen
				try {
				  // Read TextEdit Values
				  username = inputUsername.getText().toString();
				  password = inputPassword.getText().toString();
				  
				  // Verify User name & Password, then return result
				  result = (String) client.call("is_pass",username,password);
				  Log.e("n",result.toString());
				  
				} catch (XMLRPCException ex) {
				  // Exception Handling
					startActivity(Home);
				}
				
				// Depending on result, go to Home Activity
				if(result.equals("ok_damo")) { startActivity(Home); }
				if(result.equals("no_damo")) { startActivity(Login); }
				if(result.equals("who_damo")){ startActivity(Login); }
			}
		});
		
	} // EndOnCreate

}
