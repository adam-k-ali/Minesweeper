package com.kaneras.minesweeper.logic;

import com.kaneras.minesweeper.Properties;
import javafx.scene.canvas.Canvas;

import java.awt.*;
import java.util.Random;

public class Game {
    private static Canvas canvas;
    private static Tile[][] tiles;
    private static Random random = new Random();

    public static void init() {
        generateTiles();
        calculateTileValues();

        canvas = new Canvas(Properties.MIN_WIDTH, Properties.MIN_HEIGHT);
        canvas.setFocusTraversable(true);
        canvas.setOnMouseClicked(InputHandler::handleMouseClick);
    }

    public static Canvas getCanvas() {
        return canvas;
    }


    public static Tile[][] getAllTiles() {
        if (tiles == null)
            throw new NullPointerException("Game hasn't been initialized yet.");
        return Game.tiles;
    }

    /**
     * Generate all tiles for the game.
     */
    private static void generateTiles() {
        tiles = new Tile[Properties.GRID_SIZE][Properties.GRID_SIZE];
        for (int x = 0; x < Properties.GRID_SIZE; x++) {
            for (int y = 0; y < Properties.GRID_SIZE; y++) {
                tiles[x][y] = new Tile(new Point(x, y), random.nextDouble() <= Properties.MINE_DENSITY);
            }
        }
    }

    private static void calculateTileValues() {
        for (Tile[] tiles : getAllTiles()) {
            for (Tile tile : tiles) {
                tile.calculateValue();
            }
        }
    }

    public static Tile getTileAtPos(Point point) {
        return tiles[point.x][point.y];
    }

}
