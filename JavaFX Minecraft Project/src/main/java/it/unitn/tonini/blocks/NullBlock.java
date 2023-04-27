package it.unitn.tonini.blocks;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock{
    public NullBlock(){
        super();
        blockname = "NullBlock";
        contenuto = '+';
        pickable = false;
    }

    @Override
    public Block smelt() {return this;}
}
