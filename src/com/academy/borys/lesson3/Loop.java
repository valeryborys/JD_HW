package com.academy.borys.lesson3;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Loop {

    public static void main(String[] args) {

        boolean condition = false;

        while (condition) {
            //do smth
        }
//------------------------------------------
        do {
            //do smth
        } while (condition);

//------------------------------------------
//        Scanner scanner = new Scanner(System.in);
//        int i = 0; // обратите внимание что i=0 не удовлетворяет условию цикла!
//        do {
//            System.out.println("Введите число от 1 до 5");
//            i = scanner.nextInt();
//        } while (i < 1 || i > 5);
//        System.out.println("Завершение программы");
//------------------------------------------

//        for (initialisation; condition; iteration) {
//            //body
//        }

//        for (int j = 0, k = 10; j < k; j++, k--) {
//            System.out.println("j=" + j);
//            System.out.println("k=" + k);
//        }
        //-----------------------------

//        for (int i = 0; i < 100; i++) {
//            if (i == 10) {
//                System.out.println("Срочный выход из цикла");
//                break;
//            }
//        }
//        System.out.println("Завершение программы");

//-------------------------------------------------------
//        System.out.println("Выведем только нечетные");
//        for (int i = 0; i < 10; i++) {
//            if (i % 2 == 0) {
//                continue;
//            }
//            System.out.println(i);
//        }

        //----------------------------------------


//        int array[] = {1,5,8,2,0};
//        Arrays.sort(array);
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//
//        }
        //------------------------------------------

//        int array[] = new int[5];
//        int len = array.length; // = 5

        //--------------------------------

//        int array[] = new int[5];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = i * 10;
//        }
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }


        //-------------------------------------

//        int twoDimentions[][] = new int[5][4];
//
//
//        twoDimentions[0] = new int[3];
//        twoDimentions[0] = new int[2];
//        twoDimentions[0] = new int[8];
//----------------------------------------

//        int array[][] = {
//                {1, 2, 3}, {7, 8, 9}, {12, 15, 16}
//        };
//
//        double random = Math.random();
//        System.out.println((int)random * 10);


        //--------------------------------

//        int array[][] = new int[3][3];
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                array[i][j] = i * 10 + j;
//            }
//        }
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                System.out.println(array[i][j]);
//            }
//        }

        //---------------------------------------

//        int counter = 10;
//        int array[] = new int[10];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = counter++;
//        }
//
//
//        for (int variable : array) {
//            System.out.println(variable);
//        }

        //----------------------------------

//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        String trim = s.trim();
//        String[] stringArray = trim.split(" ");
//        int array[] = new int[stringArray.length];
//        for (int i = 0; i < stringArray.length; i++) {
//            array[i] = Integer.valueOf(stringArray[i]);
//        }


        //------------------------------------------------------

      //  System.out.printf("Число ПИ = %1$+020.10f", Math.PI);
 ///-----------------------------------------------

//        int[] array = {10,8,5,6,2,1};
//        sort(array);
//        System.out.println(Arrays.toString(array));
        //--------------------------
//        int[] array = {10,8,5,6,5,1};
//        findIndex(5, array);
        //-----------------------------------

        int[] array = {10,8,5,6,5,1};
        int[] ints = Arrays.copyOf(array, 15);
        System.out.println(Arrays.toString(ints));

    }

    public static void print() {
        System.out.println("данный метод ничего не возвращает (void)");
        return;
    }

    public static String getHint(int number) {
        String result = number % 5 == 0 ? "Делится на 5" : "Не делится на 5";
        return result;
    }

    public static void sort(int[] array) {
        boolean swap = false;
        int size = array.length -1;
        do {
            swap = false;
            for (int i = 0; i < size; i++) {
                if (array[i + 1] < array[i]) {
                    int temp = array[i + 1];
                    array[i+1] = array[i];
                    array[i] = temp;
                    swap = true;
                }
            }
            size--;
        } while (swap);
    }

    public static void findIndex(int number, int[] array) {
        boolean isFound = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                System.out.println(i);
                isFound = true;
                continue;
            }
        }
        if (!isFound) System.out.println("Нет такого числа в массиве");
    }

}
