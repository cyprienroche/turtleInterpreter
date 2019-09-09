package turtle.util;

public enum Direction {
    /**
     * represents the directions a turtle can face.
     * enumerates the 8 cardinal or ordinal directions.
     */
    NORTH,
    NORTHEAST,
    EAST,
    SOUTHEAST,
    SOUTH,
    SOUTHWEST,
    WEST,
    NORTHWEST;

    /**
     * @param rotation direction in which to rotate the turtle
     * @return new direction after applying rotation
     * if rotation is null, returns the current direction
     */
    public Direction rotate(Rotation rotation) {
        if (rotation == null) {
            return this;
        }

        if (rotation == Rotation.RIGHT) {
        /* rotate clockwise */
        return Direction.values()[(this.ordinal() + 1) % Direction.values().length];
        }
        /* rotate anticlockwise */
        return this == NORTH ?
                NORTHWEST :
                Direction.values()[this.ordinal() - 1];
    }
}
