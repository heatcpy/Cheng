package com.ahuo.cheng.smartHW;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ahuo.cheng.R;
import com.ahuo.cheng.lowlevel.LedNative;

public class LedCtrlActivity extends Activity{
	
	LedNative mynative;
	Button btn_ledon;
	boolean isLedOnOFF = true;
	boolean isEnableNative = false;	//��������jni��̬��
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ledctrl);
		
		btn_ledon = (Button) findViewById(R.id.btn_ledon);
//		btn_ledon.setText("����");
//		initUI();
		if(isEnableNative == true){
			mynative = new LedNative();
			mynative.openDev();
		}
	}
	
	public void LedOnOffCtrol(View v) {
		Toast.makeText(LedCtrlActivity.this, "��������", Toast.LENGTH_LONG);
		if(isLedOnOFF ==true){
			isLedOnOFF =false;
			btn_ledon.setText("����");
			Log.i("LedCtrlActivity", "led on");
			Toast.makeText(LedCtrlActivity.this, "�����ˣ������", Toast.LENGTH_LONG).show();
			if(isEnableNative == true){
				mynative.devOn();
				Log.i("LedCtrlActivity", "mynative devOn");
			}
		}
		else{
			isLedOnOFF =true;
			btn_ledon.setText("�ص�");
			Log.i("LedCtrlActivity", "led off");
			Toast.makeText(LedCtrlActivity.this, "�����ˣ�������", Toast.LENGTH_LONG).show();
			if(isEnableNative == true){		
				Log.i("LedCtrlActivity", "mynative devOff");
				mynative.devOff();
			}
		}
	}
	
//	private void initUI() {
//		// TODO Auto-generated method stub
//		Button btn_on = (Button) findViewById(R.id.btn_ledon);
//		Button btn_off = (Button) findViewById(R.id.btn_ledoff);
//		
//		btn_on.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Log.i("LedCtrlActivity", "led on");
//				Toast.makeText(LedCtrlActivity.this, "�����ˣ������", 3000).show();
//				//mynative.devOn();
//			}
//		});
//		
//		btn_off.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Log.i("LedCtrlActivity", "led off");
//				Toast.makeText(LedCtrlActivity.this, "�����ˣ�������", 3000).show();
//				
//				mynative.devOff();
//			}
//		});
//	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//mynative.closeDev();
	}
}


