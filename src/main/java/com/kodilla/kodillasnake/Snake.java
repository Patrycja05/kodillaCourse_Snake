package com.kodilla.kodillasnake;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Coord> tail = new ArrayList<>();
    private Directions direction = Directions.RIGHT;

    public void initSnake() {
        tail.add(new Coord(2, 2));
    }

    public List<Coord> getTail() {
        return tail;
    }

    public void move(List<Coord> apples) {
        int x = this.tail.get(0).getX();
        int y = this.tail.get(0).getY();
        if (direction == Directions.UP) {
            tail.add(0, new Coord(x, y - 1));
        }
        if (direction == Directions.DOWN) {
            tail.add(0, new Coord(x, y + 1));
        }
        if (direction == Directions.RIGHT) {
            tail.add(0, new Coord(x + 1, y));
        }
        if (direction == Directions.LEFT) {
            tail.add(0, new Coord(x - 1, y));
        }
        boolean foundApple = false;
        for (int n = 0; n < apples.size(); n++) {
            if (apples.get(n).equals(tail.get(0))) {
                apples.remove(n);
                foundApple = true;
            }
        }
        if (!foundApple)
            tail.remove(tail.size() - 1);
    }

    public void changeDirection(Directions direction) {
        if (this.direction == Directions.LEFT && direction == Directions.RIGHT || this.direction == Directions.UP && direction == Directions.DOWN)
            return;
        this.direction = direction;
    }

    public Coord getHead() {
        return tail.get(0);
    }
}
