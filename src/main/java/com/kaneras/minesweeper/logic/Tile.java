package com.kaneras.minesweeper.logic;

import com.kaneras.minesweeper.Properties;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to handle the logic for each tile.
 */
public class Tile {
    private Point position;
    private boolean isMine;
    private boolean revealed;
    private boolean flagged;
    private int value;

    Tile(Point position, boolean isMine) {
        this.isMine = isMine;
        this.position = position;
        this.revealed = false;
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
        for (Point point : getSurroundingPoints()) {
            tiles.add(Game.getTileAtPos(point));
        }
        return tiles.toArray(new Tile[0]);
    }

    private Point[] getSurroundingPoints() {
        List<Point> points = new ArrayList<>();
        // Above
        if (position.y > 0)
            points.add(new Point(position.x, position.y - 1));
        // Left
        if (position.x > 0)
            points.add(new Point(position.x - 1, position.y));
        // Below
        if (position.y < Properties.GRID_SIZE - 1)
            points.add(new Point(position.x, position.y + 1));
        // Right
        if (position.x < Properties.GRID_SIZE - 1)
            points.add(new Point(position.x + 1, position.y));

        // Above & Left
        if (position.y > 0 && position.x > 0)
            points.add(new Point(position.x - 1, position.y - 1));
        // Above & Right
        if (position.y > 0 && position.x < Properties.GRID_SIZE - 1)
            points.add(new Point(position.x + 1, position.y - 1));
        // Below & Left
        if (position.y < Properties.GRID_SIZE - 1 && position.x > 0)
            points.add(new Point(position.x - 1, position.y + 1));
        // Below & Right
        if (position.y < Properties.GRID_SIZE - 1 && position.x < Properties.GRID_SIZE - 1)
            points.add(new Point(position.x + 1, position. y + 1));

        return points.toArray(new Point[0]);
    }

    public int getValue() {
        return value;
    }

    public Point getPosition() {
        return position;
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
