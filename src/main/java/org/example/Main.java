package org.example;

public class Main {

    public static void main(String[] args) {
        // Create two players
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Initially, player 1 sends and player 2 receives (using their `sentStatus` flags)
        player1.setSentStatus(true);
        player2.setSentStatus(false);

        // Track the number of received and sent messages for each player
        int replyCount = 0;
        int sendCount = 0;

        // Loop until at least 10 messages are both sent and received by each player
        while (replyCount < 10 && sendCount < 10) {
            // Check if it's time for player 2 to receive and reply
            if (player2.receiveMessage()) {
                // Player 2 sends a message with its current message content
                player2.sendMessage(player1, player2.getMessage());

                // Update flag to indicate player 1 should receive and player 2 not
                player1.setSentStatus(true);
                player2.setSentStatus(false);

                // Increase reply count to track received messages
                replyCount++;
            }

            // Check if it's time for player 1 to receive and reply
            if (player1.receiveMessage()) {
                // Player 1 sends a message with its current message content
                player1.sendMessage(player2, player1.getMessage());

                // Update flag to indicate player 2 should receive and player 1 not
                player1.setSentStatus(false);
                player2.setSentStatus(true);

                // Increase send count to track sent messages
                sendCount++;
            }
        }

        // Print a message indicating the loop has ended
        System.out.println("Players have finished messaging!\nFirst Program run successfully");

        Initiator initiator = new Initiator("127.0.0.1", 5555);
        Responder responder = new Responder(5555);

        initiator.start();
        responder.start();

    }
}
