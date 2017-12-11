package com.lmac.sfs.server.net;

import java.util.Vector;

import com.lmac.sfs.server.utils.Log;

//this class will track all of the connections
public class ConnectionManager {

	private Vector<ConnectionMP> playerList;

	int counter = 0;

	public ConnectionManager() {

		playerList = new Vector<ConnectionMP>();

	}

	public void update() {
		counter++;
		// check every second
		if (counter > 60) {

			for (int i = 0; i < playerList.size(); i++) {
				playerList.get(i).update();
				if (playerList.get(i).getConnectionStatus() == false) {
					removeConnection(playerList.get(i));
					Log.print("Player has been DC'd");
				}

			}

			counter = 0;
		}
	}

	public void addConnection(ConnectionMP player) {

		player.connect();

		playerList.add(player);

	}

	public void removeConnection(ConnectionMP player) {

		player.disconnect();

		playerList.remove(player);

	}

	public Vector<ConnectionMP> getPlayerList() {

		return playerList;

	}

	public int getPlayerCount() {

		return playerList.size();

	}

	public ConnectionMP getPlayerByID(int id) {

		ConnectionMP player = null;

		for (int i = 0; i < playerList.size(); i++) {
			if (id == playerList.get(i).getPlayerID()) {
				player = playerList.get(i);
			}

		}
		return player;

	}
}
