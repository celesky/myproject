package com.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo {

	public static void readFileInBuffer() throws Exception {
		//从FileInputStream 获取通道：
		FileInputStream fin = new FileInputStream("D:\\test.txt");
		FileChannel fc = fin.getChannel();

		//创建缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

		fc.read(byteBuffer);
	}
	public static void writeFileInBuffer() throws Exception {
		//从FileInputStream 获取通道：
		FileOutputStream fout = new FileOutputStream( "writesomebytes.txt" );
		FileChannel fc = fout.getChannel();

		//创建缓冲区
		ByteBuffer buffer = ByteBuffer.allocate( 1024 );
		Byte[] message = new Byte[]{1,2,3,4,5};
		for (int i=0; i<message.length; ++i) {
			buffer.put( message[i] );
		}
		buffer.flip();
		fc.write( buffer );
	}
}
