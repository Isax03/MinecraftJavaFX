package it.unitn.tonini.blocks;

public abstract class AbstractBlock implements Block {
    public static int IDCounter = 0;

    protected char contenuto;
    protected boolean falls_with_gravity;
    protected boolean falls_through;
    protected String blockname;
    protected boolean pickable;
    protected int id;

    public AbstractBlock(){
        super();
        pickable = false;
        this.id = AbstractBlock.IDCounter++;
    }

    @Override
    public char display() {
        return contenuto;
    }
    @Override
    public boolean getFallsWithGravity() {
        return falls_with_gravity;
    }
    @Override
    public boolean getFallsThrough() {
        return falls_through;
    }
    @Override
    public String toString() {
        return "Nome del blocco: " + blockname + " - ID: " + id;
    }
    @Override
    public void displayInInventory(){
        System.out.print("["+contenuto+"] ");
    }
    @Override
    public boolean isPickable(){
        return pickable;
    }

    public int getId(){
        return this.id;
    }
}
