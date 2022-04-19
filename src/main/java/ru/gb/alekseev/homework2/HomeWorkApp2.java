package ru.gb.alekseev.homework2;

public class HomeWorkApp2 {
    public static void main(String[] args) {
        System.out.println("Task 1");
        System.out.println(isSumBetween10And20(2147483647, 2147483646));
        System.out.println(isSumBetween10And20(5, 5));
        System.out.println(isSumBetween10And20(-5, -5));

        System.out.println();
        System.out.println("Task 2");
        printNumberSign(-5);
        printNumberSign(10);

        System.out.println();
        System.out.println("Task 3");
        System.out.println("-5 - " + isNumberNegative(-5));
        System.out.println("5 - " + isNumberNegative(5));
        System.out.println("0 - " + isNumberNegative(0));

        System.out.println();
        System.out.println("Task 4");
        printAmountLines("my string to print", 3);

        System.out.println();
        System.out.println("Task 5");
        System.out.println("1900 - " + isLeapYear(1900));
        System.out.println("2000 - " + isLeapYear(2000));
        System.out.println("2022 - " + isLeapYear(2022));
        System.out.println("1955 - " + isLeapYear(1955));
        System.out.println("1980 - " + isLeapYear(1980));
    }

    //если сумма лежит в пределах от 10 до 20 (включительно), вернуть true, в противном случае – false.
    public static boolean isSumBetween10And20(int a, int b) {
        int lowerBound = 10;
        int higherBound = 20;

        //why long? - because if a and b is near 2147483647 (int maximum), then sum can be negative
        //it's ok if lowerBound = 10, but if lowerBound = -10 result can be unexpected
        long sum = (long) a + (long) b;
        return sum >= lowerBound && sum <= higherBound;
    }

    //2. Написать метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    // Замечание: ноль считаем положительным числом.
    public static void printNumberSign(int a) {
        String sign = a + (a < 0 ? " is negative" : " is positive");
        System.out.println(sign);
    }

    //3. Написать метод, которому в качестве параметра передается целое число.
    // Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    public static boolean isNumberNegative(int a) {
        return a < 0;
    }

    //4. Написать метод, которому в качестве аргументов передается строка и число,
    // метод должен отпечатать в консоль указанную строку, указанное количество раз;
    public static void printAmountLines(String line, int number) {
        for (int i = 0; i < number; i++) {
            System.out.println(line);
        }
    }

    //5. * Написать метод, который определяет, является ли год високосным,
    // и возвращает boolean (високосный - true, не високосный - false).
    // Каждый 4-й год является високосным, кроме каждого 100-го,
    // при этом каждый 400-й – високосный.
    public static boolean isLeapYear(int year) {

        //Gregorian calendar was found in 1582
        if (year < 1582){
            return false;
        }

        //Каждый 4-й год является високосным кроме каждого 100-го,
        if (year % 4 != 0 ) {
            return false;
        }

        //при этом каждый 400-й – високосный.
        if (year % 400 == 0){
            return true;
        }

        //кроме каждого 100-го,
        if (year % 100 == 0){
            return false;
        }

        return true;
    }
}
