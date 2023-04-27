package it.unitn.tonini.blocks;

import static it.unitn.tonini.main.Main.mainFactory;

public class Furnace extends AbstractSolidBlock{
    public SmeltableBlock input;
    public Block output;

    public Furnace(){
        super();
        blockname = "Furnace";
        contenuto = 'F';

        input = mainFactory.nullBlock();
        output = mainFactory.nullBlock();
    }

    public void displayOnOut(){
        System.out.println("|| " + ((this.input != null) ? this.input.display() : "+") + " --> " + this.output.display() + " ||");
    }

    public void smelt(){
        if(!(this.input instanceof NullBlock)){
            this.output = this.input.smelt();
            this.input = mainFactory.nullBlock();
        }
    }

    public void setInput(SmeltableBlock block){
        this.input = block;
    }

    public SmeltableBlock getInput(){
        SmeltableBlock retBlock = this.input;
        this.input = mainFactory.nullBlock();
        return retBlock;
    }
}
