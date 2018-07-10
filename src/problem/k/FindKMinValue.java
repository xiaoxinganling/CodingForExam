/**
 * find k minest nums
 * by the way:the fast sort
 */
package problem.k;

public class FindKMinValue {
    private static int partition(int left,int right,int[] nums)
    {
        int tmp = nums[left];
        int i = left;
        int j = right;
        while(i<j) {
            while (i < j && nums[j] >= tmp)
                j--;
            while (i < j && nums[i] <= tmp)
                i++;
            if (i < j) {
                //swap(i,j)
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = tmp;
        return i;
    }
    private static void findKMins(int k,int[] nums)
    {
        //安全检查
        if(nums.length<k)
            return;
        int start = 0;
        int end = nums.length-1;
        int index = partition(start,end,nums);
        while(index!=k-1)
        {
            if(index<k-1)
                index = partition(index+1,end,nums);
            else
                index = partition(start,index-1,nums);
        }
    }
    private static void quickSort(int start,int end,int[] nums)
    {
        int index = partition(start, end, nums);
        if(index>start+1)
            quickSort(start,index-1,nums);
        if(index<end-1)
            quickSort(index+1,end,nums);
    }
    public static void main(String[] args) {
        int[] nums ={4,5,1,6,2,7,3,8};
        int[] nums1 ={5,432,5325,134123,343,235,352,1325,1236,235,79,777,807,67,58,780,985,211,111};
        findKMins(4,nums);
        for(int i:nums)
            System.out.print(i+" ");
        System.out.println();
        for(int i:nums1)
            System.out.print(i+" ");
        System.out.println();
        quickSort(0,nums1.length-1,nums1);
        for(int i:nums1)
            System.out.print(i+" ");

    }
}