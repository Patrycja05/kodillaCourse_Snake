package com.kodilla.kodillasnake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private Snake snake;
    private List<Coord> apples = new ArrayList<>();

    public void printBoard(){

        System.out.println("------------------------");

        for (int n = 0; n < 7; n++) {
            System.out.println("|                      |");
        }
        System.out.println("------------------------");
    }

    Random generateNumber = new Random();
    int randomNumber = generateNumber.nextInt(30);

    public void generateRandomApple(){
        apples.add(new Coord(randomNumber, randomNumber));
    }
}
