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

        //6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
        System.out.println("\n" + "Task 6");
        int[] arr6 = generateRandomArray(10, 100);
        printArray(arr6);
        System.out.println("min = " + getMinArrayItem(arr6));
        System.out.println("max = " + getMaxArrayItem(arr6));

        //7
        System.out.println("\n" + "Task 7");
        int[] arr71 = new int[] {2, 2, 2, 1, 2, 2, 10, 1};
        printArray(arr71);
        System.out.println(checkBalance(arr71));

        int[] arr72 = new int[] {1, 1, 1, 2, 1};
        printArray(arr72);
        System.out.println(checkBalance(arr72));

        int[] arr73 = new int[] {1, 1, 1, 1, 100};
        printArray(arr73);
        System.out.println(checkBalance(arr73));

        //8
        System.out.println("\n" + "Task 8");
        int[] arr8 = generateRandomArray(5, 100);
        printArray(arr8);
        shiftArray(arr8, -2);
        printArray(arr8);
        shiftArray(arr8, 3);
    }

    //printing array with spaces
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%4d", arr[i]);
        }
        System.out.println();
    }

    //generates random array
    public static int[] generateRandomArray(int length, int highBound){
        int[] arr = new int[length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new Random().nextInt(highBound);
        }
        return arr;
    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
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

    //2. Задать пустой целочисленный массив длиной 100.
    // С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
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

    //finds minimal item in array
    public static int getMinArrayItem(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    //finds maximal item in array
    public static int getMaxArrayItem(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    //7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место,
    // в котором сумма левой и правой части массива равны.
    public static boolean checkBalance(int[] arr){
        if (arr.length <= 1)
            return false;

        for (int i = 0; i < arr.length - 1; i++){
            long leftSum = calculateSubArraySum(arr, 0, i);
            long rightSum = calculateSubArraySum(arr, i + 1, arr.length - 1);
            if (leftSum == rightSum){
                return true;
            }
        }
        return false;
    }

    public static long calculateSubArraySum(int[] arr, int leftIndex, int rightIndex){
        long sum = 0;
        for (int i = leftIndex; i <= rightIndex; i++){
            sum+=(long)arr[i];
        }
        return sum;
    }


    //8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры:
    // [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    // [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.
    public static void shiftArray(int[] arr, int steps){
        for (int i = 1; i <= Math.abs(steps); i++){
            if(steps > 0){
                shiftArrayRightOnce(arr);
            }
            else if (steps < 0){
                shiftArrayLeftOnce(arr);
            }
        }
    }

    public static void shiftArrayLeftOnce(int[] arr){
        int temp = arr[0];
        for (int i = 0; i< arr.length - 1; i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length - 1] = temp;
    }

    public static void shiftArrayRightOnce(int[] arr){
        int temp = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0 ; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }
}
