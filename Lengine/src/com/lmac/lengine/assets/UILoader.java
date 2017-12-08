package com.lmac.lengine.assets;
import java.awt.Font;

import org.newdawn.slick.TrueTypeFont;

import com.lmac.lengine.ui.LFont;
public class UILoader extends AssetLoader {
	
	//public static TrueTypeFont menuFont;
	//public static Font awtMenuFont;
	public static LFont menuFont;
	
	@Override
	public void init() {
		
		menuFont = new LFont("Eras Bold ITC", Font.PLAIN, 24, true);
		
		
		//awtMenuFont = new Font("Eras Bold ITC", Font.PLAIN, 24);
		//menuFont = new TrueTypeFont(awtMenuFont, false);
		
	}

}
