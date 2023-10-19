package class03;

public class Code01_BSExist {
    /**
     * 二分查找
     * @param arr 查找数组
     * @param num 查找数字
     * @return 是否存在
     */
    public static boolean find(int[] arr,int num){
        if(arr==null||arr.length==0) return false;
        int L=0,R=arr.length-1,mid = 0;
        while (L <= R){
            mid+=(R-L)/2;
            if(arr[mid]==num) return true;
            else if(arr[mid]<num) L=mid+1;
            else R=mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr={1,2,2,4,5,7,8,8,9};
        System.out.println(find(arr,5));
        System.out.println(find(arr,6));
    }
}
