package turtle;

import org.junit.Test;
import turtle.util.Direction;
import turtle.util.Rotation;

import static org.junit.Assert.*;


public class DirectionTest {

    @Test
    public void rotateLeft() {
        assertEquals(Direction.NORTHEAST.rotate(Rotation.LEFT), Direction.NORTH);
        assertEquals(Direction.EAST.rotate(Rotation.LEFT), Direction.NORTHEAST);
        assertEquals(Direction.SOUTH.rotate(Rotation.LEFT), Direction.SOUTHEAST);
        assertEquals(Direction.WEST.rotate(Rotation.LEFT), Direction.SOUTHWEST);
        assertEquals(Direction.NORTHWEST.rotate(Rotation.LEFT), Direction.WEST);
        assertEquals(Direction.NORTH.rotate(Rotation.LEFT), Direction.NORTHWEST);
    }

    @Test
    public void rotateRight() {
        assertEquals(Direction.NORTHEAST.rotate(Rotation.RIGHT), Direction.EAST);
        assertEquals(Direction.EAST.rotate(Rotation.RIGHT), Direction.SOUTHEAST);
        assertEquals(Direction.SOUTH.rotate(Rotation.RIGHT), Direction.SOUTHWEST);
        assertEquals(Direction.WEST.rotate(Rotation.RIGHT), Direction.NORTHWEST);
        assertEquals(Direction.NORTHWEST.rotate(Rotation.RIGHT), Direction.NORTH);
        assertEquals(Direction.NORTH.rotate(Rotation.RIGHT), Direction.NORTHEAST);
    }

    @Test
    public void checkDirections() {
        assertEquals(Direction.getDirection(0,1), Direction.NORTH);
        assertEquals(Direction.getDirection(0,-1), Direction.SOUTH);
        assertEquals(Direction.getDirection(-1,1), Direction.NORTHWEST);
        assertEquals(Direction.getDirection(1,-1), Direction.SOUTHEAST);
    }

    @Test
    public void rotateLeftN() {
        assertEquals(Direction.NORTHEAST.rotateN(Rotation.LEFT,2), Direction.NORTHWEST);
        assertEquals(Direction.EAST.rotateN(Rotation.LEFT,4), Direction.WEST);
        assertEquals(Direction.SOUTH.rotateN(Rotation.LEFT, 8), Direction.SOUTH);
        assertEquals(Direction.WEST.rotateN(Rotation.LEFT, 11), Direction.SOUTHEAST);
        assertEquals(Direction.NORTHWEST.rotateN(Rotation.LEFT, -1), Direction.NORTH);
        assertEquals(Direction.NORTH.rotateN(Rotation.LEFT, -12), Direction.SOUTH);
    }

    @Test
    public void rotateRightN() {
        assertEquals(Direction.NORTHEAST.rotateN(Rotation.RIGHT,2), Direction.SOUTHEAST);
        assertEquals(Direction.EAST.rotateN(Rotation.RIGHT,4), Direction.WEST);
        assertEquals(Direction.SOUTH.rotateN(Rotation.RIGHT, 8), Direction.SOUTH);
        assertEquals(Direction.WEST.rotateN(Rotation.RIGHT, 11), Direction.NORTHEAST);
        assertEquals(Direction.NORTHWEST.rotateN(Rotation.RIGHT, -1), Direction.WEST);
        assertEquals(Direction.NORTH.rotateN(Rotation.RIGHT, -12), Direction.SOUTH);
    }

}
