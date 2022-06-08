package ru.gb.alekseev.level2.homework5;

public class CalculatingArrayThread extends Thread {
    private float[] arr;
    private long takenTimeMs;

    public CalculatingArrayThread(float[] array) {
        this.arr = array;
    }

    @Override
    public void run() {
        int size = arr.length; //may be access to field takes time?

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        takenTimeMs = System.currentTimeMillis() - startTime;
    }

    public long getTakenTimeMs() {
        return takenTimeMs;
    }
}
