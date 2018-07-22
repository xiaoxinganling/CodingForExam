package problem.search.ui;

import javax.swing.*;

public class HelloWorld extends JFrame{
    private JPanel panel1;
    private JTextField keyword;
    private JButton search;
    private JTextArea result;
    private JLabel status;
    private String filePath;

    public HelloWorld(String filePath)
    {
        super("全文搜索系统");
        this.filePath = filePath;
        initGUI();
    }
    public void initGUI()
    {
        setContentPane(this.panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
        result.setText(filePath);
        search.addActionListener(e -> {
            System.out.println(keyword.getText());
            result.setText("The result changes");
        });
    }
    public static void main(String[] args) {
        HelloWorld h = new HelloWorld("hh");
    }
}
