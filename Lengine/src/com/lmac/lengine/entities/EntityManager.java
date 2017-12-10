package com.lmac.lengine.entities;

import java.util.Vector;

import org.newdawn.slick.Graphics;

import com.lmac.lengine.entities.player.PlayerMP;
import com.lmac.lengine.utils.Log;

public class EntityManager {

	public Vector<Entity> entityList;
	public Vector<PlayerMP> playerList;
	

	public EntityManager() {

		entityList = new Vector<Entity>();
		playerList = new Vector<PlayerMP>();

	}

	public void update() {

		for (int i = 0; i < entityList.size(); i++) {
			entityList.get(i).update();
		}
		for (int k = 0; k < playerList.size(); k++) {
			playerList.get(k).update();
		}

	}

	public void render(Graphics g) {

		for (int i = 0; i < entityList.size(); i++) {
			entityList.get(i).render(g);
		}
		for (int k = 0; k < playerList.size(); k++) {
			playerList.get(k).render(g);
		}
	}

	public void addMPPlayer(PlayerMP e) {
		Log.print("Added a MP Player to the Entity List");
		playerList.add(e);
	}

	public void removeMPPlayer(PlayerMP e) {
		playerList.remove(e);
	}

	public void removeEntity(Entity e) {

		entityList.remove(e);

	}

	public void addEntity(Entity e) {
		Log.print("Added new Player to Entity Manager");
		entityList.add(e);
		
	}

	public PlayerMP getPlayerMPByID(int id) {
		PlayerMP p = null;

		Log.print("Getting Player By MP ID.  SIZE OF MPS = " + playerList.size());
		
		for (int k = 0; k < playerList.size(); k++) {
			if (playerList.get(k).getPlayerID() == id) {
				Log.print("ITS ME!!!");
				p = playerList.get(k);
			}else{
				Log.print("GetPLayerBYMP ID showed up blank :(");
			}

		}
		return p;
	}
}
