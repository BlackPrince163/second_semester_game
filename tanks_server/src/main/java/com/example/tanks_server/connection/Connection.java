package com.example.tanks_server.connection;

import com.example.tanks_server.Server;

import java.net.Socket;

public class Connection implements Runnable{
    private Socket socket;
    private Thread thread;
    private Server server;
    private int id;


    public Connection(Socket socket, Thread thread, Server server, int id) {
        this.server = server;
        this.socket = socket;
        this.id = id;
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

    }
}
