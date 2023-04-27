package it.unitn.tonini.data;

import it.unitn.tonini.blocks.AbstractBlock;
import it.unitn.tonini.blocks.Air;
import it.unitn.tonini.blocks.Dirt;
import it.unitn.tonini.main.Main;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;

import static it.unitn.tonini.blocks.AbstractBlock.BLOCK_W;

public class Map extends Pane {
    public AbstractBlock[][] map;
    public static final int MAP_WIDTH = 30;
    public static final int MAP_HEIGHT = 15;

    public Map(){
        this.setStyle("-fx-background-color: lightblue");
        map = new AbstractBlock[MAP_HEIGHT][MAP_WIDTH];
        for(int i = 0; i < MAP_HEIGHT; i++){
            for(int j = 0; j < MAP_WIDTH; j++){
                if(i > MAP_HEIGHT-5)
                    map[i][j] = new Dirt();
                else
                    map[i][j] = new Air();

                map[i][j].setX(j*BLOCK_W);
                map[i][j].setY(i*BLOCK_W);

                int finalI = i;
                int finalJ = j;

                map[i][j].setOnMouseClicked(mouseEvent -> {
                    if(!map[finalI][finalJ].getBoundsInParent().intersects(Main.inventory.hotbar.getBoundsInParent()) || !Main.inventory.isOpened()) {
                        this.insertAtCoords(finalJ, finalI, (mouseEvent.getButton() == MouseButton.PRIMARY) ? new Air() : new Dirt());
                        this.displayOnOut();
                        this.updateMap();
                    }
                });

                this.getChildren().add(map[i][j]);
            }
        }
    }

    public void displayOnOut(){
        for(int i = 0; i < MAP_HEIGHT; i++){
            for(int j = 0; j < MAP_WIDTH; j++){
                System.out.print(map[i][j].display());
            }
            System.out.println();
        }
    }

    private void swapBlocks(int x, int y){
        AbstractBlock tmp_block;

        tmp_block = this.map[y][x];
        this.map[y][x] = this.map[y+1][x];
        this.map[y+1][x] = tmp_block;
    }

    public void insertAtCoords(int x, int y, AbstractBlock block){
        if( x < 0 || x > MAP_WIDTH  ||
            y < 0 || y > MAP_HEIGHT) {
            System.out.println("ERRORE!! Coordinate fuori mappa!");
            return;
        }

        block.setOnMouseClicked(mouseEvent -> {
            if(!block.getBoundsInParent().intersects(Main.inventory.hotbar.getBoundsInParent()) || !Main.inventory.isOpened()) {
                this.insertAtCoords(x, y, (mouseEvent.getButton() == MouseButton.PRIMARY) ? new Air() : new Dirt());
                this.displayOnOut();
                this.updateMap();
            }
        });
        this.getChildren().set(this.getChildren().indexOf(map[y][x]), block);
        this.map[y][x] = block;

        insertRecursive(x, y, map[y][x]);
    }

    private void insertRecursive(int x, int y, AbstractBlock block){
        if(y+1 >= MAP_HEIGHT){
            return;
        }
        if(!map[y+1][x].getFallsThrough() || !block.getFallsWithGravity()){
            return;
        }

        if(map[y][x].getFallsWithGravity() && map[y+1][x].getFallsThrough()){
            swapBlocks(x, y);
            insertRecursive(x, y+1, block);
        }
    }

    private void updateMap(){
        for(int i = 0; i < MAP_HEIGHT; i++){
            for(int j = 0; j < MAP_WIDTH; j++){
                map[i][j].setX(j*BLOCK_W);
                map[i][j].setY(i*BLOCK_W);
            }
        }
    }
}
