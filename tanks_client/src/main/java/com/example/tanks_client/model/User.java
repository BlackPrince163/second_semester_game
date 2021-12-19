package com.example.tanks_client.model;

import com.example.tanks_client.model.Tank.PixelTank;
import com.example.tanks_client.model.Tank.Tank;
import com.example.tanks_protocol.UserAction;

import java.io.Serializable;

public class User implements Serializable {
    protected Tank tank;
    protected volatile UserAction action;
    private volatile Boolean flag;
    private static int id = 0;
    private int user_id;

    public User(){
        this.user_id = id;
        this.flag = false;
        this.tank = new PixelTank(30, 30, 6, 6);
    }

    public User(Tank tank, UserAction action, Boolean flag) {
        this.tank = tank;
        this.action = action;
        this.flag = flag;
    }

    public void setAction(UserAction action){
        flag = true;
        this.action = action;
    }

    public UserAction getAction(){
        this.flag = false;
        return this.action;
    }

    public Boolean getFlag(){
        return flag;
    }

    public Tank getTank(){
        return this.tank;
    }

    public int getUserId() {
        return user_id;
    }
}
