package it.unitn.tonini.items;

public abstract class Food extends AbstractItem{
    @Override
    public void consume() {
        System.out.println("You ate a " + name);
    }
}
