package com.lmac.lengine.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lengine.ui.GameUI;

public class GameState extends BasicGameState {
	
	GameUI gui;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		gui = new GameUI(gc);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		gui.render(g);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		gui.update(gc);		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
