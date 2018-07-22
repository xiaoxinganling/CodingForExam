package problem.k;

public class ArrayMethod {
    public static Integer[] getMinK(int k,int[] nums)
    {
        Integer[] res = new Integer[k];
        for(int i = 0;i<k;i++)
            res[i] = null;
        for(int i=0;i<nums.length;i++)
        {
            int j = 0;
            while(j<k)
            {
                if(res[j]==null||nums[i]<res[j])
                {
                    for(int q = k-1;q>j;q--)
                        res[q] = res[q-1];
                    res[j] = nums[i];
                    break;
                }
                j++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums ={4,5,1,6,2,7,3,8};
        for(Integer i :getMinK(4,nums))
            System.out.print(i+" ");
    }
}
