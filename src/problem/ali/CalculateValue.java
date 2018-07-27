package problem.ali;

import java.util.*;

public class CalculateValue {
    public static Map<String,Integer> map = new HashMap<>();
    static {
        map.put("(",1);
        map.put("+",2);
        map.put("-",2);
        map.put("*",3);
        map.put("/",3);
        map.put("#",0);
    }
    public static String infixToPostfix(String infix)
    {
        StringBuilder sb = new StringBuilder();
        char[] strArray = infix.trim().toCharArray();
        Stack<String> s = new Stack<>();
        s.push("#");
        for(char c:strArray)
        {
            if(c>='0'&&c<='9')
            {
                sb.append(c);
            }
            else if(c=='#')
                break;
            else if(c=='(')
                s.push(String.valueOf(c));
            else if(c==')')
            {
                while(!s.peek().equals("("))
                {
                    sb.append(s.pop());
                }
                s.pop();
            }
            else{
                while(map.get(s.peek())>=map.get(String.valueOf(c)))
                {
                    sb.append(s.pop());
                }
                s.push(String.valueOf(c));
            }
        }
        while(!s.peek().equals("#"))
        {
            sb.append(s.pop());
        }
        return sb.toString();
    }
    public static int calculatePostfix(String postfix)
    {
        Stack<String> s = new Stack<>();
        char[] strArr = postfix.toCharArray();
        for(char c:strArr)
        {
            if(c>='0'&&c<='9')
            {
                s.push(String.valueOf(c));
            }
            else
            {
                String end = s.pop();
                String start = s.pop();
                s.push(calcu(start,end,c));
            }
        }
        return Integer.valueOf(s.pop());
    }
    public static String calcu(String x,String y,char op)
    {
        int res = 0;
        int xx = Integer.valueOf(x);
        int yy = Integer.valueOf(y);
        if(op=='+')
        {
            res = xx + yy;
        }
        else if(op=='-')
        {
            res = xx - yy;
        }
        else if(op=='*')
        {
            res = xx * yy;
        }
        else if(op=='/')
        {
            res = xx / yy;
        }
        return String.valueOf(res);
    }
    public static void main(String[] args) {
        System.out.println(infixToPostfix("6/(4-2)+3*2"));
        System.out.println(calculatePostfix(infixToPostfix("6/(4-2)+3*2")));
    }
}
