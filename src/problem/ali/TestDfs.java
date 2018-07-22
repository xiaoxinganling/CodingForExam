package problem.ali;

import java.util.ArrayList;
import java.util.List;

public class TestDfs {
    public static void testDfs(int[] nums,boolean[] isVisited,int count,List<Integer> tmp)
    {
        if(count==nums.length)
        {
            for (int i:tmp)
                System.out.print(i+" ");
            System.out.println();
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!isVisited[i])
            {
                isVisited[i]=true;
                tmp.add(nums[i]);
                testDfs(nums,isVisited,count+1,tmp);
                isVisited[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        boolean[] isVisited = new boolean[4];
        testDfs(nums,isVisited,0,new ArrayList<>());
    }
}
