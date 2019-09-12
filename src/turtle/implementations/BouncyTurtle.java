package turtle.implementations;

import turtle.Paper;
import turtle.util.Direction;

public class BouncyTurtle extends AbstractTurtle {

    public BouncyTurtle(Paper paper) {
        super(paper);
    }

    public BouncyTurtle(int x, int y, Paper paper) {
        super(x, y, paper);
    }

    @Override
    void edgeOfPaper(int xOld, int yOld) {
        if (!paper.inBound(x, y)) {
            direction = direction.reflectX().reflectY();
            x = xOld;
            y = yOld;
        }
    }
}

