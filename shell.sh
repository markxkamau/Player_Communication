#!/bin/bash

# Compile and run the Java program
mvn compile exec:java -Dexec.mainClass="org.example.Main"

echo "First Program run successfully"

# Define paths to your Maven project and main classes
MAIN_CLASS1=org.example.Responder
MAIN_CLASS2=org.example.Initiator

# Run the first main class with Maven
eval "mvn exec:java -Dexec.mainClass=$MAIN_CLASS1"

sleep 0.10

# Run the second main class with Maven
mvn exec:java -Dexec.mainClass=$MAIN_CLASS2

echo "Both programs have finished running!"
