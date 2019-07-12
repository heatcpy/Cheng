package com.ahuo.cheng.smartHW;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.ahuo.cheng.R;
import com.ahuo.cheng.tcp.NetDebugActivity;

public class LoginActivity extends Activity{

	Button btn_majorled;
	Button btn_MinorLed;
	Button btn_sunled;
	Button btn_AddDev;
	Button btn_DebugTcp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_select);
		
		btn_majorled = (Button)findViewById(R.id.btn_majorled);
		btn_MinorLed = (Button)findViewById(R.id.btn_minorled);
		btn_sunled = (Button)findViewById(R.id.btn_sunled);
		btn_AddDev = (Button)findViewById(R.id.btn_AddDev);
		btn_DebugTcp = (Button)findViewById(R.id.btn_DebugTcp);
		
		OnClickListener btnClickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent= new Intent();
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.btn_majorled:
					intent.setClass(LoginActivity.this, LedCtrlActivity.class);
					startActivity(intent);
					Toast.makeText(LoginActivity.this, "�����ң�LED�ƿ���", Toast.LENGTH_LONG).show();
					break;
				case R.id.btn_minorled:
					intent.setClass(LoginActivity.this, LedCtrlActivity.class);
					startActivity(intent);
					Toast.makeText(LoginActivity.this, "�����ң�LED�ƿ���", Toast.LENGTH_LONG).show();
					break;
				case R.id.btn_sunled:
					intent.setClass(LoginActivity.this, LedCtrlActivity.class);
					startActivity(intent);
					Toast.makeText(LoginActivity.this, "��̨��LED�ƿ���", Toast.LENGTH_LONG).show();
					break;
				case R.id.btn_AddDev:
					intent.setClass(LoginActivity.this, ScanCodeActivity.class);
					startActivity(intent);
					Toast.makeText(LoginActivity.this, "����豸", Toast.LENGTH_LONG).show();
					break;
				case R.id.btn_DebugTcp:
					intent.setClass(LoginActivity.this, NetDebugActivity.class);
					startActivity(intent);
					Toast.makeText(LoginActivity.this, "�����������", Toast.LENGTH_LONG).show();
					break;
				default:
					break;
				}
			}
		};
		
		//�󶨼�����
		btn_majorled.setOnClickListener(btnClickListener);
		btn_MinorLed.setOnClickListener(btnClickListener);
		btn_sunled.setOnClickListener(btnClickListener);
		btn_AddDev.setOnClickListener(btnClickListener);
		btn_DebugTcp.setOnClickListener(btnClickListener);
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}



