package com.adanm.platformer.Controller;

import com.adanm.platformer.Model.SpriteSheet;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class InputController {
    private static SpriteSheet spriteSheet;
    private static InputControl left;

    public static void initializeController() {
        spriteSheet = new SpriteSheet("img/touch-controls.png", 80, 80);
        left = new InputControl(new Vector2(0, 0), spriteSheet.spriteFrames[0], "left");
        Gdx.input.setInputProcessor(createInputAdapter());
    }

    public static void draw(Batch spriteBatch) {
        spriteBatch.begin();
        left.draw(spriteBatch);
        spriteBatch.end();
    }

    private static InputAdapter createInputAdapter() {
        return new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                if (left.getRoundingBox().contains(screenX, Gdx.graphics.getHeight() - screenY)) {
                    playerController.movementAction = "right";
                }
                return true;
            }


            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {

                playerController.movementAction = "";
                return true;
            }

        };

    }

}
