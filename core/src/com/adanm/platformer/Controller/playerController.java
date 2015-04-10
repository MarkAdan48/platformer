package com.adanm.platformer.Controller;


import com.adanm.platformer.Model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class playerController {
    public static Player player;
    public static String movementAction;
    public static String specialAction;

    public static boolean grounded;

    private static final float VELOCITY = 1f;
    private static final float MAX_VELOCITY = 5f;

    public static void initializeController() {

        player = new Player(new Vector2(0, 6), 70, 100, "img/aliens.png");
        movementAction = "";
        specialAction = "";

    }

    public static void update(float deltaTime) {
        handleInput();
        player.update(deltaTime);

    }

    private static void handleInput() {
        Vector2 velocity = player.physicsBody.getLinearVelocity();
        Vector2 position = player.physicsBody.getPosition();

        if (Math.abs(velocity.x) > MAX_VELOCITY) {
            velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
            player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }

        if (movementAction.equalsIgnoreCase("right")) {
           player.physicsBody.applyLinearImpulse(VELOCITY, 0, position.x, position.y, true);
        }

        else if (movementAction.equalsIgnoreCase("left")) {
            player.physicsBody.applyLinearImpulse(VELOCITY, 0, position.x, position.y, true);
        }

    }
}
