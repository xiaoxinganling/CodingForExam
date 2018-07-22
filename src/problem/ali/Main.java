package problem.ali;

import java.util.Scanner;

class Point{
    public int x;
    public int y;
    public boolean visited;
    public int getLength(Point p)
    {
        return Math.abs(p.x-x)+Math.abs(p.y-y);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    private static Point START = new Point(0,0);
    private static int minpath = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine().trim());
        Point[] points = new Point[num];
        for(int i=0;i<num;i++)
        {
            String[] locations = input.nextLine().trim().split(",");
            points[i] = new Point(Integer.parseInt(locations[0]),Integer.parseInt(locations[1]));
        }
        System.out.println(calculate(START,points,0,0));
    }
//    private static int calculate(Point start,Point[] points,int sum,int count)
//    {
//        if(count == points.length)
//        {
//            minPath = Math.min(minPath,sum+start.getLength(START));
//            for(int i = 0;i<points.length;i++)
//            {
//                if(!points[i].visited)
//                {
//                    sum += points[i].getLength(start);
//                    if(sum < minPath)
//                    {
//                        points[i].visited = true;
//                        calculate(points[i],points,sum,count+1);
//                    }
//                }
//                sum -= points[i].getLength(start);
//                points[i].visited = false;
//            }
//        }
//        return minPath;
//    }

    public static int calculate(Point start, Point[] points, int sum, int count){
        if(count == points.length){
            minpath = Math.min(minpath, sum+start.getLength(START));
            return minpath;
        }
        for(int i = 0; i<points.length; i++){
            if(!points[i].visited){
                sum += points[i].getLength(start);
                if(sum < minpath){
                    points[i].visited = true;
                    calculate(points[i], points, sum, count+1);
                }
                sum -= points[i].getLength(start);
                points[i].visited = false;
            }
        }
        return minpath;
    }

}
