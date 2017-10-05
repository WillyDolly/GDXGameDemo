package com.popland.pop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by hai on 16/05/2017.
 */

public class Sound_Music extends ApplicationAdapter implements InputProcessor{
    SpriteBatch batch;
    Sound gameover;
    Music thislove;

    @Override
    public void create() {
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);
        gameover = Gdx.audio.newSound(Gdx.files.internal("sounds/gameover1.wav"));// sound effect
        thislove = Gdx.audio.newMusic(Gdx.files.internal("sounds/thislove.mp3"));// songs
    }

    @Override
    public void render() {
        Gdx.gl20.glClearColor(1,1,1,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        long soundId = gameover.play();
//        gameover.setVolume(soundId,1f); // range 0-1
//        gameover.setPitch(soundId,2f);  // range 0.5 - 2(high - low)

        thislove.play();
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        thislove.pause();
        return true;
    }

    @Override
    public void dispose() {
        batch.dispose();
        gameover.dispose();
        thislove.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }


    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
