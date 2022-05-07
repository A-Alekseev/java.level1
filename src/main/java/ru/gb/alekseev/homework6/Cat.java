package ru.gb.alekseev.homework6;

public class Cat extends Animal {

    protected Cat(String name) {
        super(name);
    }

    @Override
    protected int getRunMaximum() {
        return 200;
    }

    @Override
    protected int getSwimMaximum() {
        return 0;
    }
}
