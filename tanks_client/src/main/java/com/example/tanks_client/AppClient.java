package com.example.tanks_client;

import com.example.tanks_client.connection.MessageAccepter;
import com.example.tanks_client.connection.MessageSender;
import com.example.tanks_client.exceptions.ClientException;
import com.example.tanks_client.model.User;
import com.example.tanks_protocol.Message;
import com.example.tanks_protocol.Protocol;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class AppClient implements Runnable{
    private User user;
    private volatile MessageAccepter messageAccepter;

    public AppClient(User user) throws IOException {
        this.user = user;
        Thread thread = new Thread(this);
        thread.start();
    }

    public MessageAccepter getMessageAccepter() {
        return messageAccepter;
    }

    @Override
    public void run() {
        try {
            SocketClient socket = new SocketClient(InetAddress.getLocalHost(), Protocol.PORT, user);
            socket.connect();
            MessageSender sender = new MessageSender(socket);
            messageAccepter = new MessageAccepter(socket);
            while (true) {

            }
        } catch (ClientException | UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
