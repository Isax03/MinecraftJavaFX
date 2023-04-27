package it.unitn.tonini.blocks;

public class AirBlock extends AbstractBlock{
    public AirBlock(){
        super();
        blockname = "AirBlock";
        contenuto = 'A';
        falls_with_gravity = false;
        falls_through = true;
    }
}
