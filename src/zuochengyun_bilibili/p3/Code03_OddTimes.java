package zuochengyun_bilibili.p3;


public class Code03_OddTimes {
    /**
     * 只出现奇数次的数字
     * @param arr 数组
     */
    public static void print(int[] arr) {
        int a = 0;
        for (int i : arr) {
            a = a ^ i;
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 9, 3, 1, 2, 6, 3};
        print(arr);
    }
}
