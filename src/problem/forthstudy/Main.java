package problem.forthstudy;

import java.util.Scanner;

public class Main {
    private static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true)
        {
            int start  = input.nextInt();
            int end = input.nextInt();
            if(start>=end)
            {
                System.out.println(start-end);
                continue;
            }
            input.nextLine();
            res = Math.min(calcCurRes(end,start),res);
            calcRes(end,start,1);
            System.out.println(res);
            res = Integer.MAX_VALUE;
        }

    }
    public static void calcRes(int cur,int start,int step)
    {
        if(cur<start-1)
            return;
        if(cur%2==0)
        {
            //偶数
            res = Math.min(res,calcCurRes(cur/2,start)+step);
            calcRes(cur/2,start,step+1);
        }
        else{
            //奇数
            res = Math.min(res,calcCurRes(cur+1,start)+step);
            calcRes(cur+1,start,step+1);
        }
    }
    public static int calcCurRes(int cur,int start)
    {
        int times = 0;
        while(start<cur)
        {
            start*=2;
            times++;
        }
        return times+Math.abs(start-cur);
    }
}
