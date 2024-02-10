package org.example;

public class Player {

    // Player's name
    private final String name;

    // Flag indicating if a message has been sent (used for checking if it's time to send or receive)
    private boolean sentStatus;

    // Default message to send
    private String message = "Hello";

    // Counter for modifying the message content
    private int messageCounter;

    public Player(String name) {
        this.name = name;
        this.messageCounter = 1; // Start counter at 1
    }

    public void setSentStatus(boolean sentStatus) {
        this.sentStatus = sentStatus; // Update sent status flag
    }

    // Check if it's time to send a message based on the sentStatus flag
    public boolean receiveMessage() {
        return sentStatus; // Return true if it's time to receive
    }

    // Send a message to another player and modify the message content
    public void sendMessage(Player player, String receivedMessage) {
        String reply = receivedMessage + messageCounter; // Create a reply based on received message and counter
        player.setMessage(reply); // Update the other player's message

        System.out.println(player.name + " received: " + receivedMessage); // Print received message
        System.out.println(player.name + " replied: " + player.getMessage()); // Print sent message

        // Update the message counter for next message
        messageCounter++;

    }

    // Get the current message
    public String getMessage() {
        return message;
    }

    // Set the message (used for receiving messages from other players)
    public void setMessage(String message) {
        this.message = message;
    }
}
