package ru.gb.alekseev;

import ru.gb.alekseev.fruits.Apple;
import ru.gb.alekseev.fruits.Box;
import ru.gb.alekseev.fruits.GoldenApple;
import ru.gb.alekseev.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SwapArrayElementsTest();
        ConvertArrayToArrayListTest();
        FruitsTests();
    }

    static void SwapArrayElementsTest(){
        System.out.println("Swapping array elements");
        Integer[] intArray = {0, 1, 2, 3, 4};
        System.out.println("Before : " + Arrays.toString(intArray));
        ArrayElements.swap(intArray, 1, 3 );
        System.out.println("After  : " + Arrays.toString(intArray));
        System.out.println();
    }

    private static void ConvertArrayToArrayListTest() {
        System.out.println("Converting array to ArrayList");
        Integer[] intArray = {0, 1, 2, 3, 4};
        System.out.println("Array     : " + Arrays.toString(intArray));
        ArrayList<Integer> arrayList = ArrayElements.toArrayList(intArray);
        System.out.println("ArrayList : " + arrayList.toString());
        System.out.println("ArrayList from null: " + ArrayElements.toArrayList(null).toString());
        System.out.println();
    }

    private static void FruitsTests() {
        BoxesMovingTest();
        BoxesComparingTest();
        GoldenAppleTest();
    }

    private static void BoxesMovingTest() {
        System.out.println("Moving fruits from box to another");
        Box<Orange> orangeBox1 = new Box<>(new Orange(), new Orange());
        Box<Orange> orangeBox2 = new Box<>(new Orange(), new Orange(), new Orange());
        System.out.println("Before : " + orangeBox1  + " and " + orangeBox2 );
        orangeBox2.moveTo(orangeBox1);
        System.out.println("After 1: " + orangeBox1  + " and " + orangeBox2 );
        orangeBox1.moveTo(orangeBox2);
        System.out.println("After 2: " + orangeBox1  + " and " + orangeBox2 );
        System.out.println();
    }

    private static void BoxesComparingTest() {
        System.out.println("Comparing boxes");
        Box<Orange> orangeBox = new Box<>(new Orange(), new Orange());
        Box<Apple> appleBox = new Box<>(new Apple(), new Apple(), new Apple());
        System.out.println("Result 1: " + orangeBox.compare(appleBox) );
        appleBox.add(new Apple());
        System.out.println("Result 2: " + orangeBox.compare(appleBox) );
        System.out.println();
    }

    private static void GoldenAppleTest() {
        System.out.println("testing GoldenApple");
        Box<Apple> appleBox = new Box<>(new Apple(), new Apple(), new Apple());
        appleBox.add(new GoldenApple()); //ok
        Box<GoldenApple> goldenAppleBox = new Box<>(new GoldenApple(), new GoldenApple());
        //goldenAppleBox.add(new Apple()); not builds
        System.out.println("OK");
        System.out.println();
    }
}
