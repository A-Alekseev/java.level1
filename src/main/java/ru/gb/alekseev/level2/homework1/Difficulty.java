package ru.gb.alekseev.level2.homework1;

public abstract class Difficulty {
    private final int value;

    protected Difficulty(int value) {
        this.value = value;
    }

    public abstract void makeSportsmanDoIt (Sportsman sportsman);

    public int getValue() {
        return value;
    }
}
