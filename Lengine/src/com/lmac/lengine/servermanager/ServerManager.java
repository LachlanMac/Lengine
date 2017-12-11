package com.lmac.lengine.servermanager;

import java.util.Vector;

import com.lmac.lengine.entities.EntityManager;
import com.lmac.lengine.entities.player.PlayerMP;

public class ServerManager {

	private EntityManager em;
	private Vector<PlayerMP> playerList;
	
	
	public ServerManager(EntityManager em) {
		this.em = em;
		this.playerList = em.getPlayerList();
	}
	
	
	
	public void updatePlayerPosition(int pid, float x, float y, float velocity) {
		
		PlayerMP p = em.getPlayerMPByID(pid);
		p.move(x, y);
		p.setVelocity(velocity);
		
		
	}
	public void updateCreaturePosition() {
		
	}
	
	
	
}
