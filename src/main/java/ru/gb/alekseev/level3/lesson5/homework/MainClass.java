package ru.gb.alekseev.level3.lesson5.homework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        println("ATTENTION >>> Preparing to race!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        final CyclicBarrier readyBarrier = new CyclicBarrier(CARS_COUNT);
        final CountDownLatch finishedCountDownLatch = new CountDownLatch(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), readyBarrier, finishedCountDownLatch);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        println("ATTENTION >>> Race started!!!");
        try {
            finishedCountDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("ATTENTION >>> Race finished!!!");
    }

    public static void println(String s){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now) + ": " + s);
    }
}
