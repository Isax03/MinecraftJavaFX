package it.unitn.tonini.inventory;

import it.unitn.tonini.main.Main;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.InputStream;

import static it.unitn.tonini.inventory.Inventory.MULT;

public class InventoryPane extends VBox {
    public InventoryPane(){
        super();
        this.setMaxWidth(176*MULT);
        this.setMaxHeight(142*MULT);
        this.setMinWidth(176*MULT);
        this.setMinHeight(142*MULT);

        this.setCursor(Cursor.DEFAULT);

        InputStream img = Main.class.getResourceAsStream("/textures/gui/inventory.png");
        assert img != null;
        Image bg = new Image(img);
        BackgroundImage bgImg = new BackgroundImage(bg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1,1,true,true,true,true));
        this.setBackground(new Background(bgImg));
    }
}