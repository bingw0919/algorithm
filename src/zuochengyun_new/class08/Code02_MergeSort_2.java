package zuochengyun_new.class08;

public class Code02_MergeSort_2 {

    // 递归方法实现
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int len = arr.length, step = 1;
        while (step < len) {
            int L = 0, M = 0, R = 0;
            while (L < len - step * 2) {
                M = L + step - 1;
                R = L + step * 2 - 1;
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (L + step < len) {
                M = L + step - 1;
                R = len - 1;
                merge(arr, L, M, R);
            }
            if (step <= len / 2)
                step *= 2;
            else break;
        }
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] tmp = new int[R - L + 1];
        int p1 = L, p2 = M + 1, p = 0;
        while (p1 <= M && p2 <= R) {
            if (arr[p1] <= arr[p2])
                tmp[p++] = arr[p1++];
            else
                tmp[p++] = arr[p2++];
        }
        while (p1 <= M) tmp[p++] = arr[p1++];
        while (p2 <= R) tmp[p++] = arr[p2++];
        for (int i = 0; i < tmp.length; i++) {
            arr[L + i] = tmp[i];
        }
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            insertSort(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 插入排序
     *
     * @param arr 数组
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        //对前i个数排序
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }
}
