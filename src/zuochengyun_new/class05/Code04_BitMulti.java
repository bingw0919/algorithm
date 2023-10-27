package zuochengyun_new.class05;

public class Code04_BitMulti {
    public static int add(int a, int b) {
        int sum=a;
        while (b != 0) {
            sum = a ^ b;//无进位相加
            b = (a & b) << 1;//进位信息
            a=sum;
        }
        return sum;
    }
    public static int multi(int a,int b){
        int sum=0;
        while (b!=0){
            if((1&b)!=0){
                sum=add(a,sum);
            }
            a<<=1;
            b>>>=1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("test start");
        for (int i = 0; i < 100000; i++) {
            int a = (int) (Math.random() * 1000);
            int b = (int) (Math.random() * 1000);
            if (a * b != multi(a, b)) {
                System.out.println("multi(a,b)=" + multi(a, b));
                System.out.println("a*b=" + (a * b));
            }
        }
        System.out.println("test end");
    }
}
