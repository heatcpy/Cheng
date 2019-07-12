package com.ahuo.cheng.tcp;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TcpClientSend implements Runnable{

	//�Ӽ��̻�ȡ����
	private BufferedReader br;
	//�������ݵ�������
	private DataOutputStream dos;
	private boolean flag=true;
	
	//Send������������ ����������ͬ��������ͬ������ֵ��ͬ��
	public TcpClientSend() {
		br = new BufferedReader(new InputStreamReader(System.in));//���̻�ȡ����
	}
	public TcpClientSend(Socket client ){
		this();//���ñ�����޲ι��췽��
		try {
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			flag=false;
			CloseUtil.closeAll(dos,client);
		}
	}
	//��ȡ��Ϣ�ķ���
	private String getMessage(){
		String str="";
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			flag = false;
			CloseUtil.closeAll(br);//���ر�
		}
		return str;
	}
	private void send(String str){
		try {
			dos.writeUTF(str);
			dos.flush();//��ջ���
		} catch (IOException e) {
			// TODO Auto-generated catch block
			flag = false;
			CloseUtil.closeAll(dos);//���ر�
		}
		
	}
	
	@Override//��д
	public void run() {
		while(flag){
			this.send(getMessage());
		}
	}
}
