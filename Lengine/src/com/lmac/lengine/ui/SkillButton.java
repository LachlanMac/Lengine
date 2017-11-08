package com.lmac.lengine.ui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import com.lmac.lengine.skills.Skill;


public class SkillButton extends LButton {
	boolean highlighted = false;
	Skill skill = null;
	int button;
	Rectangle highlight;
	public SkillButton(int xLoc, int yLoc, int height, int width, Skill skill, int button) {
		super(xLoc, yLoc, height, width);
		highlight = bounds;
		this.skill = skill;
		this.button = button;
	}

	
	public void render(Graphics g) {
		if (skill != null) {
			g.setColor(Color.pink);
		} else {
			g.setColor(Color.white);
		}
		g.draw(bounds);
		if(highlighted){
			g.setColor(Color.blue);
			g.draw(highlight);
		}
	}

	@Override
	public void action() {
		if (skill != null) {
			skill.doSkill();
		}

	}
	
	public void setSkill(Skill skill){
		this.skill = skill;
	}


	@Override
	public void update(GameContainer gc, Rectangle cursor) {
		if (this.getBounds().intersects(cursor)) {
			if (gc.getInput().isMousePressed(0)) {
				action();
			}
		}
		if(gc.getInput().isKeyDown(button + 1)){
			action();
		}
	}
	
	public void setHighlighted(boolean highlight){	
		this.highlighted = highlight;
	
	}




}
