package ru.gb.alekseev.level2.homework1;

public class GenericSportsman implements Sportsman {

    public GenericSportsman(String species, String name, int maxRunLength, int maxJumpHeight){
        this.species = species;
        this.name = name;
        this.maxRunLength = maxRunLength;
        this.maxJumpHeight = maxJumpHeight;
        isDroppedOut = false;
    }

    private String species;
    private String name;
    private int maxRunLength;
    private int maxJumpHeight;
    private boolean isDroppedOut;

    @Override
    public void Run(Track track) {
        completeChallenge(track, getMaxRunLength());
    }

    @Override
    public void Jump(Wall wall) {
        completeChallenge(wall, getMaxJumpHeight());
    }

    @Override
    public String toString() {
        return species + " " + name;
    }

    private void completeChallenge(Difficulty difficulty, int maxValue){
        if (getIsDroppedOut()){
            System.out.println(this + " can't complete " + difficulty + " cause dropped out");
            return;
        }

        if(difficulty.getValue() > maxValue){
            isDroppedOut = true;
            System.out.println(this + " failed to complete " + difficulty + " and will be dropped out");
            return;
        }

        System.out.println(this + " successfully complete " + difficulty);
    }

    public int getMaxRunLength() {
        return maxRunLength;
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    @Override
    public boolean getIsDroppedOut() {
        return isDroppedOut;
    }
}

