package com.ahuo.cheng.lowlevel;

public class LedNative {
	
	static {
		//����led_jni��̬�⣬led_jni���Զ�����ΪѰ��libled_jni.so
		System.loadLibrary("led_jni");//system/lib/libled_jni.so
	}
	public native int openDev();
	public native int devOn();
	public native int devOff();
	public native int closeDev();
	
}


