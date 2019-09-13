package turtle.implementations;

import turtle.Paper;

public class ReflectingTurtle extends AbstractTurtle {

    public ReflectingTurtle(Paper paper) {
        super(paper);
    }

    public ReflectingTurtle(int x, int y, Paper paper) {
        super(x, y, paper);
    }

    @Override
    void edgeOfPaper(int xOld, int yOld) {
        if (!paper.inBound(0, y)) {
            y = yOld;
            direction = direction.reflectY();
        }
        if (!paper.inBound(x, 0)) {
            x = xOld;
            direction = direction.reflectX();
        }
    }
}
