package com.popland.pop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by hai on 14/05/2017.
 */

public class MyAnimation extends ApplicationAdapter {
    SpriteBatch batch;
    TextureAtlas textureAtlas;// set of same sized images to run animation
    Animation animation;
    float timePassed = 0;

    @Override
    public void create() {
         batch = new SpriteBatch();
        textureAtlas = new TextureAtlas(Gdx.files.internal("riding.atlas"));
        animation = new Animation(1/10f, textureAtlas.getRegions());//(second/frame, xy reader)
    }

    @Override
    public void render() {
        Gdx.gl20.glClearColor(1,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        timePassed += Gdx.graphics.getDeltaTime();// to know what image is showing in the sequence
        batch.draw((TextureRegion) animation.getKeyFrame(timePassed,true),100,300);// true -> loop
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        textureAtlas.dispose();
    }
}
