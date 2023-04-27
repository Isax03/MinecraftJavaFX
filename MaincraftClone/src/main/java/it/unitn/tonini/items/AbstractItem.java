package it.unitn.tonini.items;

import it.unitn.tonini.main.Main;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

import static it.unitn.tonini.inventory.Inventory.MULT;

public class AbstractItem extends Rectangle implements Item {
    String name;
    public AbstractItem(){
        super();

        this.setHeight(14*MULT);
        this.setWidth(14*MULT);

        setTexture();
    }

    public void setTexture() {
        if(name != null){
            this.setFill(new ImagePattern(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/textures/items/" + name +".png")))));
            return;
        }
        this.setFill(Color.TRANSPARENT);
    }

    @Override
    public void consume() {}
}
