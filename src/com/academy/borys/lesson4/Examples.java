package com.academy.borys.lesson4;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.Random;

public class Examples {
    public static void main(String[] args) {
        int[] array = new int[1000000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        long start = System.currentTimeMillis();
        //bubbleSort(array);
      // mergeSort(array);
        Arrays.sort(array);
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    private static void bubbleSort(int[] array) {
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

    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int midIndex = array.length / 2;
        int[] left = new int[midIndex];
        int[] right = new int[array.length - midIndex];

        for (int i = 0; i < midIndex; i++) {
            left[i] = array[i];
        }
        for (int i = midIndex; i < array.length; i++) {
            right[i - midIndex] = array[i];
        }

        mergeSort(left);
        mergeSort(right);

        //merge
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        for (; i < left.length; i++, k++){
            array[k] = left[i];

        }
        for (; j < right.length; j++, k++){
            array[k] = right[j];

        }
    }

    public static int sum(int[] array, int index) {
        if (index == array.length) {
            return 0;
        } else {
            return array[index] + sum(array, index + 1);
        }
    }


    public static int binarySearch(int[] array, int value) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int midPosition = (start + end) / 2;
            int midValue = array[midPosition];

            if (midValue == value) {
                return midPosition;
            }

            if (midValue < value) {
                start = midPosition + 1;
            } else {
                end = midPosition - 1;
            }
        }
        return -1;
    }


    public static int findInArray(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
