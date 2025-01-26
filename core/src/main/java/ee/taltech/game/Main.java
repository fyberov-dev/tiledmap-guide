package ee.taltech.game;

import com.badlogic.gdx.Game;
import ee.taltech.game.screen.GameScreen;

public class Main extends Game {

    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}
