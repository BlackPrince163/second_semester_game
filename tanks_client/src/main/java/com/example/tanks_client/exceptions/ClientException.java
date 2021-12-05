package com.example.tanks_client.exceptions;

public class ClientException extends Exception {
    public ClientException(Exception e) {
        this.setStackTrace(e.getStackTrace());
    }

}
