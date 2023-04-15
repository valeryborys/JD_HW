package com.academy.borys.lesson4;

import java.util.Arrays;
import java.util.Random;
import  static java.lang.Math.*;

public class Algorithms {
    public static void main(String[] args) {
        int[] array = {11, 3, 8, 16, 9, 2, 14, 12, 7};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
        int i = binarySearch(array, 11);
        System.out.println(i);
        System.out.println( Arrays.binarySearch(array, 5));

        int[] bigArray = new int[5];
        Random random = new Random();
        for (int j = 0; j < bigArray.length; j++) {
            bigArray[j] = random.nextInt(10000);
        }
        //       System.out.println(Arrays.toString(bigArray));
        long start = System.currentTimeMillis();
        // bubbleSort(bigArray);
        //megreSort(bigArray);
       // quickSort(bigArray);
        // Arrays.sort(bigArray);
        awfulAlgorithm(bigArray);
        long end = System.currentTimeMillis(); // Bad approach!!!!!
        System.out.println(end - start);
        System.out.println(isSorted(bigArray));
        //   System.out.println(Arrays.toString(bigArray));

        //   Arrays.sort(bigArray);


    }



    public static int binarySearch(int[] array, int value) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middlePos = (start + end) / 2;
            int middleValue = array[middlePos];

            if (middleValue == value) {
                return middlePos;
            }

            if (middleValue < value) {
                start = middlePos + 1;
            } else {
                end = middlePos - 1;
            }
        }
        return -1;
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    //pos - индекс наименьшего элемента
                    pos = j;
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;
        }
    }

    public static void insertSort(int[] array) {
        int j;
        for (int i = 1; i < array.length; i++) {
            int toCheck = array[i];
            for (j = i; j > 0 && toCheck < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = toCheck;
        }
    }

    public static void bubbleSort(int[] array) {
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

    public static void megreSort(int[] array) {
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

        megreSort(left);
        megreSort(right);

        //merging
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

        for (; i < left.length; i++, k++) {
            array[k] = left[i];
        }
        for (; j < right.length; j++, k++) {
            array[k] = right[j];
        }

    }

//    public static void quickSort(int[] array) {
//        quickSort(array, 0, array.length-1);
//    }
//
//    public static void quickSort(int[] arr, int low, int high) {
//        if (low < high) {
//            int partitionIndex = partition(arr, low, high);
//            quickSort(arr, low, partitionIndex - 1);
//            quickSort(arr, partitionIndex + 1, high);
//        }
//    }
//
//    private static int partition(int[] arr, int low, int high) {
//        int pivot = arr[high];
//        int i = low - 1;
//        for (int j = low; j < high; j++) {
//            if (arr[j] <= pivot) {
//                i++;
//                swap(arr, i, j);
//            }
//        }
//        swap(arr, i + 1, high);
//        return i + 1;
//    }
//
//
//    private static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highIndex);

    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer < rightPointer) {

            // Walk from the left until we find a number greater than the pivot, or hit the right pointer.
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            // Walk from the right until we find a number less than the pivot, or hit the left pointer.
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }

        // This is different from what the video has, and fixes an issue where the last value could potentially be out of order.
        // Thanks to viewer Wilson Barbosa for suggesting the fix!
        if (array[leftPointer] > array[highIndex]) {
            swap(array, leftPointer, highIndex);
        } else {
            leftPointer = highIndex;
        }

        return leftPointer;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void awfulAlgorithm(int[] array) {
        Random random = new Random();
        while (!isSorted(array)) {
            int index1 = random.nextInt(array.length);
            int index2 = random.nextInt(array.length);
            swap(array, index1, index2);
        }
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) {
                return false;
            }
        }
        return true;
    }

    public static int sum(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        } else {
            return arr[index] + sum(arr, index + 1);
        }
    }
}
