package com.popland.pop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by hai on 15/05/2017.
 */

public class UserInput extends ApplicationAdapter implements InputProcessor{
     SpriteBatch batch;
     BitmapFont font;
     int  screenWidth, screenHeight;
     String message = "Touch me";

    @Override
    public void create() {
        batch = new SpriteBatch();
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        font = new BitmapFont();
        font.setColor(Color.CYAN);
        font.getData().setScale(5);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {
        Gdx.gl20.glClearColor(1,1,1,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //GlyphLayout setText & getTextSize
        GlyphLayout layout = new GlyphLayout();
        layout.setText(font,message);
        //place Text in the screen's center(Text's origin: bottom left)
        float x = screenWidth/2 - layout.width/2;
        float y = screenHeight/2 +layout.height/2;

        batch.begin();
        font.draw(batch,message,x,y);// follow Y - up
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
//touchEvent get coordinates based on Y-down
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        message = "Touch down at"+screenX +" ; "+screenY;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        message = "Touch up at"+screenX +" ; "+screenY;
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
       message = "Dragging at"+screenX +" ; "+screenY;// finger touch: this called before touchDown
      return false;
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
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
