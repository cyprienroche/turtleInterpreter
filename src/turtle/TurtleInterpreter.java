package turtle;

import turtle.implementations.*;
import turtle.util.Rotation;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class TurtleInterpreter {

    //where to read input from
    private Scanner scanner;

    //where to send output to
    private PrintStream printStream;

    //mapping of turtle names to turtles
    private HashMap<String, Turtle> map;

    //current paper
    private Paper paper;


    public TurtleInterpreter(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
        this.paper = new Paper(10, 10);
        this.map = new HashMap<>();
    }

    public Paper paper() {
        return paper;
    }

    public void readAndProcess() {
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] commands = s.split("\\s+");
            switch (commands[0]) {
                case "paper":
                    paper = new Paper(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                    break;
                case "new":
                    Turtle turtle = makeTurtle(commands[1].toLowerCase(), Integer.parseInt(commands[3]), Integer.parseInt(commands[4]));
                    map.put(commands[2], turtle);
                    break;
                case "pen":
                    if (!map.containsKey(commands[1])) {
                        System.out.println("invalid turtle name, try one of:");
                        System.out.println(map.keySet().toString());
                        break;
                    }
                    if (commands[2].toLowerCase().equals("up")) {
                        map.get(commands[1]).penUp();
                    } else if (commands[2].toLowerCase().equals("down")) {
                        map.get(commands[1]).penDown();
                    } else {
                        map.get(commands[1]).setBrush(commands[2].charAt(0));
                    }
                    break;
                case "move":
                    map.get(commands[1]).step(Integer.parseInt(commands[2]));
                    break;
                case "right":
                    map.get(commands[1])
                            .rotateRight(Integer.parseInt(commands[2]) / Rotation.ROTATIONAL_UNIT);
                    break;
                case "left":
                    map.get(commands[1])
                            .rotateLeft(Integer.parseInt(commands[2]) / Rotation.ROTATIONAL_UNIT);
                    break;
                case "show":
                    printStream.println(paper.toString());
                    break;
            }
        }
    }

    public Turtle makeTurtle(String type, int x, int y) {
        switch (type) {
            case "continuous":
                return new ContinuousTurtle(x, y, paper);
            case "bouncy":
                return new BouncyTurtle(x, y, paper);
            case "reflecting":
                return new ReflectingTurtle(x, y, paper);
            case "wrapping":
                return new WrappingTurtle(x, y, paper);
            default:
                  //normal
                  return new NormalTurtle(x, y, paper);
        }
    }


}
