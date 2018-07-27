package problem.ali;
import java.util.*;
class Node{
    public int w;
    public int index;
    public Node next;
    public Node(int w,int index,Node next)
    {
        this.w = w;
        this.index = index;
        this.next = next;
    }
}
public class TreeDiameter {
    /**
5 1 6
1 4 5
6 3 9
2 6 8
6 1 7
     */
    public static boolean hasCycle = false;
    public static int START = 0;
    public static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //int roadNum = input.nextInt();
        //input.nextLine();
        //int[][] matrix = new int[10000][10000];
        Node[] matrix = new Node[10000];
        while(true)
        //for(int i = 0;i<roadNum;i++)
        {
            String strLine = input.nextLine();
            if(strLine.equals(""))
                break;
            String[] line = strLine.split(" ");
            int x = Integer.valueOf(line[0])-1;
            START = x;
            int y = Integer.valueOf(line[1])-1;
            int w = Integer.valueOf(line[2]);
            if(matrix[x]==null)
            {
                matrix[x] = new Node(w,y,null);
            }
            else
            {
                matrix[x] = new Node(w,y,matrix[x]);
            }
            if(matrix[y]==null)
            {
                matrix[y] = new Node(w,x,null);
            }
            else
            {
                matrix[y] = new Node(w,x,matrix[y]);
            }
        }
        boolean[] isVisited = new boolean[10000];
        for(int i = 0;i<matrix.length;i++)
        {
            if(matrix[i]!=null&&!isVisited[i])
            {
                isVisited[i] = true;
                dfs(i,-1,matrix,isVisited);
            }
        }
        if(hasCycle)
            System.out.println("Has Cycle");
        else
        {
            int index = bfs(START,matrix);
            MAX = 0;
            int index2 = bfs(index,matrix);
            System.out.println((index+1)+" "+(1+index2)+" "+MAX);
            //System.out.println(MAX);
        }
    }
    public static void dfs(int start,int pre,Node[] matrix,boolean[] isVisited)
    {
        for(Node p = matrix[start];p!=null;p=p.next)
        {
            if(!isVisited[p.index])
            {
                isVisited[p.index] = true;
                dfs(p.index,start,matrix,isVisited);
            }
            else if(isVisited[p.index]&&p.index!=pre)
            {
                hasCycle = true;
            }
        }
    }
    public static int bfs(int start,Node[] matrix)
    {
        int pointNum = matrix.length;
        int index = -1;
        int[] values = new int[pointNum];
        boolean[] isVisited = new boolean[pointNum];
        LinkedList<Integer> q = new LinkedList<>();
        q.push(start);
        isVisited[start] = true;
        while(!q.isEmpty())
        {
            int cur = q.poll();
            for(Node j = matrix[cur];j!=null;j=j.next)
            {
                if(!isVisited[j.index])
                {
                    isVisited[j.index] = true;
                    values[j.index] = values[cur] + j.w;
                    q.push(j.index);
                    if(values[j.index]>MAX)
                    {
                        MAX = values[j.index];
                        index = j.index;
                    }
                }
            }
        }
        return index;
    }
}
