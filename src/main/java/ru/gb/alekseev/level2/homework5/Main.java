package ru.gb.alekseev.level2.homework5;

import java.util.Arrays;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    private static float[] createArray() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1f);
        return arr;
    }

    public static void main(String[] args) {
        try {
            singleThreadCalculating();
            System.out.println();
            multiThreadCalculating();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void singleThreadCalculating() throws InterruptedException {
        float[] arr = createArray();
        System.out.println("Starting calculate in single thread ...");
//        long startTime = System.currentTimeMillis();
//        for (int i = 0; i < size; i++) {
//            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//        long taken = System.currentTimeMillis() - startTime;
        CalculatingArrayThread thread = new CalculatingArrayThread(arr);
        thread.start();
        thread.join();

        System.out.println("Calculating in single thread taken " + thread.getTakenTimeMs() + " ms.");
    }

    private static void multiThreadCalculating() throws InterruptedException {
        float[] arr = createArray();

        System.out.println("Starting calculate in two threads ...");

        long startSplitArrays = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        long splitTaken = System.currentTimeMillis() - startSplitArrays;

        CalculatingArrayThread thread1 = new CalculatingArrayThread(a1);
        CalculatingArrayThread thread2 = new CalculatingArrayThread(a1);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        long startJoinArrays = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        long joinArraysTaken = System.currentTimeMillis() - startJoinArrays;

        System.out.println("Splitting array taken " + splitTaken + " ms");
        System.out.println("Thread 1 taken " + thread1.getTakenTimeMs() + " ms");
        System.out.println("Thread 2 taken " + thread2.getTakenTimeMs() + " ms");
        System.out.println("Joining arrays taken " + joinArraysTaken + " ms");
        System.out.println("Total: " + (System.currentTimeMillis() - startSplitArrays)  + " ms");
    }
}


