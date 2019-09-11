package turtle;

import javafx.util.Pair;
import turtle.util.Direction;

import java.io.FileNotFoundException;

public class Main {

    /**
     * @param x arbitrary integer
     * @param n natural number
     * @return Computes x mod n
     */
    public static int mod(int x, int n) {
        return (x % n + n) % n;
    }

    public static void main(String[] args) throws FileNotFoundException {

    }
}
