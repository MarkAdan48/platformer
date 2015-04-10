package com.adanm.platformer;

import com.adanm.platformer.Controller.GameScreen;
import com.badlogic.gdx.Game;

public class Platformer extends Game {
    @Override
    public void create() {

        setScreen(new GameScreen());
    }
}


