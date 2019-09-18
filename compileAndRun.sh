#!/bin/bash

# cd into the directory containing this script
cd "$(dirname "$0")"

# uncomment and complete the following calls to javac and java
# compiled class files should be placed in the out/ directory

javac -sourcepath src/ -d out/production/turtleInterpreter/ src/turtle/Main.java
java -cp out/production/turtleInterpreter/ turtle/Main
