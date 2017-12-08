package com.lmac.lengine.net;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.newdawn.slick.util.Log;

import com.lmac.lengine.config.Options;

public class Connection  {
	
	boolean isConnected = false;
	DatagramSocket socket = null;
	InetAddress serverAddress;
	int serverPort;
	
	
	public Connection(){
		try {
			socket = new DatagramSocket();
			serverAddress = InetAddress.getByName(Options.serverAddress);
			serverPort = Options.serverPort;
			
		} catch (SocketException e) {
			Log.error("Could not create client connection");
			e.printStackTrace();
		} catch (UnknownHostException e) {
			Log.error("Unknown Host");
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	public boolean isConnected(){
		return isConnected;
	}
	
	public DatagramSocket getSocket(){
		return socket;
	}
	
	public int getPort(){
		return serverPort;
	}
	public InetAddress getAddress(){
		return serverAddress;
	}
	
}
