package com.kaneras.minesweeper.logic;

import com.kaneras.minesweeper.Properties;
import com.kaneras.minesweeper.graphics.Screen;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class InputHandler {
    public static void handleMouseClick(MouseEvent mouseEvent) {
        int x = (int) mouseEvent.getX() / Properties.GRID_SIZE;
        int y = (int) mouseEvent.getY() / Properties.GRID_SIZE;
        Tile tile = Game.getTileAtPos(x, y);
        if (mouseEvent.getButton() == MouseButton.PRIMARY) {
            if (tile.isFlagged()) {
                tile.toggleFlag();
            } else {
                if (!Game.isStarted()) {
                    Game.startGame(x, y);
                }
                Game.getTileAtPos(x, y).reveal();
            }
        } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            tile.toggleFlag();
        }
        Screen.refresh();
    }
}
