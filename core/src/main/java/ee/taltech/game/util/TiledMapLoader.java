package ee.taltech.game.util;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

public class TiledMapLoader {

    private TiledMap map;

    /**
     * @param path path to the map, starting from /assets folder
     */
    public TiledMapLoader(String path) {
        this.map = new TmxMapLoader().load(path);
    }

    /**
     * Parse objects from specific layer of the TiledMap.
     *
     * @param layer name of the layer to parse
     */
    public TiledMapLoader parseObjectByLayer(String layer) {
        for (MapObject mapObject : map.getLayers().get(layer).getObjects()) { // finding objects from layer by name and iterating
            handleMapObject(mapObject);
        }
        return this;
    }

    /**
     * Parse all objects from all layers of the TiledMap.
     */
    public TiledMapLoader parseAllObjects() {
        for (MapLayer mapLayer : map.getLayers()) { // iterating all layers
            for (MapObject mapObject : mapLayer.getObjects()) { // iterating all objects in current the layer
                handleMapObject(mapObject);
            }
        }
        return this;
    }

    /**
     * Handle object according to its type
     *
     * @param mapObject map object to handle
     */
    public void handleMapObject(MapObject mapObject) {
        switch (mapObject) {
            case RectangleMapObject object -> { // If object is instance of RectangleMapObject
                Rectangle rectangle = object.getRectangle(); // get rectangle from RectangleMapObject
                // ...
            }
            case EllipseMapObject object -> { // If object is instance of EllipseMapObject
                Ellipse ellipse = object.getEllipse(); // get ellipse from EllipseMapObject
                // ...
            }
            case PolygonMapObject object -> { // If object is instance of PolygonMapObject
                Polygon polygon = object.getPolygon(); // get polygon from PolygonMapObject
                // ...
            }
            case TiledMapTileMapObject object -> { // If object is instance of TiledMapTileMapObject
                float x = object.getX();
                float y = object.getY();
                TextureRegion textureRegion = object.getTextureRegion();
                // use variables to draw SpriteBatch
            }
            default -> System.out.println("Some other type");
        }
    }

    /**
     * @return OrthogonalTiledMapRenderer of the TiledMap
     */
    public OrthogonalTiledMapRenderer setupMap() {
        return new OrthogonalTiledMapRenderer(map);
    }
}
