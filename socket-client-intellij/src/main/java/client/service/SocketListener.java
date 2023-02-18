package client.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class SocketListener extends Thread {

    private final Socket socket;

    public SocketListener(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // get the input stream from the server socket connection
            // ObjectInputStream to read Objects from the socket stream
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            String read;
            // while socket is opened
            while (true) {
                // read when something arrives
                read = (String) in.readObject();

                System.out.println("Message received from server : " + read);
            }
        } catch (IOException | ClassNotFoundException e) {
            // end read connection
            return;
        }
    }
}
