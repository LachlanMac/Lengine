package com.lmac.lengine.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import com.lmac.lengine.config.Options;
import com.lmac.lengine.utils.Log;

public class LoginConnection {

	private int port;
	private DatagramSocket socket = null;
	private InetAddress address;
	private byte[] inData, outData;
	private int packetSize;
	private final String HAND_SHAKE = "handshake";
	private boolean loginStatus = false;

	public LoginConnection(Connection conn) {
		this.socket = conn.getSocket();
		this.port = conn.getPort();
		this.address = conn.getAddress();
		this.packetSize = Options.LOGIN_PACKET_SIZE;
		
	}

	public void login(String username, String password) {
		inData = new byte[packetSize];
		outData = new byte[packetSize];

		outData = new String(HAND_SHAKE + "-" + username + "-" + password).getBytes();
		DatagramPacket outPacket = new DatagramPacket(outData, outData.length, address, port);
		DatagramPacket inPacket = new DatagramPacket(inData, inData.length);
		try {

			socket.send(outPacket);
			socket.setSoTimeout(5000);
			socket.receive(inPacket);

			String confirmation = new String(inPacket.getData());

			if (confirmation.trim().equals("confirmed")) {
				Log.print("confirmed");
				loginStatus = true;
			}else{
				loginStatus = false;
			}

		} catch (SocketTimeoutException e) {
			Log.error("A socket time out has occured");
			loginStatus = false;
			e.printStackTrace();
		}

		catch (IOException e) {
			Log.error("could not send login handshake");
			loginStatus = false;
			e.printStackTrace();
		}

	}


	public boolean getLoginStatus() {
		return loginStatus;

	}

	

}
