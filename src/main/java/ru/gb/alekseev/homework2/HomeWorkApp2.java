package ru.gb.alekseev.homework2;

public class HomeWorkApp2 {
    public static void main(String[] args) {
        System.out.println(isSumBetween10And20(2147483647, 2147483646));
        System.out.println(isSumBetween10And20(5, 5));
        System.out.println(isSumBetween10And20(-5, -5));
        printNumberSign(-5);
        printNumberSign(10);

    }

    //если сумма лежит в пределах от 10 до 20 (включительно), вернуть true, в противном случае – false.
    public static boolean isSumBetween10And20(int a, int b){
        int lowerBound = 10;
        int higherBound = 20;

        //why long? - because if a and b is near 2147483647 (int maximum), then sum can be negative
        //it's ok if lowerBound = 10, but if lowerBound = -10 result can be unexpected
        long sum = (long)a + (long)b;
        return sum >= lowerBound && sum <= higherBound;
    }

    //2. Написать метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    // Замечание: ноль считаем положительным числом.
    public static void printNumberSign(int a){
        String sign = a + (a < 0 ? " is negative" : " is positive");
        System.out.println(sign);
    }
}
