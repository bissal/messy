package dev.foursix.practice.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class SimpleChannelTest {
	
	public void foo() {
		ReadableByteChannel src = Channels.newChannel(System.in);
		WritableByteChannel dest =  Channels.newChannel(System.out);
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		try {
			while (src.read(buffer) != -1) {
				buffer.flip();
				while (buffer.hasRemaining()) {
					dest.write(buffer);
				}
				buffer.clear();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
