package com.example.tanks_client.connection;

import com.example.tanks_client.SocketClient;
import com.example.tanks_client.model.User;
import com.example.tanks_protocol.Message;
import com.example.tanks_protocol.UserAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessageAccepter implements Runnable{
    private SocketClient socket;
    private Thread thread;
    private volatile List<User> users;

    public MessageAccepter(SocketClient socket){
        this.socket = socket;
        this.users = new ArrayList<>();
        thread = new Thread(this);
        thread.start();
    }

    public List<User> getUsers(){
        return users;
    }

    private void addUser(User user){
        if(!users.contains(user)){
            users.add(user);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Ответ сервера
                Message message = Message.readMessage(socket.getInputStream());

                System.out.println("accepter " + message.getUserAction());

                if(message.getUserAction().equals(UserAction.BATTLE_SEARCH)){
                    addUser(new User());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
