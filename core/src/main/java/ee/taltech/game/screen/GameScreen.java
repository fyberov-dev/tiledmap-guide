package ee.taltech.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import ee.taltech.game.util.Constants;
import ee.taltech.game.util.TiledMapLoader;

public class GameScreen extends ScreenAdapter {

    private OrthogonalTiledMapRenderer mapRenderer;
    private OrthographicCamera camera;

    private float worldWidth;
    private float worldHeight;

    @Override
    public void show() {
        camera = new OrthographicCamera();
        mapRenderer = new TiledMapLoader("tiled/map.tmx").setupMap();
        worldWidth = (int) mapRenderer.getMap().getProperties().get("width") * Constants.PPM;
        worldHeight = (int) mapRenderer.getMap().getProperties().get("height") * Constants.PPM;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        mapRenderer.setView(camera);
        mapRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, worldWidth, worldHeight);
    }
}
