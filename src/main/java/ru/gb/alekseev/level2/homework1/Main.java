package ru.gb.alekseev.level2.homework1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Course c = createCourse();// Создаем полосу препятствий
        Team team = createTeam(); // Создаем команду
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
    }

    private static Team createTeam() {
        return new Team( new Sportsman[]
                {
                        new Cat("Barsik", 300, 120) ,
                        new Human("Ivan", 1000, 200 ),
                        new Human("Piotr", 1500, 220 ),
                        new Robot("Alisa", Integer.MAX_VALUE, Integer.MAX_VALUE),
                }
        );
    }

    private static Course createCourse() {
        return new Course(new Difficulty[] {
                new Wall(100),
                new Track(100),
                new Wall(120),
                new Track(500),
                new Wall(140),
                new Track(1000),
                new Wall(150),
                new Track(2000),
        });
    }
}
