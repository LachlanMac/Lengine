package com.lmac.lengine.entities.player;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.lmac.lengine.entities.Entity;
import com.lmac.lengine.utils.Log;

public class PlayerMP extends Entity {

	String playerName;
	private int playerID;
	Vector2f loc;
	
	public PlayerMP(float x, float y, int playerID, String playerName) {
		super(x, y);
		loc = new Vector2f(x,y);
		this.playerName = playerName;
	}

	@Override
	public void update() {
		
		
	}
	
	@Override
	public void render(Graphics g) {
		g.draw(new Rectangle(loc.getX(), loc.getY(), 50,50));
		
	}
	
	public int getPlayerID(){
		return playerID;
	}
	
	public void move(float newX, float newY){
		
		loc.set(newX, newY);
		
	}
}
