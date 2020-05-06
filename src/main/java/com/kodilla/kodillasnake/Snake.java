package com.kodilla.kodillasnake;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Coord> tail = new ArrayList<>();
    private  Directions direction;

   public Snake() {
        tail.add(new Coord(2,2));
    }

    public List<Coord> getTail() {
        return tail;
    }

    public List<Coord> moveSnake(Directions direction){
        Coord coord = null;
        int headX = this.tail.get(0).getX();
        int headY = this.tail.get(0).getY();
        if (direction.equals(Directions.UP)){
            tail.add(new Coord(headX, headY + 1));
        }
        if (direction.equals(Directions.DOWN)){
            tail.add( new Coord(headX,  headY - 1));
        }
        if (direction.equals(Directions.RIGHT)){
            tail.add( new Coord( headX + 1,  headY));
        }
        if (direction.equals(Directions.LEFT)){
            tail.add( new Coord(headX - 1, headY));
        }
        tail.remove(tail.size()- 1);
        return tail;
    }

    public boolean isEatFood(Coord food) {
        Coord head = tail.get(0);
        return Math.abs(head.getX() - food.getX()) + Math.abs(head.getY() - food.getY()) == 0;
    }

    public Coord getHead(){
        return tail.get(0);
    }
}
