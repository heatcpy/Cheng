package com.ahuo.cheng.tcp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient implements Runnable{
	Socket client;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			client = new Socket("192.168.5.48",8889);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			CloseUtil.closeAll(client);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			CloseUtil.closeAll(client);
		}
		//�������͵��߳������
		TcpClientSend send = new TcpClientSend(client);
		//�������յ��߳������
		TcpClientReceive receive = new TcpClientReceive(client);
		
		//����Thread����������߳�
		new Thread(send).start();
		new Thread(receive).start();
	}

}
