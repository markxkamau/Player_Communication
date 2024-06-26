package org.example;

// A Java program for a Client

import java.io.*;
import java.net.*;

public class Initiator extends Thread {

    private int port = 0 ;
    private String address = "";
    // Constructor to set the server address and port
    public Initiator(String address, int port) {
        this.address = address;
        this. port = port;

    }
    @Override
    public void run(){
        try {
            // Create a socket connection to the server
            Socket socket = new Socket(address, port);

            // Create a reader to read input from the user
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Display a message and read user input
            System.out.println("Initiator Connected.");
            String info = "reader";

            // Loop 10 times to send and receive data
            int count = 1;
            while (count <= 10) {
                // Create a writer to send data to the server
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Send the user input to the server
                out.println(info);

                // Create a reader to receive data from the server
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Read the data sent by the server
                String value = in.readLine();

                // Update the user input with a counter
                info = value + count;

                // Display the received data from the server
                System.out.println("Player2 says: " + info);

                count++;
            }
            socket.close();
            reader.close();
        } catch (IOException e) {
            // Handle any network-related errors
            System.out.println("Error occurred: " + e.getMessage());
        }
    }


}
