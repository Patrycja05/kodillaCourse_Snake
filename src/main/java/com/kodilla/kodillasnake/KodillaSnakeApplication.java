package com.kodilla.kodillasnake;

import java.util.Scanner;

public class KodillaSnakeApplication {

    public static void main(String[] args) {
        Board board = new Board(5, 5);
        Snake snake = new Snake();
        Coord coord = new Coord(7, 8);

        board.generateRandomApple();
        snake.getTail();
        snake.moveSnake(Directions.UP);
        snake.getHead();
        board.getApples();





        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        //while(true) {

            //String s = scanner.nextLine().toUpperCase();

            counter++;
            if (counter > 15) {
                counter = 0;
                board.generateRandomApple();
            //}
        }
    }
}
