package ru.gb.alekseev.collections;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        UniqueWords();

    }

    private static void UniqueWords() {
        String[] words = new String[]{
                "Oh", "no", "not", "me",
                "We", "never", "lost", "control",
                "Your", "face", "to", "face",
                "With", "The", "Man", "Who", "Sold", "The", "World"};

        HashMap<String, Integer> map = new HashMap(words.length);

        for (String word: words) {
            Integer oldCount = map.getOrDefault(word, 0);
            map.put(word, oldCount+1);

        }

        System.out.println(map.size() + " unique words of " + words.length + ":");
        System.out.println(map.keySet());
        System.out.println("Counts:");
        System.out.println(map);
    }
}
