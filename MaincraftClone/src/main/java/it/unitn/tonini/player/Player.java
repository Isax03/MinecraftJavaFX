package it.unitn.tonini.player;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static it.unitn.tonini.blocks.AbstractBlock.BLOCK_W;

public class Player extends Rectangle {
    public static double Xspeed = 1.0;

    public Player(){
        super();
        this.setHeight(BLOCK_W*1.5);
        this.setWidth(BLOCK_W*0.75);

        this.setFill(Color.RED);

        this.setX(100);
        this.setY(100);
    }
}
