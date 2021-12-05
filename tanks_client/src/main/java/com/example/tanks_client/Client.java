package com.example.tanks_client;

import com.example.tanks_client.exceptions.ClientException;
import com.example.tanks_protocol.*;

public interface Client {
    void connect() throws ClientException;
    void sendMessage(Message message) throws ClientException;
}
