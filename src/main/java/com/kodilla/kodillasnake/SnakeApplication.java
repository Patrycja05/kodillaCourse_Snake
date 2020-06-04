package com.kodilla.kodillasnake;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class SnakeApplication extends javafx.application.Application {
    private Image imageback = new Image("file:src/main/resources/black.png");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BackgroundSize backgroundSize = new BackgroundSize(600, 400, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setBackground(background);


        Scene scene = new Scene(grid, 600, 400, Color.WHEAT);
        for (int n = 0; n < 60; n++) {
            grid.getColumnConstraints().add(new ColumnConstraints(10));
        }
        for (int n = 0; n < 40; n++) {
            grid.getRowConstraints().add(new RowConstraints(10));
        }
        Board board = new Board(40, 60);
        board.generateRandomApple();
        board.getSnake().initSnake();
        for (int n = 0; n < 5; n++)
            board.generateRandomApple();
        Game game = new Game(board, grid, primaryStage);
        game.display();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), ev -> {
            game.doMove();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        game.setTimeline(timeline);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.RIGHT) {
                game.click("S");
            }
            if (e.getCode() == KeyCode.LEFT) {
                game.click("A");
            }
            if (e.getCode() == KeyCode.UP) {
                game.click("W");
            }
            if (e.getCode() == KeyCode.DOWN) {
                game.click("Z");
            }
            if (e.getCode() == KeyCode.SPACE) {
                game.click(" ");
            }
        });
        primaryStage.setTitle("Snake");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}