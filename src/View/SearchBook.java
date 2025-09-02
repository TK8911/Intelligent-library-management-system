package View;

import dao.bookdao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Vector;

public class SearchBook extends base{
    //构造方法
    SearchBook(){
        initDataTable();
        initFrame();
    }
    // 分层窗格
    private String s;
    private String str;
    private int id;
    //初始化窗口
    public void initFrame() {
        setSize(1200,800);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        //窗口标题
        setTitle("图书管理系统");
        // 改变背景图片
        ImageIcon i = new ImageIcon("img\\12.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,getWidth(),getHeight());
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(),Image.SCALE_DEFAULT));
        add(Label);
    }
    //初始化数据表
    public void initDataTable(){
        String[] h={"书籍编号","类别","书 名","作 者","出版社","状态"};
        Vector<String> header=new Vector<>(Arrays.asList(h));
        Vector data=new Vector();
        JTable dataTbl=new JTable(data,header);
        JScrollPane jScrollPane = new JScrollPane(dataTbl);
        jScrollPane.setBounds(180, 250, 800, 400);
        add(jScrollPane);

        //文本标签
        JLabel jLabel = new JLabel("图书查询");
        JLabel jLabel2 = new JLabel("请选择查询方式：");
        jLabel.setFont(font);
        jLabel.setBounds(485, 35, 800, 100);
        jLabel.setForeground(Color.cyan);
        jLabel2.setFont(font1);
        jLabel2.setBounds(180, 130, 250, 30);
        jLabel2.setForeground(Color.cyan);
        add(jLabel2);
        add(jLabel);
        //文本框
        JTextField field = new JTextField(25);
        field.setFont(font2);
        field.setSize(dimension1);
        field.setBackground(Color.cyan);
        field.setBounds(480, 173, 250, 35);
        field.setForeground(Color.cyan);
        field.setOpaque(false);
        add(field);
        //按钮
        JButton button = new JButton("搜索");
        button.setFont(font2);
        button.setBounds(850, 170, 100, 40);
        button.setForeground(Color.cyan);
        button.setBackground(Color.cyan);
        button.setOpaque(false);
        add(button);
        //下拉框
        JComboBox<Object> Combox1 = new JComboBox<>();
        Combox1.setSize(dimension4);
        add(Combox1);
        Combox1.addItem("——查找全部——");
        Combox1.addItem("按照类别查找");
        Combox1.addItem("按照书名查找");
        Combox1.addItem("按照作者查找");
        Combox1.addItem("按照书号查找");
        Combox1.setFont(font2);
        Combox1.setBounds(180, 170, 200, 40);
        Combox1.setOpaque(false);
        //获取下拉列表值
        s = "——查找全部——";
        Combox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED) {
                    s=(String)e.getItem();
                }
            }
        });
        //按钮
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookdao b=new bookdao();
                if (s.equals("——查找全部——")){
                    Vector data=b.bookAll();
                    System.out.print(header);  //检验报错调试用的
                    DefaultTableModel model=(DefaultTableModel) dataTbl.getModel();
                    model.setDataVector(data,header);
                    System.out.print(data);    //检验报错调试用的
                }
                else if (s.equals("按照类别查找")){
                    try {
                        str= "%" +field.getText()+ "%" ;
                        Vector data=b.bookT(str);
                        System.out.print(header);  //检验报错调试用的
                        DefaultTableModel model=(DefaultTableModel) dataTbl.getModel();
                        model.setDataVector(data,header);
                        System.out.print(data);    //检验报错调试用的
                    } catch (Exception e1) {
                    }
                }else if (s.equals("按照书名查找")){
                    str= "%" +field.getText()+ "%" ;
                    Vector data=b.bookN(str);
                    System.out.print(header);  //检验报错调试用的
                    DefaultTableModel model=(DefaultTableModel) dataTbl.getModel();
                    model.setDataVector(data,header);
                    System.out.print(data);    //检验报错调试用的
                }else if (s.equals("按照作者查找")){
                    str="%" +field.getText()+"%";
                    Vector data=b.bookA(str);
                    System.out.print(header);  //检验报错调试用的
                    DefaultTableModel model=(DefaultTableModel) dataTbl.getModel();
                    model.setDataVector(data,header);
                    System.out.print(data);    //检验报错调试用的
                }else if (s.equals("按照书号查找")) {
                    try {
                        id = Integer.parseInt(field.getText());
                        Vector data = b.bookI(id);
                        System.out.print(header);  //检验报错调试用的
                        DefaultTableModel model=(DefaultTableModel) dataTbl.getModel();
                        model.setDataVector(data,header);
                        System.out.print(data);    //检验报错调试用的
                    } catch (Exception e1) {
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        //实例化并显示窗口
        new SearchBook().setVisible(true);
    }
}
