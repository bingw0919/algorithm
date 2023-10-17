package class02;

/**
 * 利用能生成1-5的随机数函数生成1-7的等概率随机数
 */
public class Code02_RandToRand1 {
    public static void main(String[] args) {
        int[] arr=new int[7];
        for (int i = 0; i < 100000; i++) {
            int f4 = f4();
            arr[f4-1]++;
        }
        for (int j : arr) {
            System.out.println(j);
        }
        for (int i = 0; i < 100000; i++) {
            System.out.println(f2());
        }
    }

    /**
     * 题目提供生成1-5的等概率随机数
     *
     * @return 返回1~5
     */
    public static int f2() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 生成0-1等概率的随机数
     *
     * @return 0，1
     */
    public static int f3() {
        int num;
        do {
            num = f2();
        } while (num == 5);
        return num <= 2 ? 0 : 1;
    }

    /**
     * 生成1-7的等概率随机数
     * @return 1~7
     */
    public static int f4() {
        int num;
        do {
            //生成0-7的随机数
            num = (f3() << 2) + (f3() << 1) + (f3());
        } while (num == 0);//排除随机数0
        return num;
    }
}
