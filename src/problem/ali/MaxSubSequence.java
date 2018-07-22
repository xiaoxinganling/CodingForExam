package problem.ali;

import java.util.*;
public class MaxSubSequence{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int num = Integer.valueOf(input.nextLine());
        int[] nums = new int[num];
        String[] numsStr = input.nextLine().split(" ");
        for(int i=0;i<num;i++)
        {
            nums[i] = Integer.valueOf(numsStr[i]);
        }
        int start = -1;
        int end = -1;
        int res = 0;
        int max = Integer.MIN_VALUE;
        int tmpIndex = 0;
        for(int i=0;i<num;i++)
        {
            res+=nums[i];
            if(res<0)
            {
                res = 0;
                tmpIndex = i+1;
            }
            else{
                if(res>max)
                {
                    max = res;
                    start = tmpIndex;
                    end = i;
                }
            }
        }
        if(max==Integer.MIN_VALUE)
        {
            System.out.println(0+" "+nums[0]+" "+nums[nums.length-1]);
        }
        else{
            System.out.println(max+" "+nums[start]+" "+nums[end]);
        }
    }
}