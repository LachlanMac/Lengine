package com.lmac.sfs.server;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.lmac.sfs.server.config.Options;
import com.lmac.sfs.server.net.ConnectionManager;
import com.lmac.sfs.server.utils.Log;

public class Server extends BasicGameState {

	ConnectionManager cm;
	ServerZone zone1;
	
	@Override
	public void init(GameContainer gc, StateBasedGame server) throws SlickException {
		
		Log.print("Init server");
		
		cm = new ConnectionManager();
		zone1 = new ServerZone(Options.zonePort, "Zone One", cm);
		zone1.init();
	
	}

	@Override
	public void render(GameContainer gc, StateBasedGame server, Graphics g) throws SlickException {

	}

	@Override
	public void update(GameContainer gc, StateBasedGame server, int delta) throws SlickException {
		cm.update();
	}

	@Override
	public int getID() {

		return 0;
	}

}
