package com.lmac.lengine.ui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class MenuButton extends LButton{

	
	public MenuButton(int xLoc, int yLoc, int height, int width) {
		super(xLoc, yLoc, height, width);
		
	}

	@Override
	public void update(GameContainer gc, Rectangle cursor) {
		if (this.getBounds().intersects(cursor)) {
			if (gc.getInput().isMousePressed(0)) {
				action();
			}
		}
		
	}

}
