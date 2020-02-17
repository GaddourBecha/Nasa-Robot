package model;

import config.PlateauConstants;
import config.PlateauSpecs;
import exception.DirectionNotValidException;
import exception.PositionNotValidException;

public class Robot {
    private int x;
    private int y;
    private char direction;

    public Robot(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return  x + " " + y + " " + direction;
    }

    public void turnRight(){
        int index = PlateauSpecs.findIndex(direction);
        if(index==3) {
            index = 0;
        }else{
            index++;
        }
        direction = PlateauSpecs.DIRECTIONS[index];
    }

    public void turnLeft(){
        int index = PlateauSpecs.findIndex(direction);
        if(index==0){
            index = 3;
        }else{
            index--;
        }
        direction = PlateauSpecs.DIRECTIONS[index];
    }

    public void moveForward(){
        switch(direction) {
            case PlateauConstants.NORTH:
                incrementY();
                break;
            case PlateauConstants.EAST:
                incrementX();
                break;
            case PlateauConstants.SOUTH:
                decrementY();
                break;
            case PlateauConstants.WEST:
                decrementX();
                break;
            default:
                throw new DirectionNotValidException();
        }
    }

    private void incrementX(){
        if(x==PlateauSpecs.maxX){
            throw new PositionNotValidException();
        }else{
            x++;
        }
    }

    private void decrementX(){
        if(x==0){
            throw new PositionNotValidException();
        }else{
            x--;
        }
    }

    private void incrementY(){
        if(y==PlateauSpecs.maxY){
            throw new PositionNotValidException();
        }else{
            y++;
        }
    }

    private void decrementY(){
        if(y==0){
            throw new PositionNotValidException();
        }else{
            y--;
        }
    }

}
