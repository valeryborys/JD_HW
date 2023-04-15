package com.academy.borys.lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class Examples {
    public static void main(String[] args) {
//        String name = "Валерий";
//
//        int length = name.length();
//
//        String format = String.format("Меня зовут %s", name);
//
//        System.out.print(length);

        int[] array = {5,4,55,6,8,51,9,8,53,2};
        int i = linearSearch(array, 22);
        System.out.println(i);


    }


    private static void sort(int[] array) {
        boolean swap;
        int size = array.length - 1;
        do {
            swap = false;
            for (int i = 0; i < size; i++) {
                if (array[i + 1] < array[i]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    swap = true;
                }
            }
            size--;
        } while (swap);
    }


    public static int linearSearch( int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value){
                return i;
            }
        }
        return -1;
    }


    public static void printArray(String... a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
