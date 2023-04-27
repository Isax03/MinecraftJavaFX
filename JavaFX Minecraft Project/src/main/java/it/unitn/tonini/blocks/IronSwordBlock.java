package it.unitn.tonini.blocks;

class IronSwordBlock extends AbstractBlock implements IronSwordInterface{
    public IronSwordBlock(){
        super();
        blockname = "IronSwordBlock";
        contenuto = 'i';
        falls_through = false;
        falls_with_gravity = false;
    }
}
