package com.kaneras.minesweeper;

import com.kaneras.minesweeper.logic.Game;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        primaryStage.setTitle("Minesweeper");

        Game game = new Game(Preferences.GRID_SIZE, Preferences.MINE_DENSITY);
    }
}
