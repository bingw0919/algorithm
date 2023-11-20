package zuochengyun_system.class04;

public class Code01_MergeSort_1 {

    // 递归方法实现
    public int[] sortArray(int[] arr) {
        if (arr == null || arr.length < 2) return arr;
        process(arr, 0, arr.length - 1);
        return arr;
    }

    public void process(int[] arr, int L, int R) {
        if (L >= R) return;
        int mid = L + (R - L) / 2;
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public void merge(int[] arr, int L, int M, int R) {
        int[] arr1 = new int[R - L + 1];
        int cur1 = L, cur2 = M+1, cur = 0;
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
		Code01_MergeSort_1 test = new Code01_MergeSort_1();
		test.sortArray(arr);
	}

}
