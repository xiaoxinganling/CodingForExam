package problem.ali;

//start不一定是0
import java.util.*;
public class Djkstra{
    public static int START = 0;
    public static int END = 0;
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String[] firstLine = input.nextLine().split(" ");
        int pointNum = Integer.valueOf(firstLine[0]);
        int roadNum = Integer.valueOf(firstLine[1]);
        START = Integer.valueOf(firstLine[2]);
        END = Integer.valueOf(firstLine[3]);

        int[] pointsW = new int[pointNum];//point权重
        String[] pointsLine = input.nextLine().split(" ");
        for(int i = 0;i < pointNum;i++)
        {
            pointsW[i] = Integer.valueOf(pointsLine[i]);
        }
        //point矩阵
        int[][] points = new int[pointNum][pointNum];
//        for(int i=0;i<pointNum;i++)
//        {
//            for(int j = 0;j<pointNum;j++)
//            {
//                points[i][j] = inf;
//            }
//        }
        for(int i=0;i<roadNum;i++)
        {
            String[] line = input.nextLine().split(" ");
            int r = Integer.valueOf(line[0]);
            int c = Integer.valueOf(line[1]);
            int w = Integer.valueOf(line[2]);
            points[r][c] = w;
            points[c][r] = w;
        }
        boolean[] isVisited = new boolean[pointNum];
        int[] pre = new int[pointNum];
        int[] values = new int[pointNum];
        for(int i = 0; i<pointNum;i++)
        {
            values[i] = Integer.MAX_VALUE-1;
            pre[i] = -1;
        }
        //记录点权值
        int[] weight = new int[pointNum];
        //记录路径条数
        int[] nums = new int[pointNum];
        doDjkstra(points,isVisited,values,weight,nums,pointsW,pre);
        System.out.println(nums[END]+" "+weight[END]);
        Stack s = new Stack();
        doDfs(s,pre,END);
        while(!s.empty())
        {
            System.out.print(s.pop()+" ");
        }
    }
    public static void doDjkstra(int[][] matrix,boolean[] isVisited,int[] values,int[] weight,int[] nums,int[] pointsW,int[] pre)
    {

        int pointNum = isVisited.length;
        isVisited[START] = true;
        //初始化
        nums[START] = 1;
        weight[START] = pointsW[START];
        values[START] = 0;
        for(int j = 0;j<pointNum;j++)
        {
            if(matrix[START][j]!=0&&!isVisited[j])
            {
                values[j] = matrix[START][j];
                pre[j] = START;
                weight[j] = pointsW[j]+pointsW[START];
                nums[j] = nums[START];
            }
        }
        for(int i = 1;i<pointNum;i++)
        {
            int index = getMinIndex(values,isVisited);
            if(index==-1)
                break;
            isVisited[index] = true;
            for(int j = 0;j<pointNum;j++)
            {
                if(matrix[index][j]!=0&&!isVisited[j])
                {
                    if(values[index]+matrix[index][j]<values[j])
                    {

                        values[j] = values[index]+matrix[index][j];
                        nums[j] = nums[index];
                        weight[j] = weight[index]+pointsW[j];
                        pre[j] = index;
                    }
                    else if(values[index]+matrix[index][j]==values[j])
                    {
                        nums[j] = nums[index]+nums[j];
                        if(weight[index]+pointsW[j]>weight[j])
                        {
                            weight[j] = weight[index]+pointsW[j];
                            pre[j] = index;
                        }
                    }
                }
            }
        }
    }
    public static int getMinIndex(int[] values,boolean[] isVisited) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < values.length; i++) {
            if (values[i] < min && !isVisited[i]) {
                min = values[i];
                index = i;
            }
        }
        return index;
    }
    public static void doDfs(Stack s,int[] pre,int cur)
    {
        if(cur==START)
        {
            s.push(cur);
            return;
        }
        s.push(cur);
        doDfs(s,pre,pre[cur]);
    }
}
