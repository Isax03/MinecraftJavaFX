package it.unitn.tonini.gui;

import it.unitn.tonini.blocks.AirBlock;
import it.unitn.tonini.blocks.Furnace;
import it.unitn.tonini.blocks.NullBlock;
import it.unitn.tonini.exceptions.BlockErrorException;
import it.unitn.tonini.exceptions.WrongCoordinatesException;
import it.unitn.tonini.main.Main;
import it.unitn.tonini.utils.AlphabeticalBlockComparator;
import it.unitn.tonini.utils.BlockComparator;
import it.unitn.tonini.utils.Coordinates;

import static it.unitn.tonini.main.Main.mainFactory;

public class MainView {
    public Map main_map;
    public Furnace furnace;
    public Inventory inventory;

    public MainView() throws WrongCoordinatesException {
        main_map = new Map();
        furnace = Main.mainFactory.furnace();
        inventory = new Inventory();

        main_map.insertRandom();
    }

    public void displayOnOut(){
        inventory.printInventory();
        main_map.displayOnOut();
        furnace.displayOnOut();
    }

    public void smelt(){
        furnace.smelt();
        if(!(furnace.output instanceof NullBlock)){
            this.inventory.addBlock(furnace.output);
            furnace.output = mainFactory.nullBlock();
        }
    }

    public void moveIntoFurnacefromInventory(int index){
        try {
            furnace.setInput(inventory.getSmeltableItem(index));
        } catch (BlockErrorException e){
            System.out.println(e);
        }
    }

    public void moveIntoInventoryfromFurnace(){
        inventory.addBlock(furnace.getInput());
    }

    public void pickUpBlock(Coordinates coords){
        inventory.addBlock(main_map.map[coords.y][coords.x]);
        main_map.map[coords.y][coords.x] = Main.mainFactory.airBlock();
        main_map.dropOnRemove(coords);
    }

    public void toggleInventoryComparator(){
        if(inventory.blockComparator instanceof AlphabeticalBlockComparator){
            inventory.blockComparator = new BlockComparator();
            System.out.println("Ordinamento per ID");
        } else {
            inventory.blockComparator = new AlphabeticalBlockComparator();
            System.out.println("Ordinamento alfabetico");
        }
    }
}
