package com.kaneras.minesweeper.logic;

import com.kaneras.minesweeper.Properties;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to handle the logic for each tile.
 */
public class Tile {
    private final int x, y;
    private boolean isMine;
    private boolean revealed;
    private boolean flagged;
    private int value;

    Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.revealed = false;
    }

    /**
     * Makes the tile a mine.
     */
    public void makeMine() {
        this.isMine = true;
    }

    public void calculateValue() {
        if (isMine) {
            value = -1;
            return;
        }
        value = 0;
        for (Tile tile : getSurroundingTiles()) {
            if (tile.isMine) {
                value++;
            }
        }
    }

    private Tile[] getSurroundingTiles() {
        List<Tile> tiles = new ArrayList<>();
        // Above
        if (y > 0)
            tiles.add(Game.getTileAtPos(x, y - 1));
        // Left
        if (x > 0)
            tiles.add(Game.getTileAtPos(x - 1, y));
        // Below
        if (y < Properties.GRID_SIZE - 1)
            tiles.add(Game.getTileAtPos(x, y + 1));
        // Right
        if (x < Properties.GRID_SIZE - 1)
            tiles.add(Game.getTileAtPos(x + 1, y));

        // Above & Left
        if (y > 0 && x > 0)
            tiles.add(Game.getTileAtPos(x - 1, y - 1));
        // Above & Right
        if (y > 0 && x < Properties.GRID_SIZE - 1)
            tiles.add(Game.getTileAtPos(x + 1, y - 1));
        // Below & Left
        if (y < Properties.GRID_SIZE - 1 && x > 0)
            tiles.add(Game.getTileAtPos(x - 1, y + 1));
        // Below & Right
        if (y < Properties.GRID_SIZE - 1 && x < Properties.GRID_SIZE - 1)
            tiles.add(Game.getTileAtPos(x + 1, y + 1));

        return tiles.toArray(new Tile[0]);
    }

    public int getValue() {
        return value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isMine() {
        return isMine;
    }

    public void reveal() {
        this.revealed = true;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void toggleFlag() {
        this.flagged = !this.flagged;
    }

    public boolean isFlagged() {
        return flagged;
    }
}
