package com.crashapps.gridmania.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.crashapps.gridmania.GridMania;

public class MainMenu implements Screen {

	
	private Stage stage; //done
	private TextureAtlas atlas; //done
	private Skin skin; //done
	private BitmapFont fontWhite, fontBlack; //done
	private Table table; //done
	private TextButton buttonExit, buttonStart, buttonLevels;
	private Label heading;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, false);
	}

	@Override
	public void show() {		
		
		
		
		fontWhite=new BitmapFont(Gdx.files.internal("font/white.fnt"),false);
		fontBlack=new BitmapFont(Gdx.files.internal("font/black.fnt"),false);
		
		
		stage=new Stage(new StretchViewport(GridMania.VIRTUAL_WIDTH, GridMania.VIRTUAL_HEIGHT));//,GridMania.camera));

		Gdx.input.setInputProcessor(stage);
		
		atlas=new TextureAtlas("ui/button.pack");
		skin = new Skin(atlas);
		
		table=new Table(skin);
		table.setBounds(0, 0, GridMania.VIRTUAL_WIDTH, GridMania.VIRTUAL_HEIGHT);
		
		//Creting buttons
		TextButtonStyle textButtonStyle=new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button.up");
		textButtonStyle.down = skin.getDrawable("button.down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = fontBlack;
		
		buttonExit=new TextButton("EXIT", textButtonStyle);
		buttonExit.pad(20);
		
		//Creating header
		LabelStyle headingStyle=new LabelStyle(fontWhite,Color.WHITE);
		heading=new Label("GridMania", headingStyle);

		
		//poniendo todo junto
		table.add(heading);
		table.row();
		table.add(buttonExit);
		stage.addActor(table);

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

}
