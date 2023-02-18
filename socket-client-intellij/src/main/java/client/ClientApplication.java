package client;

import client.service.SocketService;

public class ClientApplication {

    public static void main(String[] args) {
        new SocketService().start();
    }
}
