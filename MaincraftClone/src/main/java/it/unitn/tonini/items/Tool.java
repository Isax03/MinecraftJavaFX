package it.unitn.tonini.items;

import javafx.scene.paint.Color;

public abstract class Tool extends AbstractItem{
    public int durability;
    private int maxDurability;

    @Override
    public void consume() {
        durability--;
    }

    private Color getColor() {
        double hue = (double) this.durability / this.maxDurability * 120;
        return Color.hsb(hue, 1.0, 1.0);
    }
}
