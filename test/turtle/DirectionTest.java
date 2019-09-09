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

}
