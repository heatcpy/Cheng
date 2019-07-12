package com.ahuo.cheng.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class TcpClientReceive implements Runnable{//�߱����߳�����

	private	DataInputStream dis;
	private boolean flag=true;
	
	public TcpClientReceive(Socket client) {
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			flag=false;
			CloseUtil.closeAll(dis,client);
		}
	}
	private String getMessage(){
		String str = "";
		try {
			str = dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			flag=false;
			CloseUtil.closeAll(dis);//IO�����йر�
		}
		return str;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag){
			System.out.println(this.getMessage());
		}
	}
}

