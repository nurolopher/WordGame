package com.nurolopher.wordgame;

import java.util.ArrayList;

/**
 * Created by Nursultan Turdaliev on 5/10/16.
 */
public class Grid {
    private ArrayList<Cell> cells;

    public Grid() {
        this.cells = new ArrayList<>();
    }

    public int size() {
        return cells.size();
    }

    public void addCell(Cell cell) {
        this.cells.add(cell);
    }

    public Cell getAtPosition(int position) throws IndexOutOfBoundsException {
        return cells.get(position);
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }
}
