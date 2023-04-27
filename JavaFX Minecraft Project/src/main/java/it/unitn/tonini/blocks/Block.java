package it.unitn.tonini.blocks;

public interface Block extends InventoryBlock{
    char display();
    boolean getFallsWithGravity();
    boolean getFallsThrough();
    String toString();
    boolean isPickable();
    int getId();
}
