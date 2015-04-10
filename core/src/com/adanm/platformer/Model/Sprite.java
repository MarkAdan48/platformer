package com.adanm.platformer.Model;

import com.adanm.platformer.Controller.levelController;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import java.util.HashMap;

public class Sprite {

    public Body physicsBody;
    public Vector2 position;
    public SpriteSheet spriteSheet;
    public String currentAnimations;

    public float width;
    public float height;

    private float stateTime;
    protected HashMap<String, Animation> animations;

    public Sprite(Vector2 position, int width, int height, String sheetPath) {
        this.position = position;
        animations = new HashMap<String, Animation>();

        this.width = width * levelController.UNIT_SCALE;
        this.height = height * levelController.UNIT_SCALE;

        spriteSheet = new SpriteSheet(sheetPath, width, height);
        currentAnimations = "walk";
        stateTime = 0f;
    }

    public void draw(Batch spriteBatch) {
        spriteBatch.draw(animations.get(currentAnimations).getKeyFrame(stateTime, true), position.x, position.y, width, height);
    }

    public void update(float deltaTime) {
        stateTime += deltaTime;
        position.x += deltaTime;
    }

}
