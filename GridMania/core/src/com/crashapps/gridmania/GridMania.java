package com.crashapps.gridmania;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.crashapps.gridmania.screens.Splash;

public class GridMania extends Game {
	
	public static final String APP_NAME="GridMania", APP_VERSION="0.1";
	
	public static final int VIRTUAL_WIDTH = 480;
    public static final int VIRTUAL_HEIGHT = 320;
    private static final float ASPECT_RATIO =
        (float)VIRTUAL_WIDTH/(float)VIRTUAL_HEIGHT;

    public static Camera camera;
    public static SpriteBatch globalBatch;
    private Rectangle viewport;
	
	
	@Override
	public void create () {
		Gdx.app.log(APP_NAME, "create()");
		
		camera = camera = new PerspectiveCamera();
		setScreen(new Splash());
	}
	
	@Override
	public void dispose() {
		Gdx.app.log(APP_NAME, "dispose()");
		super.dispose();
	}

	@Override
	public void render () {
		camera.update();
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
		
	}
	
	@Override
	public void resume() {
		Gdx.app.log(APP_NAME, "resume()");
		super.resume();
	}
	
	@Override
	public void pause() {
		Gdx.app.log(APP_NAME, "pause()");
		super.pause();
	}
	
	@Override
	public void resize(int width, int height) {
		Gdx.app.log(APP_NAME, "resize()");
		super.resize(width, height);	
		
	}
	
	
	

	
}
