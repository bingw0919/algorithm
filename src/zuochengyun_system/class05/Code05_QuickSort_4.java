package zuochengyun_system.class05;

import java.util.Random;
import java.util.Stack;

public class Code05_QuickSort_4 {
    public static void sortArray(int[] arr) {
        if (arr == null || arr.length < 2) return;
        Stack<Integer[]> stack = new Stack<>();
        int L = 0, R = arr.length - 1;
        stack.push(new Integer[]{L, R});
        while (!stack.isEmpty()) {
            Integer[] indexes = stack.pop();
            L = indexes[0];
            R = indexes[1];
            if (L >= R) continue;
            swap(arr, R, L + (int) (Math.random() * (R - L + 1)));
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
            stack.push(new Integer[]{L, left});
            stack.push(new Integer[]{right, R});
        }
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
        Code05_QuickSort_4.sortArray(arr);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
