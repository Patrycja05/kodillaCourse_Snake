package com.kodilla.kodillasnake;

import java.util.Scanner;

public class KodillaSnakeApplication {

    public static void main(String[] args) {
        Board board = new Board(5, 5);
        Snake snake = new Snake();

        board.initSnake();
        snake.firstSnakePosition();
        snake.getTail();
        board.getSymbol(2,2);

        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        //while(true) {
            System.out.println(board);
            //String s = scanner.nextLine().toUpperCase();

            counter++;
            if (counter > 15) {
                counter = 0;
                board.generateRandomApple();
            //}
        }
    }
}
