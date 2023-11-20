package zuochengyun_system.class04;

public class Code02_MergeSort_2 {

    /*public int[] sortArray(int[] arr) {
        if (arr == null || arr.length < 2) return arr;
        int step = 1;
        while (step < arr.length) {
            int L = 0, M, R;
            while (L < arr.length - 2 * step) {
                M = L + step - 1;
                R = L + step * 2 - 1;
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (L + step < arr.length) {
                M = L + step - 1;
                R = arr.length - 1;
                merge(arr, L, M, R);
            }
            if (step <= arr.length / 2) step *= 2;
            else break;
        }
        return arr;
    }*/
    public int[] sortArray(int[] arr) {
        if (arr == null || arr.length < 2) return arr;
        int step=1,len=arr.length;
        while (step<len){
            int L=0,M,R;
            while (L<len){
                if(step>len-L) break;
                M=L+step-1;
                R=Math.min(M+step,len-1);
                merge(arr,L,M,R);
                L=R+1;
            }
            if(step>len/2) break;
            else step*=2;
        }
        return arr;
    }

    public void merge(int[] arr, int L, int M, int R) {
        int[] arr1 = new int[R - L + 1];
        int cur1 = L, cur2 = M + 1, cur = 0;
        while (cur1 <= M && cur2 <= R) {
            if (arr[cur1] <= arr[cur2]) {
                arr1[cur++] = arr[cur1++];
            } else {
                arr1[cur++] = arr[cur2++];
            }
        }
        while (cur1 <= M) arr1[cur++] = arr[cur1++];
        while (cur2 <= R) arr1[cur++] = arr[cur2++];
        for (int i = 0; i < arr1.length; i++) {
            arr[L + i] = arr1[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1};
        Code02_MergeSort_2 test = new Code02_MergeSort_2();
        test.sortArray(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
