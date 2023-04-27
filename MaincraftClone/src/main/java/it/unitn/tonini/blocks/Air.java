package it.unitn.tonini.blocks;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Air extends AbstractBlock {
    protected String name = "air";

    public Air(){
        super();
        contenuto = 'A';
        this.setFill(Color.TRANSPARENT);
    }
}
