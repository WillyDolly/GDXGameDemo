package com.popland.pop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javafx.scene.paint.Color;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;// class to draw & display things
	private BitmapFont font;
	
	@Override
	public void create () {// initialize resources
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor( com.badlogic.gdx.graphics.Color.BLUE);
		font.getData().setScale(5);// font about 15 pixels by default = a dot
	}

	@Override
	public void render () {// called 30-80 times when app running
		//clear background with this color
		Gdx.gl.glClearColor(0,1,0,1);//RGBA Alpha Transparent
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		font.draw(batch,"most crucial thing is dreams",100,200);
		batch.end();
	}
	
	@Override
	public void dispose () {//free up resources
		batch.dispose();
		font.dispose();
	}
}
