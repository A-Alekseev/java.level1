package ru.gb.alekseev.fruits;

import ru.gb.alekseev.ArrayElements;

import java.util.ArrayList;
import java.util.Optional;

public class Box <T extends Fruit> {

    public Box(T... fruits) {
        fruitsList = ArrayElements.toArrayList(fruits);
    }

    ArrayList<T> fruitsList;

    public float getWeight() {
        Optional<Float> w = fruitsList.stream().map(f -> f.getWeight())
                .reduce((w1, w2) -> w1 + w2);
        return w.orElse(0f);
    }

    public Boolean compare(Box box){
        return Float.compare(this.getWeight(), box.getWeight()) == 0;
    }

    public void moveTo(Box<T> box){
        box.fruitsList.addAll(this.fruitsList);
        this.fruitsList.clear();
    }

    public void add(T... fruit){
        fruitsList.addAll(ArrayElements.toArrayList(fruit));
    }

    @Override
    public String toString() {
        return "Box of " + fruitsList.size() + " fruits";
    }
}
