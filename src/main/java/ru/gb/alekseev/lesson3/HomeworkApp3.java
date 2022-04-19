package ru.gb.alekseev.lesson3;

import java.util.Arrays;
import java.util.Random;

public class HomeworkApp3 {
    public static void main(String[] args) {

        //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("Task 1");
        int[] arr1 = generateRandomArray(10, 2);
        System.out.println(Arrays.toString(arr1));
        invertArrayItems(arr1);
        System.out.println(Arrays.toString(arr1));

        //2. Задать пустой целочисленный массив длиной 100.
        // С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
        System.out.println("\n" + "Task 2");
        int[] arr2 = generateSequencedArray(100);
        System.out.println(Arrays.toString(arr2));

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        // пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("\n" + "Task 3");
        runTask3();

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами
        // (можно только одну из диагоналей, если обе сложно).
        // Определить элементы одной из диагоналей можно по следующему принципу:
        // индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
        System.out.println("\n" + "Task 4");
        int[][] dArr = generateDiagonalsArray(7);
        for (int i = 0; i < dArr.length; i++) {
            printArray(dArr[i]);
        }

        //Написать метод, принимающий на вход два аргумента: len и initialValue,
        // и возвращающий одномерный массив типа int длиной len,
        // каждая ячейка которого равна initialValue;
        System.out.println("\n" + "Task 5");
        printArray(generateAndFillArray(10, 152));
    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%4d", arr[i]);
        }
        System.out.println();
    }

    public static int[] generateRandomArray(int length, int highBound){
        int[] arr = new int[length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new Random().nextInt(highBound);
        }
        return arr;
    }

    public static void invertArrayItems(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == 0){
                arr[i] = 1;
            }
            else if (arr[i] == 1){
                arr[i] = 0;
            }
        }
    }

    public static int[] generateSequencedArray(int length){
        int[] arr = new int[length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }
        return arr;
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    // пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void runTask3()    {
        int[] arr = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        printArray(arr);
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] < 6){
                arr[i] *= 2;
            }
        }
        printArray(arr);
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами
    // (можно только одну из диагоналей, если обе сложно).
    // Определить элементы одной из диагоналей можно по следующему принципу:
    // индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
    public static int[][] generateDiagonalsArray(int size) {
        int[][] aa = new int[size][size];
        for (int i = 0; i< size; i++){
            aa[i][i] = 1;
            aa[i][size - i - 1] = 1;
        }
        return aa;
    }

    //Написать метод, принимающий на вход два аргумента: len и initialValue,
    // и возвращающий одномерный массив типа int длиной len,
    // каждая ячейка которого равна initialValue;
    public static int[] generateAndFillArray(int len, int initialValue){
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }
}
