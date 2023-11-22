package zuochengyun_system.class04;

public class Code05_BiggerThanRightTwice {
    public static int res = 0;

    public static int biggerTwice(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        process(arr, 0, arr.length - 1);
        return res;
    }

    private static void process(int[] arr, int L, int R) {
        int mid = L + (R - L) / 2;
        if (L >= R) return;
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int cur1 = L, cur2 = M + 1, tmpCur = 0;
        int[] tmp = new int[R - L + 1];
        while (cur1 <= M) {
            if(cur2==M){
                res+=(cur1-L+1)*(cur2 - M - 1);
                break;
            }
            while (cur2 <= R && arr[cur1] > 2 * arr[cur2]) {
                cur2++;
            }
            res += (cur2 - M - 1);
            cur1++;
        }
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
    }


    // for test
    public static int comparator(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > (arr[j] << 1)) {
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
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
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
        int testTime = 50;
        int maxSize = 100000;
        int maxValue = 100;
        long time1=0,time2=0;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            res = 0;
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            long start = System.currentTimeMillis();
            int res1=biggerTwice(arr1);
            long end = System.currentTimeMillis();
            time1+=end-start;

            start = System.currentTimeMillis();
            int res2=comparator(arr2);
            end = System.currentTimeMillis();
            time2+=end-start;
            if (res1 != res2) {
                System.out.println("Oops!");
                printArray(arr1);
                printArray(arr2);
                System.out.println(res1);
                System.out.println(res2);
                break;
            }
        }
        System.out.println("测试结束");
        System.out.println("time1="+time1);
        System.out.println("time2="+time2);
    }

}
