package com.kaneras.minesweeper;

import com.kaneras.minesweeper.graphics.Screen;
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

        Game.init(Properties.GRID_SIZE, Properties.MINE_DENSITY);
        Screen.init();

        VBox layout = new VBox();
        layout.getChildren().addAll(Screen.getCanvas());
        Scene scene = new Scene(layout, Properties.MIN_WIDTH, Properties.MIN_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
