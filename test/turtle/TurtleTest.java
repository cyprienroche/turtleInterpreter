package turtle;

import org.junit.Test;
import turtle.util.Direction;
import turtle.util.Rotation;

import static org.junit.Assert.*;

public class TurtleTest {

    @Test
    public void penUpTest() {
        Paper paper = new Paper(2, 2);
        assertEquals(paper.toString(), "   \n   \n");

        Turtle turtle = new Turtle(paper);
        assertEquals(turtle.brush(), '*');
        turtle.step(1);
        assertEquals(paper.toString(), "   \n   \n");
    }

    @Test
    public void penDownTest() {
        Paper paper = new Paper(2, 2);
        Turtle turtle = new Turtle(paper);

        turtle.setBrush('.');
        turtle.penDown();
        turtle.step(1);
        assertEquals(paper.toString(), "  .\n   \n");

        turtle.rotateLeft(2);
        turtle.step(1);
        assertEquals(paper.toString(),". .\n   \n");

        turtle.rotateLeft(2);
        turtle.step(1);
        assertEquals(paper.toString(),". .\n.  \n");

        turtle.setBrush('*');
        turtle.rotateLeft(2);
        turtle.step(1);
        assertEquals(paper.toString(),". .\n. *\n");
    }
}
