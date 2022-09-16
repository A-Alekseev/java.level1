package ru.gb.alekseev.level3.lesson5.homework;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Road " + length + " meters";
    }

    @Override
    public void go(Car c) {
        try {
            MainClass.println(c.getName() + " started stage: " + description);
            Thread.sleep(1000 * length / c.getSpeed());
            MainClass.println(c.getName() + " finished stage: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
