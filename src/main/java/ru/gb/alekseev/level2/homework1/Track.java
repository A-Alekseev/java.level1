package ru.gb.alekseev.level2.homework1;

public class Track extends Difficulty {
    public Track(int length) {
        super(length);
    }

    @Override
    public void makeSportsmanDoIt(Sportsman sportsman) {
        sportsman.Run(this);
    }

    @Override
    public String toString(){
        return "Track " + getValue() + " m";
    }
}

