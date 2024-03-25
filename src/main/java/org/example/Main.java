package org.example;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Create two players
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Track the number of received and sent messages for each player
        int count = 0;

        // Loop until at least 10 messages are both sent and received by each player
        while (count < 10 ) {

            // Player 2 sends a message with its current message content
            player2.sendMessage(player1, player2.getMessage());

            // Player 1 sends a message with its current message content
            player1.sendMessage(player2, player1.getMessage());

            count++;


        }

        // Print a message indicating the loop has ended
        System.out.println("Players have finished messaging!\nFirst Program run successfully");

        Initiator initiator = new Initiator("127.0.0.1", 5555);
        Responder responder = new Responder(5555);

        responder.start();
        Thread.sleep(20);
        initiator.start();

    }
}
