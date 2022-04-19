package ru.gb.alekseev.lesson3;

import java.util.Arrays;
import java.util.Random;

public class HomeworkApp3 {
    public static void main(String[] args) {

        //1
        int[] arr = generateRandomArray(10, 2);
        System.out.println(Arrays.toString(arr));
        invertArrayItems(arr);
        System.out.println(Arrays.toString(arr));

    }

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
}
