package ru.gb.alekseev.level3.lesson5.homework;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "Tunnel " + length + " meters";

        semaphore = new Semaphore(MainClass.CARS_COUNT / 2);
    }
    Semaphore semaphore;

    @Override
    public void go(Car c) {
        try {
            try {
                MainClass.println(c.getName() + " getting ready to stage (waiting): " + description);
                semaphore.acquire();
                MainClass.println(c.getName() + " started stage: " + description);
                Thread.sleep(1000 * length / c.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                MainClass.println(c.getName() + " finished stage: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
