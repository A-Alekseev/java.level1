package ru.gb.alekseev.collections;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        uniqueWords();

        System.out.println();
        System.out.println("Phonebook");
        testPhonebook();
    }

    //Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
    //телефонных номеров. В этот телефонный справочник с помощью метода add() можно
    //добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
    //учесть, что под одной фамилией может быть несколько телефонов
    private static void testPhonebook() {
        Phonebook pb = new Phonebook();
        pb.add("Ivanov", "123-123");
        pb.add("Petrov", "123-456-789");
        pb.add("Sidorov", "123-123");
        pb.add("Ivanov", "abc-def");

        System.out.println(pb);
    }


    //Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
    //вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    //Посчитать, сколько раз встречается каждое слово
    private static void uniqueWords() {
        String[] words = new String[]{
                "Oh", "no", "not", "me",
                "We", "never", "lost", "control",
                "Your", "face", "to", "face",
                "With", "The", "Man", "Who", "Sold", "The", "World"};

        HashMap<String, Integer> map = new HashMap(words.length);

        for (String word: words) {
            Integer oldCount = map.getOrDefault(word, 0);
            map.put(word, oldCount + 1);
        }

        System.out.println(map.size() + " unique words of " + words.length + ":");
        System.out.println(map.keySet());
        System.out.println("Counts:");
        System.out.println(map);
    }


}

