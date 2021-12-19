package com.example.tanks_client.model;

import com.example.tanks_client.model.Tank.shots.Shot;

public interface Destroymable {
    public boolean destroy(Shot shot);
}
