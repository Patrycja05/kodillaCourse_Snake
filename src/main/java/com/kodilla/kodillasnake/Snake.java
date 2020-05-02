package com.kodilla.kodillasnake;

import java.util.ArrayList;
import java.util.List;

public class Snake extends Coord{
    private Directions direction;
    private List<Coord> tail = new ArrayList<>();

    public Snake(Directions direction, int x, int y) {
        super(x, y);
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "*";
    }

    public Directions getDirection() {
        return direction;
    }

    public List<Coord> getTail() {
        return tail;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public void setTail(List<Coord> tail) {
        this.tail = tail;
    }

    public void moveSnake(){
        tail.add(new Coord(2, 2));

        if (direction == Directions.UP){
            tail.add(new Coord(getX(), getY() + 1));
        }
        if (direction == Directions.DOWN){
            tail.add( new Coord(getX(), getY() - 1));
        }
        if (direction == Directions.RIGHT){
            tail.add( new Coord(getX() + 1, getY()));
        }
        if (direction == Directions.LEFT){
            tail.add( new Coord(getX() - 1, getY()));
        }
        int lastObj = tail.lastIndexOf(tail);
        tail.remove(lastObj);
    }
}
