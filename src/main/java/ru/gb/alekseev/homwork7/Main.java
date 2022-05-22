package ru.gb.alekseev.homwork7;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(30);
        Cat[] cats = new Cat[]{
                new Cat("Barsik", 5),
                new Cat("Mursik", 10),
                new Cat("Fatboy", 20),
        };

        letCatsEat(cats, plate);
        printCatsFullness(cats);
        System.out.println();

        plate.encreaseFood(50);
        letCatsEat(cats, plate);
        printCatsFullness(cats);
    }

    static void letCatsEat(Cat[] cats, Plate plate){
        System.out.println("Before cats eat " + plate);
        for (Cat cat : cats) {
            cat.eat(plate);
        }
        System.out.println("After cats eat " + plate);
    }

    static void printCatsFullness(Cat[] cats){
        for (Cat cat : cats) {
            System.out.println(cat + " is " + (cat.getFullness() ? "full" : "hungry"));
        }
    }
}
