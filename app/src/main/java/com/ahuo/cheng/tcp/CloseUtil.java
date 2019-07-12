package com.ahuo.cheng.tcp;

import java.io.Closeable;

public class CloseUtil {
	public static void  closeAll(Closeable... able) /*...Ϊ�ɱ����*/{
		for(Closeable c:able){
			if(c!=null){
				try {
					c.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
}
