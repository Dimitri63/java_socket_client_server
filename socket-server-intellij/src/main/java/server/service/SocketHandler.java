package server.service;

import socket.lib.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class SocketHandler extends Thread {

    private final Socket socket;

    public SocketHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            while (true) {
                // read data from socket
                Message data = (Message) ois.readObject();
                System.out.println("Message Received: " + data.getValue());
                oos.writeObject(data.getValue());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            handleSocketException(e);
        }
    }

    private void handleSocketException(IOException exception) {
        if(exception instanceof SocketException) {
            String exceptionMessage = exception.getMessage();

            if(exceptionMessage.equals("Connection reset")) {
                System.err.println("Client closed connection");
            } else {
                exception.printStackTrace();
            }
        } else {
            exception.printStackTrace();
        }
    }
}
