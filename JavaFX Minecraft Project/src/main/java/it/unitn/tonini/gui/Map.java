package it.unitn.tonini.gui;

import it.unitn.tonini.blocks.*;
import it.unitn.tonini.exceptions.BlockErrorException;
import it.unitn.tonini.exceptions.WrongCoordinatesException;
import it.unitn.tonini.utils.Coordinates;

import java.util.Random;

import static it.unitn.tonini.main.Main.mainFactory;

public class Map {
    public final Block[][] map;
    public static final int MAP_WIDTH = 10;
    public static final int MAP_HEIGTH = 10;

    public Map() throws WrongCoordinatesException {
        map = new Block[MAP_HEIGTH][MAP_WIDTH];
        for(int i = 0; i < MAP_HEIGTH; i++){
            for(int j = 0; j < MAP_WIDTH; j++){
                map[i][j] = mainFactory.airBlock();
            }
        }
        addRiver(0);
    }

    public void displayOnOut(){
        for(int i = 0; i < MAP_HEIGTH; i++){
            for(int j = 0; j < MAP_WIDTH; j++){
                System.out.print(map[i][j].display());
            }
            System.out.println();
        }
    }

    private void swapBlocks(Coordinates coords){
        Block tmp_block;

        tmp_block = map[coords.y][coords.x];
        map[coords.y][coords.x] = map[coords.y+1][coords.x];
        map[coords.y+1][coords.x] = tmp_block;
    }

    public void insertAtCoords(Coordinates coords, Block block){
        map[coords.y][coords.x] = block;
        updateGravity(coords);
    }

    public void dropOnRemove(Coordinates coords) {
        coords.y++;
        while(coords.y >= 0){
            updateGravity(coords);
            coords.y--;
        }
    }

    private void updateGravity(Coordinates coords) {
        if(coords.y+1 >= MAP_HEIGTH)
            return;

        if(map[coords.y][coords.x].getFallsWithGravity() && map[coords.y+1][coords.x].getFallsThrough()){
            swapBlocks(coords);
            coords.y++;
            updateGravity(coords);
        }
    }

    private void addRowsOfWater(int y) throws WrongCoordinatesException {
        for(int i = 0; i < MAP_WIDTH; i++){
            insertAtCoords(new Coordinates(i,y), mainFactory.waterBlock());
        }
    }

    public void addRiver(int y) throws WrongCoordinatesException {
        addRowsOfWater(y);
    }
    public void addSea(int y) throws WrongCoordinatesException {
        for(int i = y; i < y+3; i++)
            addRowsOfWater(i);
    }

    private boolean isSmeltable(Coordinates coords){
        return map[coords.y][coords.x] instanceof SmeltableBlock;
    }

    public SmeltableBlock getSmeltable(Coordinates coords) throws BlockErrorException{
        if(isSmeltable(coords))
            return (SmeltableBlock) map[coords.y][coords.x];
        else
            return null;
    }

    void insertRandom() throws WrongCoordinatesException {
        Random rand = new Random();
        for (int i = 0 ; i < 10; i++){
            Block b = mainFactory.sandBlock();
            int row = rand.nextInt(MAP_HEIGTH);
            int col = rand.nextInt(MAP_WIDTH);

            this.insertAtCoords(new Coordinates(col, row), b);
        }
        for (int i = 0 ; i < 10; i++){
            Block b = mainFactory.rawIronBlock();
            int row = rand.nextInt(MAP_HEIGTH);
            int col = rand.nextInt(MAP_WIDTH);

            this.insertAtCoords(new Coordinates(col, row), b);
        }
    }

    private boolean isPickable(Coordinates coords){
        return map[coords.y+1][coords.x].isPickable();
    }

    public Block getPickable(Coordinates coords) throws BlockErrorException {
        return map[coords.y+1][coords.x];
    }
}
