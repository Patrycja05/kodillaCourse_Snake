package com.kodilla.kodillasnake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private Snake snake = new Snake();
    private final int row;
    private final int column;
    private List<Coord> apples = new ArrayList<>();

    public Board(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public List<Coord> getApples() {
        return apples;
    }

    public String getSymbol(int x, int y) {
        Coord place = new Coord(x, y);
        for (Coord coord : snake.getTail()) {
            if (coord.equals(place)) {
                return "*";
            }
        }
        for (Coord coord : getApples()) {
            if (coord.equals(place)) {
                return "0";
            }
        }
        return " ";
    }

    public void generateRandomApple() {
        Random generateNumber = new Random();
        int randomNumberX = generateNumber.nextInt(column - 1);
        int randomNumberY = generateNumber.nextInt(row - 1);
        apples.add(new Coord(randomNumberX, randomNumberY));
    }

    @Override
    public String toString() {
        String str = "";
        for (int y = 0; y < row; y++) {
            str += "|";
            for (int x = 0; x < column; x++) {
                str += getSymbol(x, y);
            }
            str += "|\n";
        }
        return replicate("-", column + 2) + "\n" + str + replicate("-", column + 2);
    }

    private String replicate(String s, int howLong) {
        String result = s;
        while (result.length() < howLong)
            result += s;
        return result;
    }

    public Snake getSnake() {
        return snake;
    }

    public boolean snakeNotLose() {
        if (snake.getTail().size() > 1) {
            for (Coord coord : snake.getTail().subList(1, snake.getTail().size() - 1)) {
                if (coord.equals(snake.getHead())) {
                    return false;
                }
            }
        }
        if (snake.getHead().getX() == 0 || snake.getHead().getX() == column || snake.getHead().getY() == 0 || snake.getHead().getY() == row)
            return false;
        return true;
    }
}
