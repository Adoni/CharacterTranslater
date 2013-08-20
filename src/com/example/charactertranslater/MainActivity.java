package com.example.charactertranslater;

import java.util.HashMap;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.telephony.gsm.SmsManager;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button requireButton;
	private Button bigrequireButton;
	private EditText input;
	private TextView shower;
	private String[] words;
	private HashMap<Character, Character> wordmap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		words=getResources().getStringArray(R.array.words);
		wordmap=new HashMap<Character, Character>();
		for(int i=0;i<words.length;i++)
		{
			wordmap.put(words[i].charAt(0), words[i].charAt(2));
		}
		bigrequireButton=(Button)findViewById(R.id.bigrequirebutton);
		requireButton=(Button)findViewById(R.id.requirebutton);
		input=(EditText)findViewById(R.id.inputedit);
		shower=(TextView)findViewById(R.id.shower);
		shower.setMovementMethod(ScrollingMovementMethod.getInstance());
		bigrequireButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				shower.setTextSize(50);
				String inputresult=input.getText().toString();
				Toast.makeText(getApplicationContext(),inputresult, Toast.LENGTH_SHORT).show();
				if(inputresult==null || inputresult==""){
					Toast.makeText(getApplicationContext(), "请输入查询内容", Toast.LENGTH_SHORT).show();
					Log.v("mylog", "");
					return;
				}
				else
				{
					String result=new String();
					result="";
					for(int i=0;i<inputresult.length();i++)
					{
						Character ch=wordmap.get(inputresult.charAt(i));
						if(ch==null)
							ch=inputresult.charAt(i);
						result=result+ch;
					}
					shower.setGravity(Gravity.CENTER);
					shower.setGravity(Gravity.CENTER_HORIZONTAL);
					shower.setText(result);
					//shower.setText(result);
					Intent intent=new Intent();
					intent.setClass(MainActivity.this, SampleTitlesWithListener.class);
					//Toast.makeText(getApplicationContext(), "finish", Toast.LENGTH_SHORT).show();
					intent.putExtra("resultString", result);
					intent.putExtra("iniString", inputresult);
					MainActivity.this.startActivity(intent);
				}
			}
		});
		
		requireButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				shower.setTextSize(50);
				String inputresult=input.getText().toString();
				Toast.makeText(getApplicationContext(),inputresult, Toast.LENGTH_SHORT).show();
				if(inputresult==null || inputresult==""){
					Toast.makeText(getApplicationContext(), "请输入查询内容", Toast.LENGTH_SHORT).show();
					Log.v("mylog", "");
					return;
				}
				else
				{
					String result=new String();
					result="";
					for(int i=0;i<inputresult.length();i++)
					{
						Character ch=wordmap.get(inputresult.charAt(i));
						if(ch==null)
							ch=inputresult.charAt(i);
						result=result+ch;
					}
					shower.setGravity(Gravity.CENTER);
					shower.setGravity(Gravity.CENTER_HORIZONTAL);
					shower.setText(result);
				}
			}
		});
		((Button)findViewById(R.id.sendmessage)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stu
				Uri smsToUri=Uri.parse("smsto:");
				Intent intent=new Intent(Intent.ACTION_SENDTO,smsToUri);
				String inputresult=input.getText().toString();
				Toast.makeText(getApplicationContext(),inputresult, Toast.LENGTH_SHORT).show();
				if(inputresult==null || inputresult==""){
					Toast.makeText(getApplicationContext(), "请输入查询内容", Toast.LENGTH_SHORT).show();
					Log.v("mylog", "");
					return;
				}
				else
				{
					String result=new String();
					result="";
					for(int i=0;i<inputresult.length();i++)
					{
						Character ch=wordmap.get(inputresult.charAt(i));
						if(ch==null)
							ch=inputresult.charAt(i);
						result=result+ch;
					}
					intent.putExtra("sms_body", result);
					MainActivity.this.startActivity(intent);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
