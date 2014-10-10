package com.crashapps.gridmania.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.crashapps.gridmania.GridMania;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title=GridMania.APP_NAME+" v"+GridMania.APP_VERSION;
		config.vSyncEnabled=true;
		config.width=800;
		config.height=600;
		new LwjglApplication(new GridMania(), config);
	}
}
