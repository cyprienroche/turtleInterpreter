package turtle;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Paper {
    /**
     * represent paper that may be drawn upon.
     */
    private int width;
    private int height;
    private char[][] paper;


    /**
     * @param width width of paper
     * @param height height of paper
     */
    public Paper(int width, int height) {
        this.width = width;
        this.height = height;
        this.paper = new char[width][height];
        Arrays.stream(paper).forEach(ps -> Arrays.fill(ps, ' '));
    }

    /**
     * @return the width of the paper
     */
    public int width() {
        return width;
    }

    /**
     * @return the height of the paper
     */
    public int height() {
        return height;
    }

    /**
     * @param x horizontal component of coordinate
     * @param y vertical component of coordinate
     * @return true if the arguments are within the paper bounds
     */
    public boolean inBound(int x, int y) {
        return 0 <= x && x < width && 0 <= y && y < height;
    }

    /**
     * @param x horizontal component of coordinate to mark
     * @param y vertical component of coordinate to mark
     * @param c symbol used to mark the paper at the given coordinates
     * Marks a given x, y location with a given char.
     * If the position is not contained within the paper, does nothing.
     */
    public void mark(int x, int y, char c) {
        if (inBound(x, y)) {
            /*
               [ [0,1] , [2,3] ] becomes:

               [0,1]
               [2,3] <- y height 1 for coordinates (0,1)
                |
                x horizontal position 0 for coordinates (0,1)

            first determine height need (y), then move along (horizontal) to get position need (x)
            */
            paper[y][x] = c;
        }
    }

    /**
     * @return Convert the paper into a String, suitable for outputting.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(paper)
                .forEach(ps ->
                        sb.append(  new String(ps).chars()
                                    .mapToObj(c -> String.format("%c", c))
                                    .collect(Collectors.joining(" "))
                        ).append('\n')
                );
        return sb.toString();
    }
}
