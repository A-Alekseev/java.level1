package ru.gb.alekseev.homework6;

//1. Создать классы Собака и Кот с наследованием от класса Животное.
//2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
// Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//4. * Добавить подсчет созданных котов, собак и животных.

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Mursic"),
                new Dog("Bobic"),
        };

        for (int length: new int[] { 10, 300, 600}
             ) {
            System.out.println("Running " + length + " m:" );
            for (Animal animal  : animals){
                animal.run(length);
            }
            System.out.println();
        }

        for (int length: new int[] { 5, 300}
        ) {
            System.out.println("Swimming " + length + " m:" );
            for (Animal animal  : animals){
                animal.run(length);
            }
            System.out.println();
        }

    }
}
