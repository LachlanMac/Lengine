package com.lmac.lengine.ui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import com.lmac.lengine.utils.Log;

public class GameUI implements UI {
	
	Hotbar hotbar;
	GameContainer input;
	
	public GameUI(GameContainer gc){
		this.input = gc;
		init();
		Log.print("INIT GAME");
	}

	@Override
	public void update(GameContainer gc) {
		Rectangle cursor = new Rectangle(gc.getInput().getMouseX(), gc.getInput().getMouseY(), 1, 1);
		hotbar.update(cursor);
		
	}

	@Override
	public void render(Graphics g) {
		hotbar.render(g);
		
	}

	@Override
	public void init() {
		hotbar = new Hotbar(input);
		
	}
	
	public Hotbar getHotBar(){
		return hotbar;
	}

}
