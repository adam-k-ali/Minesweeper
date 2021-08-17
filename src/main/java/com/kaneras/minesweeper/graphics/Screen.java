package com.kaneras.minesweeper.graphics;

import com.kaneras.minesweeper.Properties;
import com.kaneras.minesweeper.logic.Game;
import com.kaneras.minesweeper.logic.Tile;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


/**
 * A class to handle all drawing to the screen.
 */
public class Screen {
    private static Canvas canvas;
    private static GraphicsContext graphics;

    private static Image tileImage;

    public static void init() {
        canvas = new Canvas(Properties.MIN_WIDTH, Properties.MIN_HEIGHT);
        canvas.setFocusTraversable(true);

        graphics = canvas.getGraphicsContext2D();

        tileImage = new Image(Screen.class.getResourceAsStream("/tile.png"));

        drawAllTiles();
    }

    public static Canvas getCanvas() {
        return canvas;
    }

    public static void drawAllTiles() {
        for (Tile[] tiles : Game.getAllTiles()) {
            for (Tile tile : tiles) {
                drawTile(tile);
            }
        }
    }

    /**
     * Draw a tile to the screen
     * @param tile The tile component to draw to the screen
     */
    private static void drawTile(Tile tile) {
        graphics.drawImage(tileImage, tile.getPosition().getX() * getTileSize(), tile.getPosition().getY() * getTileSize(), getTileSize(), getTileSize());
    }

    private static int getTileSize() {
        return (int) (graphics.getCanvas().getWidth() / Game.getGridSize());
    }

}
