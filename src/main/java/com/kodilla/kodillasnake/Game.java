package com.kodilla.kodillasnake;

import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.Background;

public class Game {
    private final Board board;
    private final GridPane grid;
    private final Stage parentStage;
    private int counter = 0;
    private Timeline timeline;
    private Image imageback = new Image("file:src/main/resources/green.png");

    public Game(Board board, GridPane grid, final Stage parentStage) {
        this.board = board;
        this.grid = grid;
        this.parentStage = parentStage;
    }

    public void display() {
        grid.getChildren().clear();
        for (Coord coord : board.getSnake().getTail()) {
            Rectangle r = new Rectangle(0, 0, 10, 10);
            r.setFill(Color.AQUAMARINE);
            grid.add(r, coord.getX(), coord.getY());
        }
        for (Coord coord : board.getApples()) {
            Rectangle r = new Rectangle(0, 0, 10, 10);
            r.setFill(Color.RED);
            grid.add(r, coord.getX(), coord.getY());
        }
    }

    public void click(String character) {
        switch (character) {
            case "W":
                board.getSnake().changeDirection(Directions.UP);
                break;
            case "A":
                board.getSnake().changeDirection(Directions.LEFT);
                break;
            case "Z":
                board.getSnake().changeDirection(Directions.DOWN);
                break;
            case "S":
                board.getSnake().changeDirection(Directions.RIGHT);
                break;
        }
    }

    public void doMove() {
        board.getSnake().move(board.getApples());
        counter++;
        if (counter > 15) {
            counter = 0;
            board.generateRandomApple();
        }
        if (board.snakeNotLose()) {
            display();
        } else {
            gameOver();
        }
    }

    public void gameOver() {
        timeline.stop();
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(parentStage);

        VBox dialogVbox = new VBox(20);
        dialogVbox.setAlignment(Pos.CENTER);
        Label label = new Label("Game over");
        label.setTextAlignment(TextAlignment.CENTER);
        Font font = new Font(40);
        label.fontProperty().setValue(font);
        dialogVbox.getChildren().add(label);

        BackgroundSize backgroundSize = new BackgroundSize(300, 200, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        dialogVbox.setBackground(background);

        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }
}
