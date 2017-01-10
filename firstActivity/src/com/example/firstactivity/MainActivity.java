package com.example.firstactivity;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	
	EditText txtUsername, pwdPassword;
	Button btnLogin;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        this.txtUsername = (EditText) this.findViewById(R.id.username);
        this.pwdPassword = (EditText) this.findViewById(R.id.password);
        
        this.btnLogin = (Button) this.findViewById(R.id.LoginButton);
        
        this.btnLogin.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String user = this.txtUsername.getText().toString();
		String pass = this.pwdPassword.getText().toString();
		
		if((user.equals("admin")) && (pass.equals("helloworld")))
		{
			Toast.makeText(this, "Login Succesful", Toast.LENGTH_SHORT).show();
			
		}
		
		else
		{
			AlertDialog.Builder builder =  new AlertDialog.Builder(this);
			builder.setTitle("Error");
			builder.setMessage("invalid user");
			builder.setNeutralButton("OK", null);
			
			AlertDialog dialog = builder.create();
			dialog.show();
		}	
	}
    
}
