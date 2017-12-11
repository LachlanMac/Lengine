package com.lmac.sfs.server.packets;

import java.net.DatagramPacket;


import com.lmac.sfs.server.utils.Log;



public class PacketDecoder {
	

	
	public PacketDecoder() {

	}

	public void readPacket(DatagramPacket packet) {
		
		String data = new String(packet.getData());
		Log.print("Received " + data);
		String packetCode = data.substring(0, 3);
		Log.print("PACKET CODE : " + packetCode);
		
		switch (packetCode) {
		case "#05":
			parseMovePacket(data);
			break;
		case "#02":
			parseZoneSwitchPacket(data);
			break;
		case "#99":
			parseHeartBeatPacket(data);
			break;
		
		default:
			
			break;
		}
	}
	
	public void parseMovePacket(String data){
		
		String[] decode = data.split("=");

		int playerID = Integer.parseInt(decode[1]);
		
		
		float xCoord = Float.parseFloat(decode[2]);
		float yCoord = Float.parseFloat(decode[3]);
		
		
		Log.print("Got a move packet " + playerID + " : " + xCoord + ", " + yCoord);
		//PlayerMP p = em.getPlayerByID(playerID);

		//p.setLoc(xCoord, yCoord);

		//String moveP = "05=" + playerID + "=" + xCoord + "=" + yCoord;

		//send.addPacket(new MovePacket(moveP.getBytes()));
		
	}
	
	public void parseHeartBeatPacket(String data){
		
		
		
		
	}
	public void parseZoneSwitchPacket(String data){
		
		
	}

}
