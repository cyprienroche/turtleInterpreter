package turtle.implementations;

import turtle.Paper;
import turtle.Turtle;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

public abstract class AbstractTurtle implements Turtle {

    /**
     * coordinates of the turtle
     */
    protected int x;
    protected int y;

    protected Direction direction;
    private Pen pen;
    private char brush;

    protected Paper paper;

    /**
     * @param paper a paper containing one or more turtle(s)
     * creates a turtle facing North, positioned the middle of the paper
     */
    public AbstractTurtle(Paper paper) {
        this(paper.width() / 2,paper.height() / 2, Direction.NORTH, paper);
    }

    /**
     * @param x horizontal component of the turtle's coordinates
     * @param y vertical component of the turtle's coordinates
     * @param paper a paper containing one or more turtle(s)
     * creates a turtle facing North, positioned at the given coordinates
     */
    public AbstractTurtle(int x, int y, Paper paper) {
        this(x, y, Direction.NORTH, paper);
    }

    public AbstractTurtle(int x, int y, Direction direction, Paper paper) {
        this(x, y, direction, Pen.UP, paper);
    }

    public AbstractTurtle(int x, int y, Direction direction, Pen pen, Paper paper) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.pen = pen;
        this.paper = paper;
        this.brush = '*';
    }

    public void penUp() {
        pen = Pen.UP;
    }

    public void penDown() {
        pen = Pen.DOWN;
    }

    private boolean isPenDown() {
        return pen == Pen.DOWN;
    }

    public void setBrush(char c) {
        brush = c;
    }

    public char brush() {
        return brush;
    }

    /**
     * marks the current location on the paper (with the current brush), if the pen is down
     */
    private void mark() {
        if (isPenDown()) {
            paper.mark(x, y, brush);
        }
    }

    /**
     * Rotate the turtle clockwise a given number of times.
     * @param numberOfTimes times to rotate the turtle
     */
    public void rotateRight(int numberOfTimes) {
        direction = direction.rotateN(Rotation.RIGHT, numberOfTimes);
    }

    /**
     * Rotate the turtle anticlockwise a given number of times.
     * @param numberOfTimes times to rotate the turtle
     */
    public void rotateLeft(int numberOfTimes) {
        direction = direction.rotateN(Rotation.LEFT, numberOfTimes);
    }

    /**
     * @param n number of times the turtle should move
     * move the turtle an integer number of steps in the current direction, marking the paper as it goes
     */
    public void step(int n) {
        while (n-- > 0) {
            int xOld = x, yOld = y;
            x += direction.horizontal();
            y += direction.vertical();
            edgeOfPaper(xOld, yOld);
            mark();
        }
    }

    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }

    @Override
    public Pen penState() {
        return pen;
    }

    abstract void edgeOfPaper(int xOld, int yOld);

}
