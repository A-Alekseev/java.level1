package ru.gb.alekseev.homework1;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
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

    //Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”,
    // если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
    // если больше 100 (100 исключительно) - “Зеленый”;
     static void printColor() {
         int value = 15;
         if (value <= 0) {
             System.out.println("Красный");
         } else if (value > 0 && value <= 100) {
             System.out.println("Желтый");
         } else {
             System.out.println("Зеленый");
         }
     }

     //Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
    public static void compareNumbers(){
       int a = 1500;
       int b = 150;
       if (a>=b){
           System.out.println(a + " >= " + b);
       }
       else {
           System.out.println(a + " < " + b);
       }
    }
}
