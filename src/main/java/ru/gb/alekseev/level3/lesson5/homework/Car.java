package ru.gb.alekseev.level3.lesson5.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Pilot #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            MainClass.println(this.name + " getting ready");
            Thread.sleep(500 + (int)(Math.random() * 800));
            MainClass.println(this.name + " is ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
    }
}

