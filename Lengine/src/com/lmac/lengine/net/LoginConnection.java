package com.lmac.lengine.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lengine.config.Options;
import com.lmac.lengine.states.GameState;
import com.lmac.lengine.utils.Log;

public class LoginConnection {

	private int port;
	private DatagramSocket socket = null;
	private InetAddress address;
	private byte[] inData, outData;
	private int packetSize;
	private final String HAND_SHAKE = "handshake";
	private boolean loginStatus = false;
	private StateBasedGame game;
	
	public LoginConnection(Connection conn, StateBasedGame game) {
		this.socket = conn.getSocket();
		this.port = conn.getPort();
		this.address = conn.getAddress();
		this.packetSize = Options.LOGIN_PACKET_SIZE;
		this.game = game;
	}

	public void login(String username, String password, int charID) {
		inData = new byte[packetSize];
		outData = new byte[packetSize];

		outData = new String(HAND_SHAKE + "-" + username + "-" + password + "-" + charID).getBytes();
		DatagramPacket outPacket = new DatagramPacket(outData, outData.length, address, port);
		DatagramPacket inPacket = new DatagramPacket(inData, inData.length);
		try {

			socket.send(outPacket);
			socket.setSoTimeout(5000);
			Log.print("Waiting to receive on Client");
			socket.receive(inPacket);
				
			String confirmation = new String(inPacket.getData());
			Log.print("Received : " + confirmation);	
			if (confirmation.trim().equals("confirmed")) {
				Log.print("Login : confirmed");
				loginStatus = true;
				
				game.enterState(1);
		
				
			} else if (confirmation.trim().equals("denied")) {
				
				loginStatus = false;
				Log.print("Login : denied");
				
			}
			else {
				Log.print("YOU SUCK");
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
