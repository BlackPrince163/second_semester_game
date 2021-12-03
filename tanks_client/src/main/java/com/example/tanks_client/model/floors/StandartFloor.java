package com.example.tanks_client.model.floors;

import com.example.tanks_client.Main;

public class StandartFloor extends Floor {
    // тупо черный пол
    private static final String floorPath = Main.class.getResource("/img/standartFloor.png").toString();

    public StandartFloor(String path, int width, int height, int col, int row) {
        super(path, width, height, col, row);
    }
}
