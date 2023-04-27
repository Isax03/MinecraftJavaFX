package it.unitn.tonini.blocks;

public class SandBlock extends AbstractBlock implements SmeltableBlock{
    public SandBlock(){
        super();
        blockname = "SandBlock";
        contenuto = 'S';
        falls_with_gravity = true;
        falls_through = false;
        pickable = true;
    }

    @Override
    public Block smelt() {
        return new GlassBlock();
    }
}
