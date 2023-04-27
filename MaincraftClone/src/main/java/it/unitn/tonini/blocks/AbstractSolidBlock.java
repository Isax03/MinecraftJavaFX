package it.unitn.tonini.blocks;

import it.unitn.tonini.main.Main;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.util.Objects;

public abstract class AbstractSolidBlock extends AbstractBlock{
    protected String name = "dirt";

    public AbstractSolidBlock(){
        super();
        falls_with_gravity = false;
        falls_through = false;
    }

    protected void setTexture(){
        Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/textures/blocks/" + name + ".png")));
        this.setFill(new ImagePattern(img));
    }
}
