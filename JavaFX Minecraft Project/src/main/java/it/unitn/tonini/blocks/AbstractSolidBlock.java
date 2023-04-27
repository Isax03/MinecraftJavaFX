package it.unitn.tonini.blocks;

public abstract class AbstractSolidBlock extends AbstractBlock{
    public AbstractSolidBlock(){
        super();
        falls_with_gravity = false;
        falls_through = false;
        pickable = true;
    }
}
