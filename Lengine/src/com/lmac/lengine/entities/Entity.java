package com.lmac.lengine.entities;

import org.newdawn.slick.Graphics;



public abstract class Entity {

	protected float x, y;

	public Entity(float x, float y) {

		this.x = x;
		this.y = y;

	}
	
	public abstract void update();
	
	
	public abstract void render(Graphics g);
	
}
