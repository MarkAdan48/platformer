package com.adanm.platformer.Controller;


import com.adanm.platformer.Model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;


public class GameScreen implements Screen {

    public OrthographicCamera camera;

    public Player player;

    public GameScreen() {
        levelController.initializeController();
        CameraController.initializeController();
        playerController.initializeController();
        InputController.initializeController();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.76f, 0.88f, 0.93f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        CameraController.update();
        levelController.update();
        playerController.update(delta);

        camera.update();
        levelController.update();

        player.update(delta);

        levelController.draw();

    }

    @Override
    public void resize(int width, int height) {
        CameraController.resize(width, height);
    }


    @Override
    public void show() {

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
