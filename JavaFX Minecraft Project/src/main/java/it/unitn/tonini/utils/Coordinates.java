package it.unitn.tonini.utils;

import it.unitn.tonini.exceptions.WrongCoordinatesException;

import static it.unitn.tonini.gui.Map.MAP_HEIGTH;
import static it.unitn.tonini.gui.Map.MAP_WIDTH;

public class Coordinates {
    public int x;
    public int y;

    public Coordinates(int x, int y) throws WrongCoordinatesException {
        if(!(x >= 0 && x < MAP_WIDTH && y >= 0 && y < MAP_HEIGTH)){
            throw new WrongCoordinatesException();
        }

        this.x = x;
        this.y = y;
    }
}
