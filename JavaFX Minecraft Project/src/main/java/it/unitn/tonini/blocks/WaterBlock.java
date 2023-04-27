package it.unitn.tonini.blocks;

public class WaterBlock extends AbstractBlock{
    public WaterBlock(){
        super();
        blockname = "WaterBlock";
        contenuto = 'W';
        falls_with_gravity = true;
        falls_through = true;
    }
}
