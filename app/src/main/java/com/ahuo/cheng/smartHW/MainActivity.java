package com.ahuo.cheng.smartHW;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ahuo.cheng.R;

public class MainActivity extends Activity {
	Button btn_login;
	Button btn_register;
	EditText et_passwd;
	EditText et_username;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn_login = (Button)findViewById(R.id.btn_login);
		btn_register = (Button)findViewById(R.id.btn_register);
		et_username = (EditText)findViewById(R.id.et_username);
		et_passwd = (EditText)findViewById(R.id.et_userpasswd);
		
		OnClickListener btnClickListener = new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent= new Intent();
				String usrname = et_username.getText().toString().trim();
				String passwd = et_passwd.getText().toString().trim();
				
				switch (v.getId()) {
				case R.id.btn_login:
					
					if(!usrname.isEmpty() && !passwd.isEmpty()){
						Log.e(usrname, passwd);
						//System.out.println("�û���:"+usrname+"����:"+passwd);
						
						if(usrname.equals("root") && passwd.equals("1")){
							intent.setClass(MainActivity.this, LoginActivity.class);
							startActivity(intent);
							Toast.makeText(MainActivity.this, "��¼�ɹ�", Toast.LENGTH_LONG).show();
						}
						else{
							Toast.makeText(MainActivity.this, "�û������������", Toast.LENGTH_LONG).show();
						}
					}
					else{
						Toast.makeText(MainActivity.this, "�û��������벻����Ϊ��", Toast.LENGTH_LONG).show();
					}
					
					break;
					
				case R.id.btn_register:
					//Intent intent2 = new Intent();
					intent.setClass(MainActivity.this, RegisterActivity.class);
					startActivity(intent);
					Toast.makeText(MainActivity.this, "ע���û�", Toast.LENGTH_LONG).show();
					break; 
					
				default:
					break;
				}
			}
		};
		//�󶨼�����
		btn_login.setOnClickListener(btnClickListener);
		btn_register.setOnClickListener(btnClickListener);
		
	}

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
