package com.kodilla.kodillasnake;

import java.util.Scanner;

public class KodillaSnakeApplication {

    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();
        Snake snake = new Snake(Directions.UP, 100, 50);

        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        while(true) {
            System.out.println(board);
            String s = scanner.nextLine().toUpperCase();

            counter++;
            if (counter > 15) {
                counter = 0;
                board.generateRandomApple();
            }
        }
    }
}
