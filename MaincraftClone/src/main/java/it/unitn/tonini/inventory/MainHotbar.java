package it.unitn.tonini.inventory;

import it.unitn.tonini.items.AbstractItem;
import it.unitn.tonini.items.Apple;
import it.unitn.tonini.main.Main;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Objects;

import static it.unitn.tonini.inventory.Inventory.MULT;

public class MainHotbar extends HBox {
    public final int SLOTS = 9;
    public int selectedSlot = 0;
    private final BackgroundImage selectedSlotBg;

    protected final int SLOT_SIZE = 20*MULT;

    private static class HotbarSlot extends StackPane {
        private int item_count = 5;
        private AbstractItem content;
        private final Text count = new Text();

        public AbstractItem getContent() {
            return content;
        }
        public int getItemCount() {
            return item_count;
        }

        HotbarSlot(){
            super();
            this.setAlignment(Pos.CENTER);
            this.setMinHeight(20*MULT);
            this.setMinWidth(20*MULT);
            this.setMaxHeight(20*MULT);
            this.setMaxWidth(20*MULT);

            count.setFont(Main.font);
            count.setFill(Color.WHITE);
            count.setTranslateX(4*MULT);
            count.setTranslateY(5*MULT);

            content = new Apple();
            this.updateCount();

            this.getChildren().addAll(content,count);
        }

        private void updateCount(){
            if(content == null){
                return;
            }

            if(item_count == 0){
                content.setVisible(false);
                content = new AbstractItem();
                return;
            }
            if(item_count == 1){
                content.setVisible(true);
                count.setVisible(false);
            }
            else{
                content.setVisible(true);
                count.setText(String.valueOf(item_count));
            }
        }
    }

    public MainHotbar(){
        super();
        this.setAlignment(Pos.CENTER);
        this.setMinWidth(SLOT_SIZE*SLOTS);
        this.setMinHeight(SLOT_SIZE);
        this.setMaxWidth(SLOT_SIZE*SLOTS);
        this.setMaxHeight(SLOT_SIZE);

        Image bg = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/textures/gui/hotbar.png")));
        BackgroundImage bgImg = new BackgroundImage(bg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1,1,true,true,true,true));
        this.setBackground(new Background(bgImg));

        selectedSlotBg = new BackgroundImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/textures/gui/selected_slot.png"))), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1,1,true,true,true,true));


        for(int i = 0; i < SLOTS; i++){
            HotbarSlot slot = new HotbarSlot();
            this.getChildren().add(slot);
        }
        updateSlot();
    }

    public void updateSlot(){
        for(int i = 0; i < SLOTS; i++){
            HotbarSlot currSlot = (HotbarSlot)(this.getChildren().get(i));
            if(i == selectedSlot){
                currSlot.setBackground(new Background(selectedSlotBg));
                currSlot.setMinWidth(SLOT_SIZE*1.05);
                currSlot.setMinHeight(SLOT_SIZE*1.05);
                currSlot.setMaxWidth(SLOT_SIZE*1.05);
                currSlot.setMaxHeight(SLOT_SIZE*1.05);
            } else {
                currSlot.setBackground(null);
                currSlot.setMinWidth(SLOT_SIZE);
                currSlot.setMinHeight(SLOT_SIZE);
                currSlot.setMaxWidth(SLOT_SIZE);
                currSlot.setMaxHeight(SLOT_SIZE);
            }
        }
    }

    public void useItem(){
        HotbarSlot currSlot = (HotbarSlot)(this.getChildren().get(selectedSlot));
        if(currSlot.item_count > 0){
            currSlot.item_count--;
            currSlot.content.consume();
            currSlot.updateCount();
        }
    }
}