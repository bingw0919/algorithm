package class03;

public class Code03_BSNearRight {
    /**
     * 有序数组中寻找最右侧<=num的数
     *
     * @param arr 数组
     * @param num 待查数字
     * @return 结果
     */
    public static int nearestIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) return -1;
        int L = 0, R = arr.length - 1, mid, ans = -1;
        while (L <= R) {
            mid = L + (R - L) / 2;
            if (arr[mid] <= num) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 4, 5, 5, 6, 7, 9};
        System.out.println(nearestIndex(arr, 3));//3
        System.out.println(nearestIndex(arr, 5));//6
        System.out.println(nearestIndex(arr, 8));//10
    }
}
