/**
 * solve date problem
 */
package problem.date;

import java.util.Scanner;

public class Date {
    public int day;
    public int month;
    public int year;

    public Date() {
    }

    public Date(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void nextDay()
    {
        int yeap = DateUtils.isYeap(year);
        int[][] days = DateUtils.dayOfMonth;
        day++;
        if(day>days[yeap][month])
        {
            day = 1;
            month++;
            if(month>12)
            {
                month = 1;
                year++;
            }
        }
    }
    public static void main(String[] args) {
        //用一个数组将输入的年份全部记下来，用空间换取时间
        int[][][] map = new int[5000][12][31];
        Date tmp = new Date(0,1,1);
        int count = 0;
        while(tmp.year<5000)
        {
            //map[0][0][0]代表0000年1月1日
            map[tmp.year][tmp.month-1][tmp.day-1] = count++;
            tmp.nextDay();
        }
        Scanner in = new Scanner(System.in);
        //注意：两个日期是连续的我们规定他们之间的天数为2,即[start,end]
        while(true)
        {
            String[] start = in.nextLine().split(" ");
            if(start[0].equals("q"))
                break;
            String[] end = in.nextLine().split(" ");
            System.out.println(map[Integer.valueOf(end[0])][Integer.valueOf(end[1])-1][Integer.valueOf(end[2])-1]-
                    map[Integer.valueOf(start[0])][Integer.valueOf(start[1])-1][Integer.valueOf(start[2])-1]+1+" days");

        }
    }
}
