package com.kodilla.kodillasnake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private Snake snake;
    private final int row;
    private final int column;
    private Coord apple;
    private List<Coord> apples = new ArrayList<>();

    public Board(int row, int column){
        this.row = row;
        this.column = column;
    }

    public List<Coord> getApples() {
        return apples;
    }

    public String getSymbol(int x, int y){
        Coord actualPosition = new Coord(x, y);
        boolean foundSnake = false;
        for(Coord coord: snake.getTail()) {
            if (coord.equals(actualPosition)) {
                foundSnake = true;
            }
        }

        boolean foundApple = false;
        for(Coord coord: getApples()) {
            if (coord.equals(actualPosition)) {
                foundApple = true;
                }
            }

        if (foundSnake == true){
            return "*";
        } else if(foundApple == true){
            return "0";
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
