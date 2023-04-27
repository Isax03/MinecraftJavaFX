package it.unitn.tonini.blocks;

import it.unitn.tonini.main.Main;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class AbstractBlock extends Rectangle implements Block {
    protected String name;
    protected char contenuto;
    protected boolean falls_with_gravity;
    protected boolean falls_through;

    public static final int BLOCK_W = 40;

    public AbstractBlock(){
        name = "";
        contenuto = '.';
        falls_with_gravity = false;
        falls_through = true;

        this.setWidth(BLOCK_W);
        this.setHeight(BLOCK_W);

        this.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if(!this.getBoundsInParent().intersects(Main.inventory.hotbar.getBoundsInParent()) || !Main.inventory.isOpened()){
                if (newValue) {
                    this.setStroke(Color.RED);
                    this.setStrokeWidth(3);
                    this.setTranslateZ(-1);
                }

                if (oldValue) {
                    this.setStroke(Color.TRANSPARENT);
                    this.setStrokeWidth(3);
                    this.setTranslateZ(0);
                }
            }
        });
    }

    public String getBlockName(){
        return name;
    }

    public char display(){
        return contenuto;
    }

    public boolean getFallsWithGravity(){
        return falls_with_gravity;
    }

    public boolean getFallsThrough(){
        return falls_through;
    }
}
