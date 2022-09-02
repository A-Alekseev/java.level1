package ru.gb.alekseev;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayElements {

    //Swaps two elements of array
    public static <E> void swap(E[] array, int firstIndex, int secondIndex) {
        E storage = array[firstIndex];
        array[firstIndex] = array[secondIndex]; //if secondIndex out of bounds, array[firstIndex] not changed, ok
        array[secondIndex] = storage;
    }

    public static <E> ArrayList<E> toArrayList(E[] array) {
        return array != null
                ? new ArrayList<>(Arrays.asList(array))
                : new ArrayList<E>();
    }
}
