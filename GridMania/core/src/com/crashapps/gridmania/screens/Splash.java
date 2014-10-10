package com.crashapps.gridmania.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.crashapps.gridmania.GridMania;
import com.crashapps.gridmania.tween.SpriteAccessor;

public class Splash implements Screen  {

	private SpriteBatch batch;
	private Sprite splash;
	private TweenManager tweenManager;
	
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		tweenManager.update(delta);
		
		//batch.setProjectionMatrix(GridMania.camera.combined);
		batch.begin();
		
		splash.draw(batch);
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		batch=new SpriteBatch();
		tweenManager = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		
		Texture splashTexture=new Texture(Gdx.files.internal("img/splashlogo.png"));
		splash = new Sprite(splashTexture);
		
		splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		Tween.set(splash, SpriteAccessor.ALPHA).target(0).start(tweenManager);
		Tween.to(splash, SpriteAccessor.ALPHA, 2).target(1).repeatYoyo(1, 1).setCallback(new TweenCallback() {
			
			@Override
			public void onEvent(int arg0, BaseTween<?> arg1) {
				((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenu());
				
			}
		}).start(tweenManager);
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		splash.getTexture().dispose();
		
	}

}
