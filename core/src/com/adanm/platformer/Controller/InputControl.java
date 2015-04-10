package com.adanm.platformer.Controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.awt.Rectangle;

public class InputControl {
    public String action;
    public Vector2 position;

    private TextureRegion textureRegion;
    private float width;
    private float height;

    public InputControl(Vector2 position, TextureRegion textureRegion, String action) {
        this.textureRegion = textureRegion;
        this.position = position;
        this.action = action;

        width = textureRegion.getRegionWidth();
        height = textureRegion.getRegionHeight();
    }

    public void draw(Batch spriteBatch) {
        spriteBatch.draw(textureRegion, position.x, position.y, width * levelController.UNIT_SCALE, height * levelController.UNIT_SCALE);
    }

    public com.badlogic.gdx.math.Rectangle getRoundingBox() {
        return new com.badlogic.gdx.math.Rectangle(position.x / levelController.UNIT_SCALE * CameraController.widthScale, position.y / levelController.UNIT_SCALE * CameraController.heightScale, width * CameraController.widthScale, height * CameraController.heightScale);

    }

}
