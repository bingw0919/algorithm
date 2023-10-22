package zuochengyun_new.class02;

import java.util.Arrays;

/**
 * 前缀和数组
 */
public class Code01_PreSum {
    /**
     * 多次获取数组中l->r的求和a
     *
     * @param arr 数组
     * @return 二维数组保存l->r的求和取值
     */
    public static int[][] sum1(int[] arr) {
        int[][] sumArr = new int[arr.length][arr.length];
        for (int[] nums : sumArr) {
            Arrays.fill(nums, 0);
        }
        for (int i = 0; i < sumArr.length; i++) {
            sumArr[i][i] = arr[i];
            for (int j = i + 1; j < sumArr.length; j++) {
                sumArr[i][j] = sumArr[i][j - 1] + arr[j];
            }
        }
        for (int i = 0; i < sumArr.length; i++) {
            for (int j = 0; j < sumArr.length; j++) {
                System.out.print(sumArr[i][j] + "\t");
            }
            System.out.println();
        }
        return sumArr;
    }

    /**
     * 多次获取数组中l->r的求和
     *
     * @param arr 数组
     * @return 一维数组保存l->r的求和取值
     */
    public static int[] sum2(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] sumArr = new int[arr.length];
        sumArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }
        for (int i = 0; i < sumArr.length; i++) {
            System.out.print(sumArr[i] + " ");
        }
        System.out.println();
        return sumArr;
    }

    public static int getSum1(int[] arr, int left, int right) {
        int[][] sum1 = sum1(arr);
        return sum1[left][right];
    }

    public static int getSum2(int[] arr, int left, int right) {
        int[] sum2 = sum2(arr);
        return left == 0 ? sum2[right] : sum2[right] - sum2[left - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 3, 9, 8, 2, 4, 3};
        System.out.println(getSum1(arr, 2, 5));
        System.out.println("====================");
        System.out.println(getSum2(arr, 2, 5));
    }
}


