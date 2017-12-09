package com.lmac.lengine.entities.player;

import org.newdawn.slick.Graphics;

import com.lmac.lengine.assets.TextureLoader;
import com.lmac.lengine.entities.Entity;
import com.lmac.lengine.utils.Log;

public class Player extends Entity {

	
	
	
	public Player(float x, float y) {
		super(x, y);
		Log.print("Player at " + x + ", " + y);
	}

	@Override
	public void update() {
		
		
		
	}

	@Override
	public void render(Graphics g) {
	
		g.drawImage(TextureLoader.player, x, y);
		
	}

}
