package zuochengyun_system.class05;

import java.util.Random;

public class Code03_QuickSort_2 {
    public static void sortArray(int[] arr) {
        if (arr == null || arr.length < 2) return;
        process(arr, 0, arr.length - 1);
    }

    private static int[] partition(int[] arr, int L, int R) {
        if(L>R)return new int[]{-1,-1};
        if (L == R) return new int[]{L, L};
        int left = L - 1, cur = L, right = R;
        while (cur != right) {
            if (arr[cur] < arr[R]) {
                swap(arr, cur++, ++left);
            } else if (arr[cur] == arr[R]) {
                cur++;
            } else {
                swap(arr, cur, --right);
            }
        }
        swap(arr, right, R);
        return new int[]{left, right};
    }

    private static void process(int[] arr, int L, int R) {
        if (L >= R) return;
        int[] indexes = partition(arr, L, R);
        process(arr, L, indexes[0]);
        process(arr, indexes[1], R);
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
        Code03_QuickSort_2.sortArray(arr);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
