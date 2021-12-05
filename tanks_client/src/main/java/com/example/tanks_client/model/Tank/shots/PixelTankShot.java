package com.example.tanks_client.model.Tank.shots;

import com.example.tanks_client.Main;
import com.example.tanks_client.model.Tank.Tank;

public class PixelTankShot extends Shot {
    private static final String SHOT_PATH = Main.class.getResource("/img/shot2.png").toString();

    public PixelTankShot(int width, int height, Tank tank) {

        super(SHOT_PATH, width, height, tank);
    }
}
