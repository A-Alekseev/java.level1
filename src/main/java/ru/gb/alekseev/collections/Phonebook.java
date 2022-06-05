package ru.gb.alekseev.collections;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {

    public Phonebook() {
        dictionary = new HashMap<>();
    }

    private HashMap<String, ArrayList<String>> dictionary;


    public void add(String name, String phone) {
        ArrayList<String> phonesList = dictionary.get(name);
        if (phonesList == null) {
            phonesList = new ArrayList<>();
        }
        phonesList.add(phone);
        dictionary.put(name, phonesList);
    }

    public String[] get(String name){
        ArrayList<String> phonesList = dictionary.get(name);
        return phonesList != null ? (String[]) phonesList.toArray() : new String[0];
    }

    @Override
    public String toString() {
        return dictionary.toString();
    }
}
