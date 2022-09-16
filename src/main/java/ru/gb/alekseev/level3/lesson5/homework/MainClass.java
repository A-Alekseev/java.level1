package ru.gb.alekseev.level3.lesson5.homework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        println("ATTENTION >>> Preparing!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        println("ATTENTION >>> Race started!!!");
        println("ATTENTION >>> Race finished!!!");
    }

    public static void println(String s){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now) + ": " + s);
    }
}
