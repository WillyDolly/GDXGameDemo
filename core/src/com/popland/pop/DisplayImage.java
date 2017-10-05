package com.popland.pop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by hai on 13/05/2017.
 */

public class DisplayImage extends ApplicationAdapter {
  private SpriteBatch batch;
  private Texture texture;
  private Sprite sprite;
    @Override
    public void create() {
       batch = new SpriteBatch();
        texture = new Texture("speedme.png");
       sprite = new Sprite(texture);// get Image's graphics and return Sprite object to create effects
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0,0,1,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }
}
