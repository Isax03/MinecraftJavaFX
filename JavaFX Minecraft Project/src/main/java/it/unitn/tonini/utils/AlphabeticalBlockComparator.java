package it.unitn.tonini.utils;

import it.unitn.tonini.blocks.Block;

import java.util.Comparator;

public class AlphabeticalBlockComparator implements Comparator<Block> {
    @Override
    public int compare(Block o1, Block o2) {
        return (o1.toString()).compareTo(o2.toString());
    }
}
