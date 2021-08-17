package com.kaneras.minesweeper.logic;

import java.awt.*;

public class Game {
    private static Tile[][] tiles;
    private static int gridSize;

    public static void init(int gridSize, double mineDensity) {
        Game.gridSize = gridSize;
        generateTiles(mineDensity);
    }

    /**
     * Generate all tiles for the game.
     * @param mineDensity mineDensity * gridSize = number of mines to place.
     */
    private static void generateTiles(double mineDensity) {
    }

    public static Tile getTileAtPos(Point point) {
        return tiles[point.x][point.y];
    }

    public static int getGridSize() {
        return gridSize;
    }
}
