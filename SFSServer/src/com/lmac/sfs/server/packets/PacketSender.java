package com.lmac.sfs.server.packets;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

import com.lmac.sfs.server.ServerZone;
import com.lmac.sfs.server.net.ConnectionMP;
import com.lmac.sfs.server.net.ConnectionManager;
import com.lmac.sfs.server.utils.Log;

public class PacketSender extends Thread {

	private DatagramSocket sender;
	private ServerZone zone;
	private LinkedBlockingQueue<Packet> sendQueue;
	private ConnectionManager cm;
	private Vector<ConnectionMP> playerList;

	public PacketSender(DatagramSocket sender, ServerZone zone, ConnectionManager cm) {

		this.sender = sender;
		this.zone = zone;
		this.cm = cm;
		sendQueue = new LinkedBlockingQueue<Packet>();

	}

	public void run() {
		
		Log.print("Starting PacketSender for Zone: " + zone.getZoneName() + "[THREAD:" + this.getId() + ":" + this.getName() + "]");

		while (true) {
			
			// server sleeps if no one is connected
			if (cm.getPlayerCount() > 0) {
				// if there are packets queued to send
				if (!sendQueue.isEmpty()) {

				}

			}

		}

	}

	public void sendPackets() {

		playerList = cm.getPlayerList();
		
		for (int i = 0; i < playerList.size(); i++) {
			
			DatagramPacket out = sendQueue.peek().encodePacket(playerList.get(i).getAddress(), playerList.get(i).getPort());
			
			
		}

	}

	public void addPacket(Packet p) {

		sendQueue.add(p);

	}

}
