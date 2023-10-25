package zuochengyun_bilibili.p3;

import java.util.Random;

public class Code01_BubbleSort {
    public static void main(String[] args) {
        int[] arr=new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]= random.nextInt(100);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr 数组
     */
    public static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr,j,j+1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int num = arr[i];
        arr[i] = arr[j];
        arr[j] = num;
    }
}
