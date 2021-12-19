package com.example.tanks_client.connection;

import com.example.tanks_client.SocketClient;
import com.example.tanks_client.exceptions.ClientException;
import com.example.tanks_client.model.User;
import com.example.tanks_protocol.Message;
import com.example.tanks_protocol.UserAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class MessageSender implements Runnable{
    private SocketClient socket;
    private Thread thread;

    public MessageSender(SocketClient socket){
        this.socket = socket;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            try (PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true)) {
                while (true) {
                    // Отправка данных на сервер
                    User user = socket.getUser();
                    while(!user.getFlag()){
                    }
                    UserAction action = user.getAction();
                    System.out.println("sender " + action);
                    Message request = Message.createMessage(action);
                    socket.sendMessage(request);
                }
            } catch (ClientException e) {
                e.printStackTrace();
            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            try {
                if (e instanceof SocketTimeoutException) {
                    throw new SocketTimeoutException();
                } else {
                    e.printStackTrace();
                }
            } catch (SocketTimeoutException ste) {
                System.out.println("Turn off the client by timeout");
            }
        }
    }
}
