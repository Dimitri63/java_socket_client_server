package server.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketService extends Thread {

    @Override
    public void run() {
        int port = 9876;
        boolean serverStarted = false;
        ServerSocket server = null;

        try {
            // instantiate the server on a given port
            server = new ServerSocket(port);
            serverStarted = true;
            System.out.println("Server started");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // if server runs accept new connection
        while(serverStarted) {
            Socket socket = null;

            try {
                // get a new connection / client
                socket = server.accept();
                System.out.println("Server handled new connection");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(socket != null) {
                // create a specific handler per connection / client
                new SocketHandler(socket).start();
            }
        }
    }
}
