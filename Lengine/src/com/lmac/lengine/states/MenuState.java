package com.lmac.lengine.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lengine.skills.*;
import com.lmac.lengine.ui.*;


public class MenuState extends BasicGameState {
	
	MenuButton b;
	Hotbar hb;
	@Override
	public void init(GameContainer gc, StateBasedGame arg1) throws SlickException {
		b = new MenuButton(100,100, 150, 120);
		hb = new Hotbar(gc);
		hb.addSkill(new Punch(), 4);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		b.render(g);
		hb.render(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		Rectangle cursor = new Rectangle(gc.getInput().getMouseX(), gc.getInput().getMouseY(), 1, 1);
		b.update(gc, cursor);
		hb.update(gc, cursor);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
