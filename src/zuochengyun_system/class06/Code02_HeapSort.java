package zuochengyun_system.class06;

//从小到大排序
public class Code02_HeapSort {
    public static void heapSort(int[] arr) {
        /*for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }*/
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int max = arr[left] > arr[index] ? left : index;
            int right = left + 1;
            if (right < heapSize && arr[right] > arr[max]) max = right;
            if (max == index) break;
            swap(arr, index, max);
            index = max;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 3, 9, 0, 1, 4};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
