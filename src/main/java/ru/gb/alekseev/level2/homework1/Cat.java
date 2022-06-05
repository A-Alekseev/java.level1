package ru.gb.alekseev.level2.homework1;

public class Cat implements Sportsman {

    public Cat(String name, int maxRunLength, int maxJumpHeigth) {
        implementation = new GenericSportsman("Cat", name, maxRunLength, maxJumpHeigth);
    }

    private GenericSportsman implementation;

    @Override
    public void Run(Track track) {
        implementation.Run(track);
    }

    @Override
    public void Jump(Wall wall) {
        implementation.Jump(wall);
    }

    @Override
    public boolean getIsDroppedOut() {
        return implementation.getIsDroppedOut();
    }

    @Override
    public String toString() {
        return implementation.toString();
    }
}

