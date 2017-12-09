package com.lmac.lengine.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lengine.config.Options;
import com.lmac.lengine.utils.Log;

public class ServerReceiver extends Thread {

	private int port;
	private DatagramSocket socket = null;
	private InetAddress address;
	private byte[] inData, outData;


	private boolean loginStatus = false;
	
	public ServerReceiver(Connection conn, StateBasedGame game){
		this.socket = conn.getSocket();
		this.port = conn.getPort();
		this.address = conn.getAddress();
		
	}
	@Override
	public void run(){
		
		
		
		
		
	}
	
	
	public void sendTest(){
		
		String data = "92-this is a test packet";
		outData = new byte[256];
		outData = data.getBytes();
		DatagramPacket p = new DatagramPacket(outData, outData.length, address, port);
		
		try {
			
			Log.print("Sending Packet");
			socket.send(p);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
