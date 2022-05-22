package ru.gb.alekseev.game15;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Puzzle15Game {

    private static final int ERROR_INDEX = -1;
    public static final int ABSENT_CHIP_NUMBER = 0;

    public  Puzzle15Game(){
        Initialize();
    }

    private void Initialize() {
        chips = new int[16];
        for (int i = 0; i < 15; i++) {
            chips[i] = i+1;
        }
        chips[15] = ABSENT_CHIP_NUMBER;
    }

    static final String CHANGED_COMMAND_NAME = "Changed";

    ActionListener actionListener;
    
    //array of chips
    private int[] chips;

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    private void fireChangedEvent(){
        if (actionListener != null) {
            actionListener.actionPerformed(new ActionEvent(this, 0, CHANGED_COMMAND_NAME));
        }
    }

    public String getDescription() {
        if (getIsComplete()){
            return "Complete";
        }
        return "";
    }

    public void randomize() {

        for (int i = 0; i < 1000; i++)
        {
            makeStep(new Random().nextInt(16));
        }

        fireChangedEvent();
    }

    public void makeStep(int chipNumber) {
        if (! canStep(chipNumber))
            return;

        int chipIndex = ERROR_INDEX;
        int freeIndex = ERROR_INDEX;

        for (int i = 0; i < chips.length; i++) {
            if(chips[i] == chipNumber){
                chipIndex = i;
            }
            if(chips[i] == 0){
                freeIndex = i;
            }
        }

        if (chipIndex == ERROR_INDEX || freeIndex == ERROR_INDEX)
        {
            //TODO
        }
        chips[chipIndex] = 0;
        chips[freeIndex] = chipNumber;

        fireChangedEvent();
    }

    public int getChipNumber(int position) {
        return chips[position];
    }

    private boolean getIsComplete() {
        for (int i = 0; i <= 14; i++) {
            if (chips[i] != i + 1) {
                return false;
            }
        }
        return true;
    }

    private boolean canStep(int chipNumber) {

        int[][] availibleIndexesForStepTable = new int[][]{
                /* 0*/ new int[]{1, 4},
                /* 1*/ new int[]{0, 2, 5},
                /* 2*/ new int[]{1, 3, 6},
                /* 3*/ new int[]{2, 7},
                /* 4*/ new int[]{0, 5, 8},
                /* 5*/ new int[]{4, 1, 6, 9},
                /* 6*/ new int[]{5,2,7,10},
                /* 7*/ new int[]{6,3,11},
                /* 8*/ new int[]{4, 9, 12},
                /* 9*/ new int[]{8, 5, 10, 13},
                /*10*/ new int[]{9, 6 ,11, 14},
                /*11*/ new int[]{10, 7, 15},
                /*12*/ new int[]{8, 13},
                /*13*/ new int[]{12, 9, 14},
                /*14*/ new int[]{13, 10, 15},
                /*15*/ new int[]{14, 11},
        };

        int chipIndex = ERROR_INDEX;

        for (int i = 0; i < chips.length; i++) {
            if(chips[i] == chipNumber){
                chipIndex = i;
            }
        }

        if (chipIndex == ERROR_INDEX)
        {
            //TODO
        }

        int[] availibleIndexesForCipIndex = availibleIndexesForStepTable[chipIndex];
        for (int i:availibleIndexesForCipIndex) {
            if (chips[i] == ABSENT_CHIP_NUMBER)
                return true;
        }
        return false;
    }
}
