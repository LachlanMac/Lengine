package com.lmac.lengine.ui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.TextField;

import com.lmac.lengine.assets.UILoader;
import com.lmac.lengine.config.Options;
import com.lmac.lengine.net.LoginConnection;
import com.lmac.lengine.states.MenuState;
import com.lmac.lengine.utils.Log;

public class MenuUI implements UI {

	GameContainer input;
	TextField userField, passwordField;
	MenuButton login;
	InputField userName, password;
	
	public MenuUI(GameContainer gc) {
		this.input = gc;
		userName = new InputField(300, 300, 200, 40, gc, UILoader.menuFont);
		password = new InputField(300, 360, 200, 40, gc, UILoader.menuFont);
		init();
		
	}

	public void init() {
		configureButtons();
		
		
	
		
	}

	@Override
	public void update(GameContainer gc) {
		Rectangle cursor = new Rectangle(gc.getInput().getMouseX(), gc.getInput().getMouseY(), 1, 1);
		login.update(gc, cursor);
		userName.update(gc, cursor);
		password.update(gc, cursor);

	}

	@Override
	public void render(Graphics g) {
		login.render(g);
		userName.render(g);
		password.render(g);
		
		
		

	}
	
	public void configureButtons() {
		login = new MenuButton(300, 400, 200, 200) {
			@Override
			public void action() {
				
				Log.print(userName.getText().trim());
				Log.print(password.getText().trim());
				String usr = userName.getText().trim();
				String pwd = password.getText().trim();
				LoginConnection lc = new LoginConnection(MenuState.conn);
				lc.login(usr, pwd);
			}

		};
		
	}

}
