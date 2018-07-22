package problem.search.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static boolean contains(String sentence,String content)
    {
        //这里面书写匹配规则
        //1.0
        if(sentence.toLowerCase().indexOf(content.toLowerCase())==-1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        String pattern = //"((?!hede).)*";
                //"this && (?!morning)";
                // "(?!evening)";
                //"this && (morning || evening)";
                "(?!evening)";
        //预处理
        //((?!hede).)*
//        if(pattern.indexOf("!")!=-1)
//        {
//            StringBuilder sb = new StringBuilder(pattern);
//            sb.insert(pattern.indexOf("!"),"?");
//            System.out.println(sb);
//            pattern = sb.toString();
//        }
        pattern = pattern.replace(" ","");
        pattern = pattern.replace("&&"," ");
        pattern = pattern.replace("||","|");
        System.out.println(pattern);
        Pattern p = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
        String test = "I will like you this morning hhh , However I will love you this evening hhh too";
        System.out.println(test.length());
        Matcher m = p.matcher(test);
        int count = 1;
        while(m.find())
        {
            System.out.println(count+" "+"Found value: " + m.group(0)+" "+m.start()+" "+m.end()+" position: "+getPosition(test,m.start(),m.end()));
            count++;
        }
    }
    public static int getPosition(String source,int start,int end)
    {
        String sub = source.substring(start,end);
        int count = 0;
        int index = source.indexOf(sub);
        char[] charArr = source.toCharArray();
        for(int i = 0;i<index;i++)
        {
            if(charArr[i]==32)
                count++;
        }
        return count;
    }
}
