package com.kaneras.minesweeper.graphics;

import com.kaneras.minesweeper.Properties;
import com.kaneras.minesweeper.logic.Game;
import com.kaneras.minesweeper.logic.InputHandler;
import com.kaneras.minesweeper.logic.Tile;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


/**
 * A class to handle all drawing to the screen.
 */
public class Screen {
    private static GraphicsContext graphics;

    private static Image tileImage;

    public static void init() {
        graphics = Game.getCanvas().getGraphicsContext2D();

        tileImage = new Image(Screen.class.getResourceAsStream("/tile.png"));

        drawAllTiles();
    }

    public static void refresh() {
        graphics.clearRect(0,0, Game.getCanvas().getWidth(), Game.getCanvas().getHeight());
        drawAllTiles();
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
        if (tile.isRevealed()) {
            // Draw fill
            graphics.setFill(Color.LIGHTGRAY);
            graphics.fillRect(tile.getPosition().getX() * getTileSize(), tile.getPosition().getY() * getTileSize(), getTileSize(), getTileSize());

            // Draw border
            graphics.setFill(Color.BLACK);
            graphics.fillRect(tile.getPosition().getX() * getTileSize(), tile.getPosition().getY() * getTileSize(), getTileSize(), Properties.TILE_BORDER); // Top
            graphics.fillRect(tile.getPosition().getX() * getTileSize(), tile.getPosition().getY() * getTileSize(), Properties.TILE_BORDER, getTileSize()); // Left
            graphics.fillRect(tile.getPosition().getX() * getTileSize(), (tile.getPosition().getY() + 1) * getTileSize() - Properties.TILE_BORDER, getTileSize(), Properties.TILE_BORDER); // Bottom
            graphics.fillRect((tile.getPosition().getX() + 1) * getTileSize() - Properties.TILE_BORDER, tile.getPosition().getY() * getTileSize(), Properties.TILE_BORDER, getTileSize()); // Right
        } else {
            graphics.drawImage(tileImage, tile.getPosition().getX() * getTileSize(), tile.getPosition().getY() * getTileSize(), getTileSize(), getTileSize());
        }
    }

    private static int getTileSize() {
        return (int) (graphics.getCanvas().getWidth() / Game.getGridSize());
    }

}
