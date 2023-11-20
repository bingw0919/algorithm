package zuochengyun_system.class03;

import java.util.Random;

public class Code07_GetMax {

	// 求arr中的最大值
	public static int getMax(int[] arr) {
		return process(arr, 0, arr.length - 1);
	}

	// arr[L..R]范围上求最大值  L ... R   N
	public static int process(int[] arr, int L, int R) {
		if(L>=R) return arr[L];
		int mid=L+(R-L)/2;
		int left=process(arr,L,mid-1),right=process(arr,mid+1,R);
		return Math.max(left,Math.max(arr[mid],right));
	}

	public static void main(String[] args) {
		Random random = new Random();
		int len=random.nextInt(100)+1;
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=random.nextInt(10000);
		}
		int max1=getMax(arr),max2=arr[0];
		for (int i : arr) {
			max2=Math.max(i,max2);
		}
		System.out.println(max1==max2);

	}

}
