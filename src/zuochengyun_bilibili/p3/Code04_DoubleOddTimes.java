package zuochengyun_bilibili.p3;


public class Code04_DoubleOddTimes {
    /**
     * 两个只出现奇数次的数字
     *
     * @param arr 数组
     */
    public static void print(int[] arr) {
        int num1 = 0;
        for (int i : arr) {
            num1 = num1 ^ i;
        }
        //num1=a^b！=0
        //num1不为0则二进制数位上至少存在一个1
        //获取最右侧为1对应的数
        int cur = num1 & (~num1 + 1);
        int num2 = 0; //a or b
        for (int i : arr) {
            //通过相同数位的不同数将两个不同的奇数次数字分开
            if ((cur & i) != 1) {
                num2 = num2 ^ i;
            }
        }
        System.out.println("数字1:" + (num1 ^ num2));
        System.out.println("数字2:" + num2);
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 6, 2, 9, 4, 1, 3, 2};
        print(arr);
    }
}
