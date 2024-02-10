#!/bin/bash

# Compile and run the Java program
mvn compile exec:java -Dexec.mainClass="org.example.Main"

echo "Both programs have finished running!"
