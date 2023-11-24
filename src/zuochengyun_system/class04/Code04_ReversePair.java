package zuochengyun_system.class04;

public class Code04_ReversePair {

    public static int reverPairNumber(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if (L >= R) return 0;
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid) +
                process(arr, mid + 1, R) +
                merge(arr, L, mid, R);
    }

    private static int merge(int[] arr, int L, int M, int R) {
        int cur1 = L, cur2 = M + 1, tmpCur = 0, ans = 0;
        int[] tmp = new int[R - L + 1];
        while (cur1 <= M && cur2 <= R) {
            //寻找右侧最后一个小于左侧的数
            while (cur2 <= R && arr[cur2] < arr[cur1]) cur2++;
            ans += (cur2 - M - 1);
            cur1++;
        }
        if (cur1 <= M) ans += (M - cur1 + 1) * (cur2 - M - 1);
        cur1 = L;
        cur2 = M + 1;
        while (cur1 <= M && cur2 <= R) {
            if (arr[cur1] < arr[cur2]) {
                tmp[tmpCur++] = arr[cur1++];
            } else {
                tmp[tmpCur++] = arr[cur2++];
            }
        }
        while (cur1 <= M) {
            tmp[tmpCur++] = arr[cur1++];
        }
        while (cur2 <= R) {
            tmp[tmpCur++] = arr[cur2++];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[L + i] = tmp[i];
        }
        return ans;
    }

    //=================example code start ===========================================================
    public static int reverPairNumber1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process1(arr, 0, arr.length - 1);
    }

    // arr[L..R]既要排好序，也要求逆序对数量返回
    // 所有merge时，产生的逆序对数量，累加，返回
    // 左 排序 merge并产生逆序对数量
    // 右 排序 merge并产生逆序对数量
    public static int process1(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        // l < r
        int mid = l + ((r - l) >> 1);
        return process1(arr, l, mid) + process1(arr, mid + 1, r) + merge1(arr, l, mid, r);
    }

    public static int merge1(int[] arr, int L, int m, int r) {
        int[] help = new int[r - L + 1];
        int i = help.length - 1;
        int p1 = m;
        int p2 = r;
        int res = 0;
        while (p1 >= L && p2 > m) {
            res += arr[p1] > arr[p2] ? (p2 - m) : 0;
            help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while (p1 >= L) {
            help[i--] = arr[p1--];
        }
        while (p2 > m) {
            help[i--] = arr[p2--];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }
//=================example code end ===========================================================


    // for test
    public static int comparator(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    ans++;
                }
            }
        }
        return ans;
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
        int testTime = 100;
        int maxSize = 10000;
        int maxValue = 100;
        long time1 = 0, time2 = 0, time3 = 0;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);

            long start = System.currentTimeMillis();
            int res1 = reverPairNumber(arr1);
            long end = System.currentTimeMillis();
            time1 += end - start;

            start = System.currentTimeMillis();
            int res2 = comparator(arr2);
            end = System.currentTimeMillis();
            time2 += end - start;

            start = System.currentTimeMillis();
            int res3 = reverPairNumber1(arr3);
            end = System.currentTimeMillis();
            time3 += end - start;

            if (res1 != res2||res1!=res3) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                System.out.println(res1);
                System.out.println(res2);
                System.out.println(res3);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        System.out.println("time1=" + time1);
        System.out.println("time2=" + time2);
        System.out.println("time3=" + time3);
    }

}
