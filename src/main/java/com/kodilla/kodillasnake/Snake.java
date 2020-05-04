package com.kodilla.kodillasnake;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private Directions direction;
    private List<Coord> tail = new ArrayList<>();

    public List<Coord> getTail() {
        return tail;
    }

    public void firstSnakePosition(){
        tail.add(new Coord(2, 2));
    }

    public Coord addTail(Coord area){
        tail.add(area);
        return area;
    }

    public List<Coord> moveSnake(Directions direction, int x, int y){
        if (direction == Directions.UP){
            tail.add(new Coord(x, y + 1));
        }
        if (direction == Directions.DOWN){
            tail.add( new Coord(x,  y - 1));
        }
        if (direction == Directions.RIGHT){
            tail.add( new Coord( x + 1,  y));
        }
        if (direction == Directions.LEFT){
            tail.add( new Coord(x - 1, y));
        }
        tail.remove(tail.size()- 1);
        return tail;
    }
}
