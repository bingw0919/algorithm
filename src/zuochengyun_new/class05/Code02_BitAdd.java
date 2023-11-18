package zuochengyun_new.class05;

import java.util.Random;

public class Code02_BitAdd {
    public static int add(int a, int b) {
        int sum=a;
        while (b != 0) {
            sum = a ^ b;//无进位相加
            b = (a & b) << 1;//进位信息
            a=sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("test start");
        for (int i = 0; i < 100; i++) {
            int a = (int) (Math.random() * 100);
            int b = (int) (Math.random() * 100);
            if (a + b != add(a, b)) {
                System.out.println("add(a+b)=" + add(a, b));
                System.out.println("a+b=" + (a + b));
            }
        }
        System.out.println("test end");
    }
}
