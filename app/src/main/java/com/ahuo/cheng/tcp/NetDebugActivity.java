package com.ahuo.cheng.tcp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ahuo.cheng.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class NetDebugActivity extends Activity {

	boolean isConnect=true;//���ӻ��ǶϿ�
	Button ConnectButton;//�������Ӱ�ť
	Button SendButton;//���巢�Ͱ�ť
	EditText IPEditText;//����ip�����
	EditText PortText;//����˿������
	EditText MsgEditText;//������Ϣ�����
	EditText RrceiveEditText;//������Ϣ�����
	Socket socket = null;//����socket
	
	private OutputStream outputStream=null;//���������
	private InputStream inputStream=null;//����������
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_client);
		
		ConnectButton = (Button) findViewById(R.id.Connect_Bt);//������Ӱ�ť����
		SendButton = (Button) findViewById(R.id.Send_Bt);//��÷��Ͱ�ť����
		IPEditText = (EditText) findViewById(R.id.ip_ET);//���ip�ı������
		PortText = (EditText) findViewById(R.id.Port_ET);//��ö˿��ı���ť����
		MsgEditText = (EditText) findViewById(R.id.Send_ET);//��÷�����Ϣ�ı������
		RrceiveEditText = (EditText) findViewById(R.id.Receive_ET);//��ý�����Ϣ�ı������
	}

	public void Connect_onClick(View v) {
		if (isConnect == true) //��־λ = true��ʾ����
		{
			isConnect = false;//��Ϊfalse
			ConnectButton.setText("�Ͽ�");//��ť����ʾ--�Ͽ�
			//���������߳�
			Connect_Thread connect_Thread = new Connect_Thread();
			connect_Thread.start();
		}
		else //��־λ = false��ʾ�˳�����
		{
			isConnect = true;//��Ϊtrue
			ConnectButton.setText("����");//��ť����ʾ����
			try 
			{
				socket.close();//�ر�����
				socket=null;
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void Send_onClick(View v) {
		try 
		{
			//��ȡ�����
			outputStream = socket.getOutputStream();
			//��������
			outputStream.write(MsgEditText.getText().toString().getBytes());
			//outputStream.write("0".getBytes());
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�����߳�
	class Connect_Thread extends Thread {	//�̳�Thread
		public void run()//��дrun����
		{
			try 
			{
				if (socket == null) 
				{
					//��InetAddress������ȡip��ַ
					InetAddress ipAddress = InetAddress.getByName(IPEditText.getText().toString());
					int port =Integer.valueOf(PortText.getText().toString());//��ȡ�˿ں� 
					socket = new Socket(ipAddress, port);//�������ӵ�ַ�Ͷ˿�-------------------�����ͺö���
					//�ڴ��������Ӻ����������߳�
					Receive_Thread receive_Thread = new Receive_Thread();
					receive_Thread.start();
				}
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//�����߳�
	class Receive_Thread extends Thread
	{
		public void run()//��дrun����
		{
			try 
			{
				while (true) 
				{
					final byte[] buffer = new byte[1024];//�������ջ�����
					inputStream = socket.getInputStream();
					final int len = inputStream.read(buffer);//���ݶ����������ҷ������ݵĳ���
					runOnUiThread(new Runnable()//�����������߳�ֱ�Ӳ�����������ṩ�Ĵ˷�������
					{
						public void run() 
						{	
							// TODO Auto-generated method stub
							RrceiveEditText.setText(new String(buffer,0,len));	
						}	
					});
				}
			}
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
//import com.example.smartHW.LoginActivity;
//import com.example.smartHW.R;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//public class NetDebugActivity extends Activity{
//	
//	Button btn_ClienSend,btn_Connect;
//	EditText et_ClientTest;
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_client);
//		
//		btn_ClienSend = (Button)findViewById(R.id.btn_ClienSend);//��ð�ť����
//		btn_Connect = (Button)findViewById(R.id.btn_Connect);//��ð�ť����
//		et_ClientTest = (EditText)findViewById(R.id.et_ClientTest);//����ı������
//		
//		OnClickListener btnClickListener = new OnClickListener(){
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				switch(v.getId()){
//				case R.id.btn_ClienSend:
//					//TcpClientReceive receive = new TcpClientReceive(client);
//					TcpClient tcpclient = new TcpClient();
//					//����Thread����������߳�
//					new Thread(tcpclient).start();
//					Toast.makeText(NetDebugActivity.this, "����", 2000).show();
//					break;
//				case R.id.btn_Connect:
//					
//					Toast.makeText(NetDebugActivity.this, "����", 2000).show();
//					break;
//				default:
//					break;
//				}
//			}
//		};
//		
//		btn_ClienSend.setOnClickListener(btnClickListener);
//		btn_Connect.setOnClickListener(btnClickListener);
//	}
//	
//	@Override
//	protected void onDestroy() {
//		// TODO Auto-generated method stub
//		super.onDestroy();
//	}
//}
//



