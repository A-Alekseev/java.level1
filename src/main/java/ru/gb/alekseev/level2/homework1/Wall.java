package ru.gb.alekseev.level2.homework1;

public class Wall extends Difficulty {
    protected Wall(int value) {
        super(value);
    }

    @Override
    public void makeSportsmanDoIt(Sportsman sportsman) {
        sportsman.Jump(this);
    }

    @Override
    public String toString(){
        return "Wall " + getValue() + " sm";
    }

}
