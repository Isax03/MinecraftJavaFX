package it.unitn.tonini.blocks;

import it.unitn.tonini.main.Main;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class Grass extends AbstractSolidBlock {
    protected String name = "grass";

    public Grass(){
        super();
        contenuto = 'G';

        setTexture();
    }
}
