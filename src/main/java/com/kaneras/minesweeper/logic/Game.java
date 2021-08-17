package com.kaneras.minesweeper.logic;

import java.awt.*;

public class Game {
    private static Tile[][] tiles;

    // The number of tiles in each row/column
    private static int gridSize;

    public static void init(int gridSize, double mineDensity) {
        Game.gridSize = gridSize;
        generateTiles(mineDensity);
    }

    public static Tile[][] getAllTiles() {
        if (tiles == null)
            throw new NullPointerException("Game hasn't been initialized yet.");
        return Game.tiles;
    }

    /**
     * Generate all tiles for the game.
     * @param mineDensity The probability of a tile being a mine
     */
    private static void generateTiles(double mineDensity) {
        tiles = new Tile[gridSize][gridSize];
        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                tiles[x][y] = new Tile(new Point(x, y));
            }
        }
    }

    public static Tile getTileAtPos(Point point) {
        return tiles[point.x][point.y];
    }

    public static int getGridSize() {
        return gridSize;
    }
}
