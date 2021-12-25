package com.masondierkes;

import java.util.ArrayList;

public class FireModel {
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;
    private ArrayList < FireCell > workList;

    public FireModel(FireView view) {
        myGrid = new FireCell[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++)
            for (int c = 0; c < SIZE; c++)
                myGrid[r][c] = new FireCell(r, c);

        myView = view;
        myView.updateView(myGrid);
    }


    public void solve() {
        workList = new ArrayList<>();
        for (int i = 0; i < myGrid.length; i++)
            if (myGrid[myGrid.length - 1][i].getStatus() == FireCell.GREEN) {
                myGrid[myGrid.length - 1][i].setStatus(FireCell.BURNING);
                workList.add(myGrid[myGrid.length - 1][i]);
            }

        for (FireCell fireCell : workList)
            recursiveFire(fireCell);
    }

    private void recursiveFire(FireCell cell) {
        if (cell.x - 1 >= 0)
            if (myGrid[cell.x - 1][cell.y].getStatus() == 1) {
                myGrid[cell.x - 1][cell.y].setStatus(2);
                recursiveFire(myGrid[cell.x - 1][cell.y]);
            }

        if (cell.y - 1 >= 0)
            if (myGrid[cell.x][cell.y - 1].getStatus() == 1) {
                myGrid[cell.x][cell.y - 1].setStatus(2);
                recursiveFire(myGrid[cell.x][cell.y - 1]);
            }

        if (cell.x + 1 < SIZE)
            if (myGrid[cell.x + 1][cell.y].getStatus() == 1) {
                myGrid[cell.x + 1][cell.y].setStatus(2);
                recursiveFire(myGrid[cell.x + 1][cell.y]);
            }

        if (cell.y + 1 < SIZE)
            if (myGrid[cell.x][cell.y + 1].getStatus() == 1) {
                myGrid[cell.x][cell.y + 1].setStatus(2);
                recursiveFire(myGrid[cell.x][cell.y + 1]);
            }
    }
}