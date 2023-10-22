package class01;

import java.util.Random;

public class Code03_BubbleSort {
    /**
     * 打印数组
     * @param arr 数组
     */
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 冒泡排序
     *
     * @param arr 数组
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        printArray(arr);
        sort(arr);
        printArray(arr);
    }
}
