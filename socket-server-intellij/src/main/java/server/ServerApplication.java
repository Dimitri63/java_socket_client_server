package server;

import server.service.SocketService;

public class ServerApplication {

    public static void main(String[] args) {
        new SocketService().start();
    }
}
