package zuochengyun_system.class05;

import java.util.Random;

public class QuickSort_1 {
    public static void sortArray(int[] arr) {
        if (arr == null || arr.length < 2) return;
        process(arr,0,arr.length-1);
    }

    private static int partition(int[] arr, int L, int R) {
        if (L == R) return L;
        int leftMin = L - 1, cur = L, tmp = arr[R];
        while (cur < R) {
            if (arr[cur] <= tmp) {
                swap(arr, cur, ++leftMin);
            }
            cur++;
        }
        swap(arr, ++leftMin, R);
        return leftMin;
    }

    private static void process(int[] arr, int L, int R) {
        if (L >= R) return;
        int mid = partition(arr, L, R);
        process(arr, L, mid - 1);
        process(arr, mid + 1, R);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        boolean flag = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) flag = true;
        }
        System.out.println(flag);
        QuickSort_1.sortArray(arr);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
