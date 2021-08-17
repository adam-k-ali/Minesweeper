package com.kaneras.minesweeper.logic;

import com.kaneras.minesweeper.Properties;
import com.kaneras.minesweeper.graphics.Screen;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.awt.*;

public class InputHandler {
    public static void handleMouseClick(MouseEvent mouseEvent) {
        Point point = new Point((int) mouseEvent.getX() / Properties.GRID_SIZE, (int) mouseEvent.getY() / Properties.GRID_SIZE);
        Tile tile = Game.getTileAtPos(point);
        if (mouseEvent.getButton() == MouseButton.PRIMARY) {
            if (tile.isFlagged()) {
                tile.toggleFlag();
            } else {
                Game.getTileAtPos(new Point((int) mouseEvent.getX() / Properties.GRID_SIZE, (int) mouseEvent.getY() / Properties.GRID_SIZE)).reveal();
            }
        } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            tile.toggleFlag();
        }
        Screen.refresh();
    }
}
