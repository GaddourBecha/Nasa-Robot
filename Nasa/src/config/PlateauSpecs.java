package config;

import exception.DirectionNotValidException;

public class PlateauSpecs {
    public static int maxX;
    public static int maxY;
    public final static char[] DIRECTIONS = {PlateauConstants.NORTH,PlateauConstants.EAST,PlateauConstants.SOUTH,PlateauConstants.WEST};
    public static int findIndex(char target)
    {
        for (int i = 0; i < DIRECTIONS.length; i++)
            if (DIRECTIONS[i] == target) {
                return i;
            }
        throw new DirectionNotValidException();
    }

}
