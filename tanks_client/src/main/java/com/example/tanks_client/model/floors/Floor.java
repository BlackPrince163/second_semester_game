package com.example.tanks_client.model.floors;

import com.example.tanks_client.model.GameElements;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public abstract class Floor extends GameElements {
    protected int col;
    protected int row;

    public Floor(String path, int width, int height, int col, int row) {
        super(path, width, height);
        this.col = col;
        this.row = row;
    }

    public void makeImage(GridPane lawn) {
        img = new ImageView();
        Image im = new Image(path, width, height, false, false);
        img.setImage(im);
        lawn.add(img, col, row, 1, 1);
    }
}
