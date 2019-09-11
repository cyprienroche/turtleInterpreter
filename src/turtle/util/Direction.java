package turtle.util;

import turtle.Main;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Direction {
    /**
     * represents the directions a turtle can face.
     * enumerates the 8 cardinal or ordinal directions.
     */
    NORTH(0,1),
    NORTHEAST(1,1),
    EAST(1,0),
    SOUTHEAST(1,-1),
    SOUTH(0,-1),
    SOUTHWEST(-1,-1),
    WEST(-1,0),
    NORTHWEST(-1,1);

    private int x;
    private int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param rotation direction in which to rotate the turtle
     * @return new direction after applying rotation
     * if rotation is null, returns the current direction
     */
    public Direction rotate(Rotation rotation) {
        return rotateN(rotation, 1);
    }

    /**
     * @param rotation direction in which to rotate the turtle
     * @param n number of times to rotate turtle in given direction
     * @return new direction after applying rotation
     */
    public Direction rotateN(Rotation rotation, int n) {
        if (rotation == null) {
            return this;
        }

        int direction;
        if (rotation == Rotation.RIGHT) {
            /* rotate clockwise */
            direction = this.ordinal() + n;
        } else {
            /* rotate anticlockwise */
            direction = this.ordinal() - n;
        }

        return Direction.values()[Main.mod(direction, Direction.values().length)];
    }

    /**
     * @param x horizontal component of direction vector
     * @param y vertical component of direction vector
     * @return cardinal or ordinal direction corresponding to input vector
     */
    public Direction getDirection(int x, int y) {
        return Arrays.stream(Direction.values())
                .filter(d -> d.x == x && d.y == y)
                .collect(Collectors.toList())
                .get(0);
    }

    public int horizontal() {
        return x;
    }

    public int vertical() {
        return y;
    }
}
