package ru.gb.alekseev.homework4;

import java.util.Random;
import java.util.Scanner;

public class HomeworkApp4 {

    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 2;

    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static Random rand = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void main(String[] args) {
        initMap();
        printMap();
        startMainCycle();
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Computer step is " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Input coordinates in X Y format");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char symb) {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (map[y][x] != symb) {
                    continue;
                }
                if (checkAllDirections(symb, y, x)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkAllDirections(char symb, int startY, int startX) {
        //calculating right
        int count = 0;
        for (int x = startX; x < SIZE; x++) {
            if(map[startY][x] == symb){
                count++;
            }
            else{
                break;
            }
            if(count >= DOTS_TO_WIN)
                return true;
        }

        //calculating down
        count = 0;
        for (int y = startY; y < SIZE; y++) {
            if (map[y][startX] == symb){
                count++;
            }
            else{
                break;
            }
            if(count >= DOTS_TO_WIN)
                return true;
        }

        //calculating right-down
        count = 0;
        for (int y = startY, x = startX; x < SIZE && y < SIZE; x++, y++) {
            if (map[y][x] == symb){
                count++;
            }
            else{
                break;
            }
            if(count >= DOTS_TO_WIN)
                return true;
        }

        //calculating left-down
        count = 0;
        for (int y = startY, x = startX; x >= 0 && y < SIZE; x--, y++) {
            if (map[y][x] == symb){
                count++;
            }
            else{
                break;
            }
            if(count >= DOTS_TO_WIN)
                return true;
        }

        return false;
    }

    private static void startMainCycle() {
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Human win");
                break;
            }
            if (isMapFull()) {
                System.out.println("Equality");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("AI win");
                break;
            }
            if (isMapFull()) {
                System.out.println("Equality");
                break;
            }
        }
        System.out.println("Game over");
    }
}
