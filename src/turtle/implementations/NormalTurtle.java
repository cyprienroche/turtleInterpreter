package turtle.implementations;

import turtle.Paper;

public class NormalTurtle extends AbstractTurtle {

    public NormalTurtle(Paper paper) {
        super(paper);
    }

    public NormalTurtle(int x, int y, Paper paper) {
        super(x, y, paper);
    }

    @Override
    void edgeOfPaper(int xOld, int yOld) {
        if (!paper.inBound(x, y)) {
            x = xOld;
            y = yOld;
        }
    }
}
