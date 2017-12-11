package com.lmac.sfs.server.net;

import java.net.InetAddress;

import com.lmac.sfs.server.config.Options;

public class ConnectionMP {

	private int playerID, port, timeOutCounter;
	private InetAddress address;
	private boolean isConnected;

	public ConnectionMP(int playerID, InetAddress address, int port) {
		this.playerID = playerID;
		this.port = port;
		this.address = address;
		this.timeOutCounter = 0;
		this.isConnected = true;
	}

	public void update() {
		timeOutCounter++;
		if (timeOutCounter > Options.CONNECTION_TIMEOUT) {
			disconnect();
		}

	}

	public void connect() {
		this.isConnected = true;
	}

	public void disconnect() {
		this.isConnected = false;
	}

	public int getPort() {
		return port;
	}

	public InetAddress getAddress() {
		return address;
	}

	public boolean getConnectionStatus() {
		return isConnected;
	}
	public int getPlayerID(){
		return playerID;
	}

}
