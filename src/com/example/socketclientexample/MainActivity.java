package com.example.socketclientexample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	EditText textOut;
	TextView textIn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  if (android.os.Build.VERSION.SDK_INT > 9) {
		    	 StrictMode.ThreadPolicy policy = 
		    	   new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    	 StrictMode.setThreadPolicy(policy);
		     }
		setContentView(R.layout.activity_main);
		 textOut = (EditText)findViewById(R.id.textout);
	     Button buttonSend = (Button)findViewById(R.id.send);
	     textIn = (TextView)findViewById(R.id.textin);
	     buttonSend.setOnClickListener(buttonSendOnClickListener);
	     
	   
		
	     
	     
	     
	     
	     
	
	}
	Button.OnClickListener buttonSendOnClickListener
	 = new Button.OnClickListener(){
		@Override
		public void onClick(View arg0) {
		 // TODO Auto-generated method stub
		 Socket socket = null;
		 DataOutputStream dataOutputStream = null;
		 DataInputStream dataInputStream = null;

		 try {
		  socket = new Socket("SERVER_IP", SERVER_PORT);
		  dataOutputStream = new DataOutputStream(socket.getOutputStream());
		  dataInputStream = new DataInputStream(socket.getInputStream());
		  dataOutputStream.writeUTF(textOut.getText().toString());
		  textIn.setText(dataInputStream.readUTF());
		 } catch (UnknownHostException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		 } catch (IOException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		 }
		 finally{
		  if (socket != null){
		   try {
		    socket.close();
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }

		  if (dataOutputStream != null){
		   try {
		    dataOutputStream.close();
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }

		  if (dataInputStream != null){
		   try {
		    dataInputStream.close();
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
		 }
		}};
		

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
