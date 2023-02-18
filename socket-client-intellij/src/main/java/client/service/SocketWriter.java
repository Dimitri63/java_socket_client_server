package client.service;

import client.utils.ConsoleManager;
import socket.lib.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketWriter extends Thread {

    private final Socket socket;

    public SocketWriter(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // get the output stream to the server socket connection
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            while (true) {
                System.out.print("Message to send :");

                String text = ConsoleManager.getInstance().readUserInput();

                // write text to the server
                out.writeObject(new Message(text));

                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
