package ru.gb.alekseev.exceptions;

public class Main {
    public static void main(String[] args) {

        String[][] arr1 = new String[][]
                {
                        {"1", "1", "1", "1"},
                        {"1", "1", "1", "1"},
                        {"1", "1", "1", "1"},
                        {"1", "1", "1", "1"},
                };

        String[][] arr2 = new String[][]
                {
                        {"1", "1", "1", "1"},
                        {"1", "1", "1", },
                        {"1", "1", "1", "1"},
                        {"1", "1", "1", "1"},
                };

        String[][] arr3 = new String[][]
                {
                        {"1", "1", "1", "1"},
                        {"1", "1", "1", "1"},
                        {"1", "1", "1", "1"},
                };

        String[][] arr4 = new String[][]
                {
                        {"1", "1", "1", "1"},
                        {"1", "1", "xxx", "1"},
                        {"1", "1", "1", "1"},
                        {"1", "1", "1", "1"},
                };

        safeCalculate(arr1);
        safeCalculate(arr2);
        safeCalculate(arr3);
        safeCalculate(arr4);
    }

    static void safeCalculate(String[][] arr){
        try {
            System.out.println("Sum is " + getSumOf4x4(arr));
        }
        catch (MyArraySizeException myArraySizeException){
            System.out.println("Incorrect array size");
        }
        catch (MyArrayDataException myArrayDataException){
            System.out.println("Incorrect data: " + myArrayDataException);
        }
        catch (Exception exception){
            System.out.println("Unknown exception occurred: " + exception);
        }
    }

    public static long getSumOf4x4(String[][] stringArray4x4){

        if (stringArray4x4.length != 4){
            throw new MyArraySizeException();
        }

        long sum = 0;

        for (int i = 0; i < 4; i++) {

            if (stringArray4x4[i].length != 4){
                throw new MyArraySizeException();
            }

            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(stringArray4x4[i][j]);
                }
                catch (Exception exception){
                    throw new MyArrayDataException(i, j ,exception);
                }
            }
        }
        return sum;
    }
}

