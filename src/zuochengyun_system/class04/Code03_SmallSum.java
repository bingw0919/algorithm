package zuochengyun_system.class04;

public class Code03_SmallSum {
    private static int res = 0;

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        process(arr, 0, arr.length - 1);
        return res;
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) return;
        int mid = L + (R - L) / 2;
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int cur1 = L, cur2 = M + 1, tmpCur = 0;
        int[] tmp = new int[R - L + 1];
        while (cur1 <= M && cur2 <= R) {
            if (arr[cur1] < arr[cur2]) {
                res += arr[cur1] * (R - cur2 + 1);
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
    }

    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
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
        int testTime = 500;
        int maxSize = 30000;
        int maxValue = 100;
        long time1=0,time2=0;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

            long start = System.currentTimeMillis();
            int res1=smallSum(arr1);
            long end = System.currentTimeMillis();
            time1+=end-start;

            start = System.currentTimeMillis();
            int res2=comparator(arr2);
            end = System.currentTimeMillis();
            time2+=end-start;

            if ( res1!= res2) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
            res = 0;
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        System.out.println("time1="+time1);
        System.out.println("time2="+time2);
    }

}
