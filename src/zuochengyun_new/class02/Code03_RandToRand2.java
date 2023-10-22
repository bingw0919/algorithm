package class02;

/**
 * 利用生成不等概率的两个数的函数获取等概率的两个数
 */
public class Code03_RandToRand2 {
    public static void main(String[] args) {
        int[] arr=new int[2];
        for (int i = 0; i < 100000; i++) {
            int num = y();
            arr[num]++;
        }
        for (int j : arr) {
            System.out.println(j);
        }
    }

    /**
     * 获取不等概率的两个数
     *
     * @return 0，1
     */
    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    /**
     * 等概率返回0，1
     *
     * @return 0，1
     */
    public static int y() {
        int num;
        do {
            num = x();
        } while (num == x());
        return num;
    }

}
