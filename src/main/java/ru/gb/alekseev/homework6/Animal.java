package ru.gb.alekseev.homework6;

import javax.lang.model.element.Name;

public abstract class Animal {

    private static int instancesCount;
    private final String name;

    protected Animal(String name) {
        this.name = name;
        instancesCount++;
    }

    protected abstract int getRunMaximum();
    protected abstract int getSwimMaximum();

    public void run(int length){
        int realLength = Math.min(length, getRunMaximum());
        System.out.println(getName() + " run " + realLength + " m");
    };
    public void swim(int length){
        int realLength = Math.min(length, getSwimMaximum());
        System.out.println(getName() + " swum " + realLength + " m");
    };

    public String getName() {
        return name;
    }
    public static int getInstancesCount(){
        return instancesCount;
    }
}
