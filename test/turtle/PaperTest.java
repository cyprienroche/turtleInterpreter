package turtle;


import org.junit.Test;
import turtle.util.Direction;
import turtle.util.Rotation;

import static org.junit.Assert.*;

public class PaperTest {

    @Test
    public void paper2x2Test() {
        Paper paper = new Paper(2, 2);
        assertEquals(paper.toString(), "  \n  \n");

        paper.mark(0, 0, '0');
        paper.mark(1,0,'1');
        paper.mark(0, 1, '2');
        paper.mark(1,1,'3');
        assertEquals(paper.toString(), "23\n01\n");
    }

    @Test
    public void paper3x3Test() {
        Paper paper = new Paper(3, 3);
        assertEquals(paper.toString(), "   \n   \n   \n");

        for (int j = 0; j < paper.height(); j++) {
            for (int i = 0; i < paper.width(); i++) {
                paper.mark(i, j, String.valueOf(i + j * paper.height()).charAt(0));
            }
        }

        assertEquals(paper.toString(), "678\n345\n012\n");
    }
}
