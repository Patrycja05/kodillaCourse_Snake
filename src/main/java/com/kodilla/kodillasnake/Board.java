package com.kodilla.kodillasnake;

import java.util.Random;

public class Board {
    private Snake snake;
    private final int row;
    private final int column;
    private Coord apple;

    public Board(int row, int column){
        this.row = row;
        this.column = column;
    }

    public Snake initSnake(){
        snake = new Snake();
        for (int i = 0; i < 2; i++) {
            snake.addTail(new Coord(i + row / 2, column / 2));
        }
        return snake;
    }

    public String getSymbol(int x, int y){
        snake = new Snake();
        Coord actualPosition = new Coord(x, y);
        if(actualPosition == snake.getTail()){
            return "*";
        } else if (actualPosition == generateRandomApple()){
                return "O";
            } else {
            return " ";
        }
    }

    public Coord generateRandomApple(){
        Random generateNumber = new Random();
        int randomNumberX = generateNumber.nextInt(row - 1);
        int randomNumberY = generateNumber.nextInt(column - 1);
        apple = new Coord(randomNumberX, randomNumberY);
        return apple;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++) {
                str += "|" + getSymbol(row, column) + "|" + "\n";
            }
        }
        return "------------------------" + "\n" + str  + "------------------------";
    }
}
