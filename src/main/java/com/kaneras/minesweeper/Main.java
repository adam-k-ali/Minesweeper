package com.kaneras.minesweeper;

import com.kaneras.minesweeper.logic.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        primaryStage.setTitle("Minesweeper");

        Game.init(Preferences.GRID_SIZE, Preferences.MINE_DENSITY);

        VBox layout = new VBox();
        Scene scene = new Scene(layout, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
