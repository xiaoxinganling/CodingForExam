package problem.ali;

import java.util.Scanner;

class Item{
    public int space;
    public int value;
    public Item(int s,int v)
    {
        space = s;
        value = v;
    }
}
public class DP {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] firstLine = input.nextLine().split(" ");
        int allSpace = Integer.valueOf(firstLine[0]);
        int itemNum = Integer.valueOf(firstLine[1]);
        Item[] items = new Item[itemNum+1];
        for(int i = 1;i<=itemNum;i++)
        {
            String[] line = input.nextLine().split(" ");
            int s = Integer.valueOf(line[0]);
            int v = Integer.valueOf(line[1]);
            items[i] = new Item(s,v);
        }
        //int[][] dp = new int[itemNum+1][allSpace+1];
        int[] dp = new int[allSpace+1];
        for(int i = 1;i<=itemNum;i++)//循环每个物品
        {
            for(int j = allSpace;j>=items[i].space;j--)
            {
                //dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-items[i].space]+items[i].value);
                dp[j] = Math.max(dp[j-1],dp[j-items[i].space]+items[i].value);
            }
//            for(int j = items[i].space-1;j>=0;j--)
//            {
//                dp[i][j] = dp[i-1][j];
//            }
        }
        //System.out.println(dp[itemNum][allSpace]);
        System.out.println(dp[allSpace]);
    }
}
