package com.lmac.sfs.server.packets;

import java.net.DatagramPacket;
import java.net.InetAddress;

public abstract class Packet {
	
	
	private String data;

	public Packet(String data) {

		this.data = data;

	}

	public abstract DatagramPacket encodePacket(InetAddress destinationAddress, int destinationPort);

}
