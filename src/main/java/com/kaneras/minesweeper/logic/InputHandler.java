package com.kaneras.minesweeper.logic;

import com.kaneras.minesweeper.Properties;
import com.kaneras.minesweeper.graphics.Screen;
import javafx.scene.input.MouseEvent;

import java.awt.*;

public class InputHandler {
    public static void handleMouseClick(MouseEvent mouseEvent) {
        Game.getTileAtPos(new Point((int) mouseEvent.getX() / Properties.GRID_SIZE, (int) mouseEvent.getY() / Properties.GRID_SIZE)).reveal();
        Screen.refresh();
    }
}
