package problem.search.ui;

import problem.search.io.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class ImportFile extends JFrame{
    private JPanel panel1;
    private JButton select;
    private FileDialog openDia;
    public ImportFile() {
        super("全文搜索系统");
        initGUI();
    }
    public void initGUI()
    {

        openDia = new FileDialog(new Frame(),"浏览",FileDialog.LOAD);
        select.addActionListener(e -> {
                    openDia.setVisible(true);//显示打开文件对话框
                    String dirpath = openDia.getDirectory();//获取打开文件路径并保存到字符串中。
                    String fileName = openDia.getFile();//获取打开文件名称并保存到字符串中
            System.out.println(dirpath+ ""+fileName);
                    this.setVisible(false);
                    HelloWorld hello = new HelloWorld(FileUtils.findKeyword(dirpath+fileName,"kk"));
                    hello.setVisible(true);
                }
        );
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }
    public static void main(String[] args) {
        ImportFile ip = new ImportFile();
    }
}
