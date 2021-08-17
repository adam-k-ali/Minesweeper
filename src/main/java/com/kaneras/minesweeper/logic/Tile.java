package com.kaneras.minesweeper.logic;

import java.awt.*;

/**
 * A class to handle the logic for each tile.
 */
public class Tile {
    private Point position;
    private boolean revealed;
    private boolean flagged;

    Tile(Point position) {
        this.position = position;
        this.revealed = false;
    }

    public Point getPosition() {
        return position;
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
