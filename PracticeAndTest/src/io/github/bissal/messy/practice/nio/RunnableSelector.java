package io.github.bissal.messy.practice.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class RunnableSelector implements Runnable {

	private Selector			selector;
	private ServerSocketChannel	serverSocketChannel;
	private ByteBuffer			sendbuffer;

	public RunnableSelector() {
	}

	public void init() throws IOException {
		selector = Selector.open();

		serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);

		ServerSocket serverSocket = serverSocketChannel.socket();

		InetSocketAddress inetSocketAddress = new InetSocketAddress(10086);

		serverSocket.bind(inetSocketAddress);
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		sendbuffer = ByteBuffer.allocateDirect(1024);
	}
	
	private void accept(SelectionKey selectionKey)
			throws IOException,	ClosedChannelException {

		ServerSocketChannel serverChannel
		= (ServerSocketChannel) selectionKey.channel();

		SocketChannel connectedChannel = serverChannel.accept();

		connectedChannel.configureBlocking(false);
//		connectedChannel.register(selector, SelectionKey.OP_READ);
		connectedChannel.register(selector, SelectionKey.OP_WRITE);
		
		final Selector sel = Selector.open();
		connectedChannel.register(sel, SelectionKey.OP_WRITE);
		
		Thread fork = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {
					try {
						sel.select();						
						while (sel.selectedKeys().iterator().hasNext()) {
							
							System.out.println(sel.selectedKeys().iterator().next().isWritable());
							Thread.sleep(1500);
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		fork.start();

		Socket socket = connectedChannel.socket();

		System.out.println("accept <> connected from "
				+ socket.getInetAddress().toString() + ":" + socket.getPort());
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			try {
				count = selector.select();
				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
	
				while (iterator.hasNext()) {
					SelectionKey selectionKey = iterator.next();
	
					if (selectionKey.isAcceptable()) {
						accept(selectionKey);
						
					} else if (selectionKey.isReadable()) {
						System.out.println("readable :: " + count);
							
					} else if (selectionKey.isWritable()) {
						System.out.println("writable :: " + count);						
					}
	
					if (!selectionKey.isValid()) {
						selectionKey.cancel();
					}
					iterator.remove();
					Thread.sleep(1000);
				}
			} catch (ClosedChannelException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
