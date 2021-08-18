package com.kaneras.minesweeper.logic;

import com.kaneras.minesweeper.Properties;
import com.kaneras.minesweeper.graphics.Screen;
import javafx.scene.canvas.Canvas;

import java.util.Random;

public class Game {
    private static Canvas canvas;
    private static Tile[][] tiles;
    private static Random random = new Random();
    private static boolean started = false;

    public static void init() {
        generateBlankTiles();

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
     * Generate blank tile grid for game initialization.
     * Tiles will not have values and no mines will be placed.
     */
    private static void generateBlankTiles() {
        tiles = new Tile[Properties.GRID_SIZE][Properties.GRID_SIZE];
        for (int x = 0; x < Properties.GRID_SIZE; x++) {
            for (int y = 0; y < Properties.GRID_SIZE; y++) {
                tiles[x][y] = new Tile(x, y);
            }
        }
    }

    /**
     * Place all mines and calculate tile values
     * @param xStart The x-coordinate of the starting tile
     * @param yStart The y-coordinate of the starting tile
     */
    public static void startGame(int xStart, int yStart) {
        for (int x = 0; x < Properties.GRID_SIZE; x++) {
            for (int y = 0; y < Properties.GRID_SIZE; y++) {
                if (!isNextTo(x, y, xStart, yStart) && random.nextDouble() <= Properties.MINE_DENSITY)  {
                    // Make tile a mine
                    getTileAtPos(x, y).makeMine();
                    Screen.refresh();
                } else {
                    // Normal tile.
                    getTileAtPos(x, y).calculateValue();
                    Screen.refresh();
                }
            }
        }
        calculateTileValues();
        started = true;
    }

    /**
     * @return If the game has been started yet (i.e. startGame has been run)
     */
    public static boolean isStarted() {
        return started;
    }

    /**
     * Checks if point (x1, y1) is next to point (x2, y2)
     * @return True if (x1, y1) is next to (x2, y2)
     */
    private static boolean isNextTo(int x1, int y1, int x2, int y2) {
        return (x2 - 1 <= x1 && x1 <= x2 + 1) || (y2 - 1 <= y1 && y1 <= y2 + 1);
    }

    private static void calculateTileValues() {
        for (Tile[] tiles : getAllTiles()) {
            for (Tile tile : tiles) {
                tile.calculateValue();
            }
        }
    }

    public static Tile getTileAtPos(int x, int y) {
        return tiles[x][y];
    }

}
