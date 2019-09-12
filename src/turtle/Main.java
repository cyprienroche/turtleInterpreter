package turtle;

import javafx.util.Pair;
import turtle.util.Direction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

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
        Scanner scanner;
        PrintStream printStream;

        if (args[0].equals("System")) {
            scanner = new Scanner(System.in);
        } else {
            File fileIn = new File(args[0]);
            scanner = new Scanner(fileIn);
        }

        if (args[1].equals("System")) {
            printStream = new PrintStream(System.out);
        } else {
            File fileOut = new File(args[1]);
            printStream = new PrintStream(fileOut);
        }

        TurtleInterpreter interpreter = new TurtleInterpreter(scanner, printStream);
        interpreter.readAndProcess();
    }
}
