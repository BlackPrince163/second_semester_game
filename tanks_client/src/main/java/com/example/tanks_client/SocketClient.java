package com.example.tanks_client;

import com.example.tanks_client.exceptions.ClientException;
import com.example.tanks_client.model.User;
import com.example.tanks_protocol.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClient implements Client {
    protected final InetAddress address;
    protected final int port;
    protected Socket socket;
    protected User user;

    public SocketClient(InetAddress address, int port, User user) {
        this.address = address;
        this.port = port;
        this.user = user;
    }

    public InputStream getInputStream() throws IOException {
        return socket.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return socket.getOutputStream();
    }

    @Override
    public void connect() throws ClientException {
        try {
            socket = new Socket(address, port);
        } catch (IOException e) {
            throw new ClientException(e);
        }
    }

    @Override
    public void sendMessage(Message message) throws ClientException {
        try {
            socket.getOutputStream().write(Message.getBytes(message));
            socket.getOutputStream().flush();
        } catch (IOException e) {
            throw new ClientException(e);
        }
    }
    public User getUser() {
        return user;
    }
}
