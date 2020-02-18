package turtle.implementations;

import turtle.Turtle;
import turtle.util.Pen;

import java.util.Arrays;

public class ClusterTurtle implements Turtle {

    Turtle[] turtles;

    public ClusterTurtle(Turtle[] turtles) {
        this.turtles = turtles;
    }

    @Override
    public void penUp() {
        Arrays.stream(turtles).forEach(Turtle::penUp);
    }

    @Override
    public void penDown() {
        Arrays.stream(turtles).forEach(Turtle::penDown);
    }

    @Override
    public void setBrush(char c) {
        Arrays.stream(turtles).forEach(t -> t.setBrush(c));
    }

    @Override
    public void rotateRight(int n) {
        Arrays.stream(turtles).forEach(t -> t.rotateRight(n));
    }

    @Override
    public void rotateLeft(int n) {
        Arrays.stream(turtles).forEach(t -> t.rotateLeft(n));
    }

    @Override
    public void step(int n) {
        Arrays.stream(turtles).forEach(t -> t.step(n));
    }

    @Override
    public int x() {
        return (int) Arrays.stream(turtles).mapToInt(Turtle::x).average().orElse(0);
    }

    @Override
    public int y() {
        return (int) Arrays.stream(turtles).mapToInt(Turtle::x).average().orElse(0);
    }

    @Override
    public Pen penState() {
        if (Arrays.stream(turtles).anyMatch(t -> t.penState() == Pen.DOWN)) {
            return Pen.DOWN;
        }
        return Pen.UP;
    }
}
