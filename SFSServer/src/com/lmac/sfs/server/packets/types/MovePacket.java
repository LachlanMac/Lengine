package com.lmac.sfs.server.packets.types;

import java.net.DatagramPacket;
import java.net.InetAddress;

import com.lmac.sfs.server.packets.Packet;

public class MovePacket extends Packet {
	
	public MovePacket(String data) {
		
		super(data);
		
	}

	@Override
	public DatagramPacket encodePacket(InetAddress destinationAddress, int destinationPort) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
