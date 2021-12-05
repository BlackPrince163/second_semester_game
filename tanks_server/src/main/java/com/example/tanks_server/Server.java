package com.example.tanks_server;

import com.example.tanks_server.connection.Connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private volatile List<Connection> connections;
    private static int id = 0;

    public Server() throws IOException {
        connections = new ArrayList<>();
        init();
    }

    private void init() throws IOException {
        /*while (true) {
            Socket client = s1.accept();
            connections.add(new Connection(this, client, id++));
        }*/
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
    }
}
