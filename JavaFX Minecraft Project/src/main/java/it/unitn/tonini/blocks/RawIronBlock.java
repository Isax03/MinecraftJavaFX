package it.unitn.tonini.blocks;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock{
    public RawIronBlock(){
        super();
        blockname = "RawIronBlock";
        contenuto = 'I';
    }

    @Override
    public Block smelt() {
        return new IronSwordBlock();
    }
}
