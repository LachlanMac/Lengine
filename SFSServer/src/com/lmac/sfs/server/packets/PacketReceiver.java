package com.lmac.sfs.server.packets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import com.lmac.sfs.server.ServerZone;
import com.lmac.sfs.server.net.ConnectionManager;
import com.lmac.sfs.server.utils.Log;

public class PacketReceiver extends Thread {

	ServerZone zone;
	DatagramSocket receiver;
	PacketDecoder decoder;
	ConnectionManager cm;
	
	public PacketReceiver(DatagramSocket receiver, ServerZone zone, ConnectionManager cm) {
		this.zone = zone;
		this.receiver = receiver;
		this.decoder = new PacketDecoder();
		this.cm = cm;
	}

	public void run() {

		DatagramPacket inPacket;
		byte[] data;
		
		Log.print("Starting PacketReceiver for Zone: " + zone.getZoneName() + "[THREAD:" + this.getId() + ":" + this.getName() + "]");
		while (true) {

			data = new byte[256];
			inPacket = new DatagramPacket(data, data.length);

			try {
				Log.print("Waiting for Packet");
				receiver.receive(inPacket);
				Log.print("Recieved Packet");
				decoder.readPacket(inPacket);
				
				
			} catch (IOException e) {
				Log.error("Error Receving from [" + zone.getZoneName() + ":"+ zone.getPort() + "]" );
			}

		}

	}

}
