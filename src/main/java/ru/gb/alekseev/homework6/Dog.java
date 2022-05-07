package ru.gb.alekseev.homework6;

public class Dog extends Animal {
    protected Dog(String name) {
        super(name);
    }

    @Override
    protected int getRunMaximum() {
        return 500;
    }

    @Override
    protected int getSwimMaximum() {
        return 10;
    }
}
