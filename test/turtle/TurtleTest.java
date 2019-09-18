package turtle;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import turtle.implementations.AbstractTurtle;
import turtle.implementations.NormalTurtle;

import static org.junit.Assert.*;
import static turtle.TestSuiteHelper.readFile;
import static turtle.TestSuiteHelper.runMain;

public class TurtleTest {

    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Test
    public void penUpTest() {
        Paper paper = new Paper(2, 2);
        assertEquals(paper.toString(), "  \n  \n");

        AbstractTurtle turtle = new NormalTurtle(paper);
        assertEquals(turtle.brush(), '*');
        turtle.step(1);
        assertEquals(paper.toString(), "  \n  \n");
    }

    @Test
    public void penDown2x2Test() {
        Paper paper = new Paper(2, 2);
        AbstractTurtle turtle = new NormalTurtle(paper);

        turtle.setBrush('.');
        turtle.penDown();
        turtle.step(1);
        assertEquals(paper.toString(), " .\n  \n");

        turtle.rotateLeft(2);
        turtle.step(1);
        assertEquals(paper.toString(),"..\n  \n");

        turtle.rotateLeft(2);
        turtle.step(1);
        assertEquals(paper.toString(),"..\n. \n");

        turtle.setBrush('*');
        turtle.rotateLeft(2);
        turtle.step(1);
        assertEquals(paper.toString(),"..\n.*\n");
    }

    @Test
    public void penDown3x3Test() {
        Paper paper = new Paper(3, 3);
        AbstractTurtle turtle = new NormalTurtle(paper);

        turtle.penDown();
        turtle.rotateLeft(1);
        turtle.step(1);
        assertEquals(paper.toString(), "*  \n   \n   \n");

        turtle.rotateRight(4);
        turtle.step(2);
        assertEquals(paper.toString(), "*  \n * \n  *\n");

        turtle.rotateRight(3);
        turtle.step(10);
        assertEquals(paper.toString(), "*  \n * \n***\n");
    }

    @Test
    public void house() {
        assertEquals(readFile("testcases/outputs/house.res"),
                runMain("testcases/inputs/house.dat", tmpFolder));
    }
}
