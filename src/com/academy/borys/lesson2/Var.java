package com.academy.borys.lesson2;

public class Var {
    public static int globalVariable = 5;
    public static void main(String[] args) {
        int x = 6;
        int y = 10;
        if (checkIfMoreThanGlobal(x)) {
            int sum = x;
            y += x;
        }
        System.out.println(y);
    }

    public static boolean checkIfMoreThanGlobal(int number) {
        return number > globalVariable;
    }
}


