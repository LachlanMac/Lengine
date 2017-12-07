package com.lmac.lengine.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lengine.skills.*;
import com.lmac.lengine.ui.*;


public class MenuState extends BasicGameState {
	
	TextField user;
	
	
	@Override
	public void init(GameContainer gc, StateBasedGame arg1) throws SlickException {
		user = new TextField(gc, null, 0, 0, 0, 0);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		
	
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		
	
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
