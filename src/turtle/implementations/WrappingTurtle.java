package turtle.implementations;

import turtle.Paper;

public class WrappingTurtle extends AbstractTurtle {

    public WrappingTurtle(Paper paper) {
        super(paper);
    }

    public WrappingTurtle(int x, int y, Paper paper) {
        super(x, y, paper);
    }

    @Override
    void edgeOfPaper(int xOld, int yOld) {
        if (!paper.inBound(0, y)) {
            y = paper.height() - Math.abs(y);
        }
        if (!paper.inBound(x, 0)) {
            x = paper.width() - Math.abs(x);
        }
    }
}
