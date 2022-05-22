package ru.gb.alekseev.homwork7;

public class Cat<boo> {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        fullness = p.decreaseFood(appetite);
    }

    public boolean getFullness(){
        return fullness;
    }

    @Override
    public String toString(){
        return name;
    }
}
