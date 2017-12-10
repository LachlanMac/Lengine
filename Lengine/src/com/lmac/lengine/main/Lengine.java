package com.lmac.lengine.main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lengine.config.Options;
import com.lmac.lengine.net.Connection;
import com.lmac.lengine.states.*;


public class Lengine extends StateBasedGame {

	
	Connection conn;
	
	
	public Lengine(String name) {
		super(name);
		this.conn = new Connection(Options.getInetAddress(), Options.gameServerPort);
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.addState(new MenuState(conn));
		this.addState(new GameState(conn));
	}

}
