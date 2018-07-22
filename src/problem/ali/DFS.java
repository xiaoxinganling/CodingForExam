package problem.ali;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Status{
    public int x;
    public int y;
    public int z;
    public int t;
    public Status(int x,int y,int z,int t)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.t = t;
    }
}
public class DFS {
    public static int TIME = 0;
    public static int[][] go= {{1,0,0},
            {-1,0,0},
            {0,1,0},
            {0,-1,0},
            {0,0,1},
            {0,0,-1}};
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dataNum = input.nextInt();
        input.nextLine();
        for(int i = 0;i<dataNum;i++)
        {
            String[] line = input.nextLine().split(" ");
            int a = Integer.valueOf(line[0]);
            int b = Integer.valueOf(line[1]);
            int c = Integer.valueOf(line[2]);
            //地图
            int[][][] map = new int[a][b][c];
            //记录数组
            boolean[][][] isVisited = new boolean[a][b][c];
            //bfs队列
            LinkedList<Status> queue = new LinkedList<>();
            Status[][][] status = new Status[a][b][c];
            queue.push(new Status(0,0,0,0));
            isVisited[0][0][0] = true;
            TIME = Integer.valueOf(line[3]);
            for(int p = 0;p<a;p++)
            {
                for(int q = 0; q<b;q++)
                {
                    for(int k = 0;k<c;k++)
                    {
                        map[p][q][k] = input.nextInt();
                    }
                    input.nextLine();
                }
            }
            int res = bfs(queue,a,b,c,map,isVisited,status);
            System.out.println(res);
        }
    }
    public static int bfs(LinkedList<Status> q,int dA,int dB,int dC,int[][][] map,boolean[][][] isVisited,Status[][][] status)
    {
        while(!q.isEmpty())
        {
            Status s = q.poll();
            for(int i = 0;i<6;i++)
            {
                int nx = s.x+go[i][0];
                int ny = s.y+go[i][1];
                int nz = s.z+go[i][2];
                if(nx<0||nx>dA-1||ny<0||ny>dB-1||nz<0||nz>dC-1)
                    continue;
                if(map[nx][ny][nz]==1)
                    continue;
                if(isVisited[nx][ny][nz])
                    continue;
                Status nS = new Status(nx,ny,nz,s.t+1);
                q.push(nS);
                isVisited[nx][ny][nz] = true;
                if(nx==dA-1&&ny==dB-1&&nz==dC-1)
                    return nS.t;
            }
        }
        return -1;
    }
}
