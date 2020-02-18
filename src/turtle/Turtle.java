package turtle;

import turtle.util.Pen;

public interface Turtle {
    void penUp();
    void penDown();
    void setBrush(char c);
    void rotateRight(int n);
    void rotateLeft(int n);
    void step(int n);
    int x();
    int y();
    Pen penState();
}
