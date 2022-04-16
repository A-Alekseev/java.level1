package ru.gb.alekseev.homework1;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
    }

    //при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    //если сумма больше или равна 0, то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”
    public static void checkSumSign(){
        int a = 15;
        int b = -150;
        if (a + b >= 0){
            System.out.println("Сумма положительная");
        }
        else{
            System.out.println("Сумма отрицательная");
        }
    }

}
