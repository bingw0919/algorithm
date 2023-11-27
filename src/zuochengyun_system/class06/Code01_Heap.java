package zuochengyun_system.class06;

import zuochengyun_system.example.class06.Code02_Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code01_Heap {

    public static class MyMaxHeap {
        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = value;
            // value  heapSize
            heapInsert(heapSize++);
        }

        public int pop() {
            int ans = heap[0];
            heap[0] = heap[--heapSize];
            heapify(0);
            return ans;
        }

        private void heapInsert(int index) {
            int p = (index - 1) / 2;
            while (p >= 0 && heap[index] > heap[p]) {
                swap(heap, index, p);
                index = p;
                p = (p - 1) / 2;
            }
        }

        // 从index位置，往下看，不断的下沉
        // 停：较大的孩子都不再比index位置的数大；已经没孩子了
        // 从index位置，往下看，不断的下沉
        // 停：较大的孩子都不再比index位置的数大；已经没孩子了
        private void heapify(int index) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                int max=heap[index]>heap[left]?index:left;
                int right=left+1;
                if(right<heapSize) max=heap[max]>heap[right]?max:right;
                if(max==index) break;
                swap(heap,max,index);
                index=max;
                left = index * 2 + 1;
            }
        }

        private static void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }


    public static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }

    }

    public static void main(String[] args) {

        System.out.println("MyMaxHeap start~~~~~~~~~");
        // 大根堆
        MyMaxHeap myMaxHeap = new MyMaxHeap(100);
        myMaxHeap.push(5);
        myMaxHeap.push(5);
        myMaxHeap.push(5);
        myMaxHeap.push(3);

        myMaxHeap.push(7);
        myMaxHeap.push(0);
        myMaxHeap.push(7);
        myMaxHeap.push(0);
        myMaxHeap.push(7);
        myMaxHeap.push(0);

        while (!myMaxHeap.isEmpty()) {
            System.out.println(myMaxHeap.pop());
        }
        System.out.println("MyMaxHeap end~~~~~~~~~");
    }

}

