package it.unitn.tonini.main;

import it.unitn.tonini.data.Map;
import it.unitn.tonini.inventory.MainHotbar;
import it.unitn.tonini.inventory.Inventory;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Objects;

import static it.unitn.tonini.blocks.AbstractBlock.BLOCK_W;

public class Main extends Application {
    public static final Font font = Font.loadFont(Objects.requireNonNull(Main.class.getResourceAsStream("/font/font.otf")), 6*Inventory.MULT);

    public static void main(String[] args) {
        launch(args);
    }

    public static final Inventory inventory = new Inventory();

    @Override
    public void start(Stage stage){
        Pane mainGui = new Pane();
        mainGui.setBackground(Background.fill(Color.LIGHTBLUE));

        Map map = new Map();
        //Player player = new Player();
        MainHotbar hotbar = inventory.hotbar;

        mainGui.getChildren().addAll(map, inventory);//, player);

        Scene scene = new Scene(mainGui, Map.MAP_WIDTH*BLOCK_W, Map.MAP_HEIGHT*BLOCK_W, true, SceneAntialiasing.BALANCED);
        scene.setCursor(Cursor.NONE);

        stage.setScene(scene);
        stage.setTitle("MainCraft");
        stage.show();
        stage.setResizable(false);
        stage.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/textures/blocks/grass.png"))));

        // Event handler for selecting slot with number keys
        stage.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            if(keyEvent.getCode().isDigitKey()){
                int num = Integer.parseInt(keyEvent.getText());
                if(num != 0){
                    hotbar.selectedSlot = num - 1;
                }
                keyEvent.consume();
            }

            hotbar.updateSlot();
        });

        // Event handler for scrolling to change selected slot
        stage.addEventFilter(ScrollEvent.SCROLL, scrollEvent -> {
            if(scrollEvent.getDeltaY() > 0){
                hotbar.selectedSlot = hotbar.selectedSlot - 1;
                if(hotbar.selectedSlot < 0){
                    hotbar.selectedSlot = hotbar.SLOTS - 1;
                }
            }
            else {
                hotbar.selectedSlot = (hotbar.selectedSlot + 1) % hotbar.SLOTS;
            }

            hotbar.updateSlot();
        });

        // Event handler for right click
        stage.addEventFilter(MouseEvent.MOUSE_CLICKED , mouseEvent -> {
            if(mouseEvent.getButton() == MouseButton.SECONDARY){
                hotbar.useItem();
            }
        });

        // Event handler for inventory opening/closing
        stage.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            if(keyEvent.getCode().toString().equals("E")){
                inventory.toggleInventory();
            }
        });
    }
}
