package client.service;

import java.io.IOException;
import java.net.Socket;

public class SocketService extends Thread {

    private final int PORT = 9876;

    @Override
    public void run() {
        try {
            // create a connection to the server
            Socket socket = new Socket("127.0.0.1", PORT);

            new SocketListener(socket).start();
            new SocketWriter(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        };
    }
}
