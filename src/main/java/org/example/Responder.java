package org.example;

// A Java program for a Server

import java.net.*;
import java.io.*;

public class Responder extends Thread{

    private int port = 0;
    // Constructor to start the server on a specific port
    public Responder(int port) {
        this.port = port;
    }
    @Override
    public void run(){
        try {
            // Create a server socket to listen for connections on the specified port
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started and listening on port " + port);

            // Wait for a client to connect
            System.out.println("Waiting for a Initiator...");
            Socket socket = serverSocket.accept(); // Blocks until a client connects

            // Display a message when a client connects
            System.out.println("Initiator connected from " + socket.getInetAddress().getHostAddress());

            // Create a reader to read data sent by the client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Loop 10 times to receive and modify data from the client
            int count = 1;
            while (count <= 10) {
                // Read a line of text sent by the client
                String info = in.readLine();
                System.out.println("Received from Initiator: " + info);

                // Append a counter to the received data
                info += count;
                System.out.println("Modified data: " + info);

                // Create a writer to send data back to the client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Send the modified data back to the client
                out.println(info);
                count++;
            }

            // Display a message before closing the connection
            System.out.println("Closing connection...");

            // Close the socket and reader
            socket.close();
            in.close();
            serverSocket.close();
        } catch (IOException e) {
            // Handle any network-related errors
            System.out.println("Error occurred: " + e.getMessage());
        }
    }



}