package it.unitn.tonini.main;

import it.unitn.tonini.exceptions.WrongCoordinatesException;
import it.unitn.tonini.gui.MainView;
import it.unitn.tonini.utils.Coordinates;
import it.unitn.tonini.utils.Factory;

import java.util.Scanner;

public class Main {
    public static Factory mainFactory = Factory.getInstance();
    public static MainView m;

    public static void main(String[] args) {
        try {
            m = new MainView();
        } catch (WrongCoordinatesException e) {
            System.out.println("Wrong coordinates");
        }

        m.displayOnOut();
        for (int i = 0; i < 7; i++) {
            System.out.println("Enter row and then column to pick that block");
            System.out.println("Enter '9' and the item number to move the item to the furnace");
            System.out.println("Enter '99' and then '9' to smelt");
            System.out.println("Enter '99' and then '0' to toggle the inventory sorting");
            System.out.println("Enter '99' and then any number to take from the furnace into the inventory");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();
            int col = myObj.nextInt();

            if (row == 9) {
                m.moveIntoFurnacefromInventory(col);
            } else if (row == 99) {
                if (col == 9) {
                    m.smelt();
                } else if (col == 0) {
                    m.toggleInventoryComparator();
                    m.inventory.sortInventory();
                } else {
                    m.moveIntoInventoryfromFurnace();
                }
            } else {
                try {
                    Coordinates c = new Coordinates(row, col);
                    m.pickUpBlock(c);
                } catch (WrongCoordinatesException e) {
                    System.out.println("Wrong coordinates");
                }
            }
            m.displayOnOut();
        }

        /*mainview = new MainView();
        mainview.displayOnOut();

        for(int i = 0; i < 4; i++) {
            System.out.print("Enter row and then column for adding block in inventory.\nEnter '-1' and then '-1' for smelting: ");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();
            int col = myObj.nextInt();
            if (row == -1 && col == -1) {
                System.out.print("Pick the smeltable block using its inventory index(max. "+ mainview.inventory.length() +"): ");
                mainview.moveIntoFurnacefromInventory(myObj.nextInt());
                mainview.furnace.smelt();
            } else {
                mainview.moveIntoInventoryfromFurnace();
            }

            mainview.displayOnOut();
        }*/
    }
}