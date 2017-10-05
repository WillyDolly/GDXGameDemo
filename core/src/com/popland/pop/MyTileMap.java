package com.popland.pop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created by hai on 19/07/2017.
 */

public class MyTileMap extends ApplicationAdapter {
    SpriteBatch batch;
    TiledMap tileMap;
    //OrthogonalTiledMapRenderer renderer;
    IsometricTiledMapRenderer renderer;
    OrthographicCamera camera;
    @Override
    public void create () {// initialize resources
        batch = new SpriteBatch();
        tileMap = new TmxMapLoader().load("IsometricMap.tmx");
//      renderer = new OrthogonalTiledMapRenderer(tileMap);
        renderer = new IsometricTiledMapRenderer(tileMap);
       camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }

    @Override
    public void render () {// called 30-80 times when app running
        //clear background with this color
        Gdx.gl.glClearColor(0,1,0,1);//RGBA Alpha Transparent
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        renderer.setView(camera);
        renderer.render();
        batch.end();
    }

    @Override
    public void dispose () {//free up resources
        batch.dispose();
    }
}
