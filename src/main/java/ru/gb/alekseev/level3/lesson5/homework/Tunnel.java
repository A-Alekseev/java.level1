package ru.gb.alekseev.level3.lesson5.homework;

public class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "Tunnel " + length + " meters";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " getting ready to stage (waiting): " + description);
                System.out.println(c.getName() + " started stage: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " finished stage: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
