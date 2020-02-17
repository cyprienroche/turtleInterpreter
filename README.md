# turtleInterpreter

turtleInterpreter is a Java program which allows a user to draw pictures using a Turtle Graphics Language. Each turtle is assigned a name and respond to individual commands.

## Getting Started

### Prerequisites

To install before running:

```
Java 8 or later version
```

### Installing

Run compileAndRun.sh on command line

```
./compileAndRun.sh
```
This will start the program. Then create a paper and turtles.
Use the commands to move the turtle and draw on the paper.

Example:

```
paper 10 10

new normal Leonardo 0 0
pen Leonardo down
pen Leonardo @

move Leonardo 5
right Leonardo 45
move Leonardo 3
right Leonardo 90
move Leonardo 3
right Leonardo 45
move Leonardo 4
right Leonardo 90
move Leonardo 3
right Leonardo 90
move Leonardo 2
left Leonardo 180
move Leonardo 2
right Leonardo 90
move Leonardo 3

show
```
Result:

```
    @     
   @ @    
  @   @   
 @     @  
@       @
@       @
@  @@@  @
@  @ @  @
@@@@ @@@@


```

## Program arguments

First program argument specifies the input file.
Second program argument specifies the output file.
Use System as first and second arguments to main to input and output using the command line.

## Commands

* **paper** *width* *height* - creates a new blank paper with size *width* characters wide and *height* characters high.
* **new** *type* *name* *x* *y* - creates a new turtle of a given *type* (see turtle types below). Will create a new turtle named *name*. The turtle will be placed at position (*x*,*y*) on the paper, where (0,0) is the bottom left corner. The default pen of the turtle is * and is up, turtle will be facing North.
* **pen** *name* *state* - changes the state of the pen held by turtle *name*. *state* can either be **up** or **down** or a single *non-blank* character.
* **move** *name* *distance* - makes the turtle named *name* move *distance* units in its current direction.
* **right** *name* *angle* - instruct the turtle named *name* to rotate *angle* degree clockwise. It is assumed that the *angle* parameter is a positive integer multiple of 45.
* **left** *name* *angle* - instruct the turtle named *name* to rotate *angle* degree anticlockwise.
* **show** - which will output the contents of the paper to the current output medium.

*type* - normal, continuous, bouncy, reflecting, wrapping


special case: **new** *cluster* *name* *size* - must then be followed immediately by *size* new turtles to be declared one after the other. For example: 

```
paper 10 10

new cluster c 2
new normal a 3 5
new normal b 1 2
move c 1
move c.b 2

show
```

## Acknowledgments

* Imperial College London
