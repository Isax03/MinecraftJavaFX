package it.unitn.tonini.blocks;

interface IronSwordInterface extends Block{
    char display();
    boolean getFallsWithGravity();
    boolean getFallsThrough();
    String toString();
}
