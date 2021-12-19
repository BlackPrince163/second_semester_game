package com.example.tanks_client.model.floors;

import com.example.tanks_client.Main;

public class StandartFloor extends Floor {
    private static final String floorPath = Main.class.getResource("/img/standartFloor.png").toString();

    public StandartFloor(int width, int height, int col, int row) {
        super(floorPath, width, height, col, row);
    }
}
