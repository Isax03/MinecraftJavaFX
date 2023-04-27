package it.unitn.tonini.utils;

import it.unitn.tonini.blocks.*;

public class Factory {
    private static final Factory factory = new Factory();
    private Factory(){}

    public static Factory getInstance(){
        return factory;
    }

    public SandBlock sandBlock(){
        return new SandBlock();
    }
    public WaterBlock waterBlock(){
        return new WaterBlock();
    }
    public RawIronBlock rawIronBlock(){
        return new RawIronBlock();
    }
    public NullBlock nullBlock(){
        return new NullBlock();
    }
    public Furnace furnace(){
        return new Furnace();
    }
    public AirBlock airBlock(){
        return new AirBlock();
    }
}
