package com.lmac.lengine.states;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lengine.config.Options;
import com.lmac.lengine.entities.player.Player;
import com.lmac.lengine.net.Connection;
import com.lmac.lengine.net.MovePacket;
import com.lmac.lengine.net.ServerReceiver;
import com.lmac.lengine.net.ServerSender;
import com.lmac.lengine.ui.GameUI;
import com.lmac.lengine.utils.Log;

public class GameState extends BasicGameState {

	Player p;
	
	GameUI gui;
	Connection serverConn;
	ServerReceiver receiver;
	ServerSender sender;
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		
		Log.print("Init GAMESTATE");
		
		
		
	}
	@Override
	public void enter(GameContainer gc, StateBasedGame game){
		Log.print("Entering Game State: 0");
		gui = new GameUI(gc);
		
		try {
			serverConn = new Connection(InetAddress.getByName(Options.serverAddress), Options.gameServerPort);
			receiver = new ServerReceiver(serverConn, game);
			
			sender = new ServerSender(serverConn, game);
			
			sender.start();
			
			
			//receiver.sendTest();
			
			byte[] hi = "HELLO".getBytes();
			
			sender.addPacket(new MovePacket(hi));
		
			
			p = new Player(200,300);
			
			
			
		} catch (UnknownHostException e) {

			e.printStackTrace();
		}
		
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		gui.render(g);
		p.render(g);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		gui.update(gc);		
		p.update();
	}

	@Override
	public int getID() {
		return 1;
	}

}
