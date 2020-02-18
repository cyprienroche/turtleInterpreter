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

    // read a command and process it
    public void readAndProcess() {
        while (scanner.hasNext()) {
            try {
                String s = scanner.nextLine();
                String[] command = s.split("\\s+");
                if (command[0].equals("exit")) {
                    break;
                }
                if (command[0].equals("")) {
                    continue;
                }
                processCommand(command);
            } catch (Exception e) {
                System.out.println("invalid command, try again");
            }
        }
    }

    // process a command
    private void processCommand(String[] command) {
        switch (command[0]) {
            case "paper":
                paper = new Paper(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                return;
            case "show":
                printStream.println(paper.toString());
                return;
            case "new":
                makeTurtle(command, "");
                return;
            case "help":
                help();
                return;
            case "turtles":
                printTurtles();
                return;
        }
        if (!map.containsKey(command[1])) {
            invalidName();
            return;
        }
        switch (command[0]) {
            case "pen":
                penCommand(command);
                return;
            case "move":
                map.get(command[1]).step(Integer.parseInt(command[2]));
                return;
            case "right":
                map.get(command[1]).rotateRight(Integer.parseInt(command[2]) / Rotation.ROTATIONAL_UNIT);
                return;
            case "left":
                map.get(command[1]).rotateLeft(Integer.parseInt(command[2]) / Rotation.ROTATIONAL_UNIT);
                return;
            default:
                throw new RuntimeException();
        }
    }

    // process a pen command
    private void penCommand(String[] command) {
        switch (command[2]) {
            case "up":
                map.get(command[1]).penUp();
                break;
            case "down":
                map.get(command[1]).penDown();
                break;
            default:
                map.get(command[1]).setBrush(command[2].charAt(0));
        }
    }

    // print message if invalid turtle name provided
    private void invalidName() {
        System.out.println("invalid turtle name, try one of:");
        map.keySet().forEach(System.out::println);
        System.out.println();
    }

    // print a list of available commands
    private void help() {
        System.out.println(
                "\nAvailable commands:\n" +
                        "exit\n" +
                        "help\n" +
                        "turtles\n" +
                        "paper width height\n" +
                        "new type name x y\n" +
                        "pen name state\n" +
                        "move name distance\n" +
                        "right name angle\n" +
                        "left name angle show\n" +
                        "see README.md for more information"
        );
    }

    // print a list of turtles available for use
    private void printTurtles() {
        map.forEach((name, turtle) -> System.out.println(
                name + " - " + turtle.getClass().getSimpleName().toLowerCase().replace("turtle", ""))
        );
    }

    // Factory method to make turtles depending on command
    private Turtle makeTurtle(String[] command, String prefix) {
        Turtle turtle;
        if (command[1].equals("cluster")) {
            turtle = makeCluster(command[2], Integer.parseInt(command[3]), prefix);
        } else {
            turtle = makeAbstractTurtle(
                    command[1].toLowerCase(),
                    Integer.parseInt(command[3]),
                    Integer.parseInt(command[4])
            );
        }
        map.put(prefix + command[2], turtle);
        return turtle;
    }

    // make a cluster of turtles
    private Turtle makeCluster(String name, int size, String prefix) {
        String[] command;
        Turtle[] turtles = new Turtle[size];
        while (size > 0) {
            command = scanner.nextLine().trim().split("\\s+");
            if (command[0].equals("")) {
                continue;
            }
            if (!command[0].equals("new")) {
                throw new RuntimeException("invalid command after cluster " +
                        command[0] + " " +
                        command[1] + " " +
                        command[2]);
            }
            Turtle turtle = makeTurtle(command, prefix + name + ".");
            turtles[turtles.length - size] = turtle;
            size--;
        }
        return new ClusterTurtle(turtles);
    }

    // Factory method to make turtles
    private Turtle makeAbstractTurtle(String type, int x, int y) {
        switch (type) {
            case "normal":
                return new NormalTurtle(x, y, paper);
            case "continuous":
                return new ContinuousTurtle(x, y, paper);
            case "bouncy":
                return new BouncyTurtle(x, y, paper);
            case "reflecting":
                return new ReflectingTurtle(x, y, paper);
            case "wrapping":
                return new WrappingTurtle(x, y, paper);
            default:
                //something else
                printPossibleTurtles();
                return null;
        }
    }

    private void printPossibleTurtles() {
        System.out.println(
                "invalid turtle type. Try one of:\n" +
                "normal\n" +
                "continuous\n" +
                "bouncy\n" +
                "reflecting\n" +
                "wrapping\n"
        );
    }


}
