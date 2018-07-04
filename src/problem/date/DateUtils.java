package problem.date;

public class DateUtils {
    //非闰年的12个月，闰年的12个月天数(因为月份是从1开始的，所以数组前面补0)
    public static int[][] dayOfMonth = {{0,31,28,31,30,31,30,31,31,30,31,30,31},
            {0,31,29,31,30,31,30,31,31,30,31,30,31}};
    //是否为闰年
    public static int isYeap(int year)
    {
        if((year%4==0&&year%100!=0)||year%400==0)
            return 1;
        return 0;
    }
}
