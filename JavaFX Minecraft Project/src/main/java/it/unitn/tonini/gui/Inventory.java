package it.unitn.tonini.gui;

import it.unitn.tonini.blocks.Block;
import it.unitn.tonini.blocks.SmeltableBlock;
import it.unitn.tonini.exceptions.BlockErrorException;
import it.unitn.tonini.utils.AlphabeticalBlockComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Inventory {
    private final ArrayList<Block> inventory;
    public Comparator<Block> blockComparator = new AlphabeticalBlockComparator();

    public Inventory(){
        inventory = new ArrayList<>();
    }

    public int length(){
        return inventory.size();
    }

    public void printInventory(){
        System.out.print("| ");

        for (Block block : inventory) {
            block.displayInInventory();
        }

        // TODO: CHIEDERE SE VA BENE L'ENHACED FOR
        /*
        Iterator<Block> iter = inventory.iterator();

        while (iter.hasNext()){
            iter.next().displayInInventory();
        }
        */

        System.out.print("|\n");
    }

    public void addBlock(Block b){
        if(b != null) {
            inventory.add(b);
            this.sortInventory();
        }
    }

    private boolean isSmeltable(int index) {
        try {
            return inventory.get(index) instanceof SmeltableBlock;
        }catch (IndexOutOfBoundsException IOOBEx){
            System.out.println(IOOBEx);
            return false;
        }
    }

    public SmeltableBlock getSmeltableItem(int index) throws BlockErrorException {
        SmeltableBlock retBlock = (SmeltableBlock) inventory.get(index);
        inventory.remove(index);

        return retBlock;
    }

    public void sortInventory(){
        inventory.sort(blockComparator);
    }
}
