package com.lmac.sfs.server;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import com.lmac.sfs.server.utils.Log;

public class SFSLauncher extends StateBasedGame {

	public SFSLauncher(String name) {
		super(name);
		
	}

	
	public static void main(String[] args){
		AppGameContainer server;
		try{
			
			server = new AppGameContainer(new SFSLauncher("SFS Server [dev-01]"));
			server.setDisplayMode(1280, 800, false);
			server.setTargetFrameRate(60);
			server.setMaximumLogicUpdateInterval(60);
			server.setVSync(true);
			server.setUpdateOnlyWhenVisible(false);
			server.setAlwaysRender(true);
			
			server.start();
			
		}catch(SlickException e){
			
			Log.error("Error Starting Server");
			
		}
		
		
		
		
	}
	
	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		
		this.addState(new Server());
		
	}

	
	
	
	
}
