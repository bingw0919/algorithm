package class03;

public class Code02_BSNearLeft {
    /**
     * 有序数组中寻找最左侧>=num的数
     * @param arr 数组
     * @param num 待查数字
     * @return 结果
     */
    public static int mostLeftNoLessNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) return -1;
        int L = 0, R = arr.length - 1, mid, ans = -1;
        while (L <= R) {
            mid = (L + R) / 2;
            if (arr[mid] <= num) {
                L = mid + 1;
            } else {
                R = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 4, 5, 5, 6, 7};
        System.out.println(mostLeftNoLessNumIndex(arr, 2));//4
        System.out.println(mostLeftNoLessNumIndex(arr, 5 ));//9
    }
}
