package it.unitn.tonini.inventory;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.Cursor;

public class Inventory extends VBox {
    public static final int MULT = 2;
    private boolean opened = false;

    public InventoryPane inventoryPane = new InventoryPane();
    public MainHotbar hotbar = new MainHotbar();

    public Inventory(){
        super();
        this.setMinWidth(176*MULT);
        this.setMinHeight(200*MULT);
        this.setMaxWidth(176*MULT);
        this.setMaxHeight(200*MULT);

        this.setLayoutX(400);
        this.setLayoutY(175);

        VBox.setMargin(hotbar, new Insets(30,0,0,0));
        VBox.setMargin(inventoryPane, new Insets(0,0,50,0));

        inventoryPane.setVisible(false);
        this.getChildren().addAll(inventoryPane, hotbar);
    }

    public boolean isOpened(){
        return opened;
    }

    public void toggleInventory(){
        if(!opened){
            inventoryPane.setVisible(true);
            opened = true;
        } else {
            inventoryPane.setVisible(false);
            opened = false;
        }
    }
}
