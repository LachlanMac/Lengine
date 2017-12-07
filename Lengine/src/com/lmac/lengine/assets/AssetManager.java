package com.lmac.lengine.assets;

public class AssetManager {
	
	TextureLoader tl;
	public AssetManager() {
		tl = new TextureLoader();
		init();
	}
	
	public void init(){
		tl.init();
	}
	
	
}
