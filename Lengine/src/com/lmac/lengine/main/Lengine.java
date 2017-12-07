package com.lmac.lengine.main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lengine.states.*;


public class Lengine extends StateBasedGame {

	public Lengine(String name) {
		super(name);
		
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.addState(new MenuState());
		//this.addState(new GameState());
	}

}
