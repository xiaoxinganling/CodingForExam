package problem.search.io;


import java.io.*;
import java.util.Scanner;

public class FileUtils {
    public static String findKeyword(String filePath,String keyword){
        File f = new File(filePath);
        Scanner s = null;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        while(s.hasNext())
        {
            //do action：查找，分析词频
            //System.out.println(s.nextLine());
            sb.append(s.nextLine()+"\n");
        }
        s.close();
        return sb.toString();
    }
    public static void writeFile(String content,String filePath) throws IOException {
        FileWriter f;
        if(new File(filePath).exists())
        {
            f = new FileWriter(filePath,true);//append为true表示追加
        }
        else  {
            f = new FileWriter(filePath);
        }
        PrintWriter pw = new PrintWriter(f);
        pw.print(content);
        pw.close();
    }

    public static void main(String[] args) throws IOException {
        findKeyword("test/short/text.txt","a");
        //writeFile("\n,Hello,It's just a test.","test/short/text1.txt");
    }
}
