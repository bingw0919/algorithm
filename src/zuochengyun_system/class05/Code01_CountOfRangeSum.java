package zuochengyun_system.class05;

// 这道题直接在leetcode测评：
// https://leetcode.com/problems/count-of-range-sum/
public class Code01_CountOfRangeSum {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        return count(sum, 0, nums.length - 1, lower, upper);
    }

    //统计arr[L-R]中有多少个满足的
    private static int count(long[] sum, int L, int R, int lower, int upper) {
        if (L >= R) {
            return sum[L] >= lower && sum[R] <= upper ? 1 : 0;
        }
        int mid = L + (R - L) / 2;
        return count(sum, L, mid, lower, upper)
                + count(sum, mid + 1, R, lower, upper)
                + merge(sum, L, mid, R, lower, upper);
    }

    private static int merge(long[] sum, int L, int M, int R, int lower, int upper) {
        int count = 0;
        int windowL = L, windowR = L;
        for (int i = M + 1; i <= R; i++) {
            long min = sum[i] - upper, max = sum[i] - lower;
            while (windowL <= M && sum[windowL] < min) windowL++;
            while (windowR <= M && sum[windowR] <= max) windowR++;
            count+=windowR-windowL;
        }
        int cur1=L,cur2=M+1,cur=0;
        long[] tmp=new long[R-L+1];
        while (cur1<=M&&cur2<=R){
            tmp[cur++]=sum[cur1]<sum[cur2]?sum[cur1++]:sum[cur2++];
        }
        while (cur1<=M)tmp[cur++]=sum[cur1++];
        while (cur2<=R)tmp[cur++]=sum[cur2++];
        for (int i = 0; i < tmp.length; i++) {
            sum[L+i]=tmp[i];
        }
        return count;
    }


    //前缀和+暴力 O(N^2)
    public static int countRangeSum2(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        //sum[1]=nums[0]+nums[1]
        //sum[5]=nums[0]+nums[1]+....+nums[5]
        //sum[5]-sum[1]=nums[2]....+nums[5]
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                long num = (j == 0) ? sum[i] : (sum[i] - sum[j - 1]);
                //获取j~i的前缀和
                //arr[5]-arr[2]->3+4+5   ->sum[5]-sum[2]
                //arr[5]-arr[0]->1+2+3+4+5
                if (num >= lower && num <= upper) res++;
            }
        }
        return res;
    }

    //暴力
    public int countRangeSum3(int[] nums, int lower, int upper) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            long tempSum = 0;
            for (int j = i; j < nums.length; j++) {
                tempSum += nums[j];
                if (lower <= tempSum && tempSum <= upper) {
                    ret++;
                }
            }
        }
        return ret;
    }


}
