package com.lmac.lengine.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.LinkedList;
import java.util.Queue;

import org.newdawn.slick.state.StateBasedGame;

public class ServerSender extends Thread {

	private Queue<Packet> sendQueue;
	private int port;
	private DatagramSocket socket = null;
	private InetAddress address;
	private byte[] inData, outData;
	StateBasedGame game;

	public ServerSender(Connection conn, StateBasedGame game) {
		this.socket = conn.getSocket();
		this.port = conn.getPort();
		this.address = conn.getAddress();
		this.sendQueue = new LinkedList<Packet>();
	}

	@Override
	public void run() {

		while (true) {

			if (sendQueue.size() > 0) {

				DatagramPacket out = sendQueue.poll().getPacket();
				
				try {
					socket.send(out);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
			}

		}

	}

	public void addPacket(Packet p) {

		sendQueue.add(p);

	}

}
