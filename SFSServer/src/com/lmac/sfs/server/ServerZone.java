package com.lmac.sfs.server;

import java.net.DatagramSocket;
import java.net.SocketException;

import com.lmac.sfs.server.net.ConnectionManager;
import com.lmac.sfs.server.packets.PacketReceiver;
import com.lmac.sfs.server.packets.PacketSender;
import com.lmac.sfs.server.utils.Log;

public class ServerZone {

	private PacketReceiver pr;
	private PacketSender ps;
	private DatagramSocket socket;
	private ConnectionManager cm;
	private String zoneName;
	private int port;

	public ServerZone(int port, String zoneName, ConnectionManager cm) {
		
		this.zoneName = zoneName;
		this.cm = cm;
		this.port = port;

		try {
			this.socket = new DatagramSocket(port);

		} catch (SocketException e) {

			Log.error("Could not set up socket");

		}

	}

	public void init() {

		pr = new PacketReceiver(socket, this, cm);
		ps = new PacketSender(socket, this, cm);
		
		pr.start();
		ps.start();

	}



	public DatagramSocket getSocket() {
		return socket;

	}

	public int getPort() {
		return port;
	}

	public String getZoneName() {
		return zoneName;
	}

	public PacketSender getPacketSender() {
		return ps;
	}

}
