package View;

import dao.admindao;
import entity.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class BookManage extends base {
   //构造方法
    public BookManage(){
        initFrame();
        initOpArea();
        initFun();
    }
    private admindao a=new admindao();
    //组件配置
    //动态下拉框
    private Vector<String> types=a.type();
    private JComboBox<String> typeBox=new JComboBox<>(types);

    private JPanel panel1=new JPanel();
    private JPanel panel2=new JPanel();
    private JPanel panel3=new JPanel();
    private JPanel panel4=new JPanel();
    private JPanel panel5=new JPanel();
    private JPanel panel6=new JPanel();
    private Label jl1=new Label("书 号：");
    private Label jl2=new Label("书 名：");
    private Label jl3=new Label("作 者：");
    private Label jl4=new Label("类 型：");
    private Label jl5=new Label("出版社：");
    private JTextField f1=new JTextField(20);
    private JTextField f2=new JTextField(20);
    private JTextField f3=new JTextField(20);
    //private JTextField f4=new JTextField(20);
    private JTextField f5=new JTextField(20);
    private Button b1=new Button("添加");
    private Button b2=new Button("查询");
    private Button b3=new Button("修改");
    private Button b4=new Button("删除");
    private Button b5=new Button("取消");
    //初始化组件
    public void initOpArea() {
        typeBox.setSize(dimension2);
        //字体
        jl1.setFont(font2);
        jl2.setFont(font2);
        jl3.setFont(font2);
        jl4.setFont(font2);
        jl5.setFont(font2);
        f1.setFont(font3);
        f2.setFont(font3);
        f3.setFont(font3);
        typeBox.setFont(font3);
        f5.setFont(font3);
        b1.setFont(font2);
        b2.setFont(font2);
        b3.setFont(font2);
        b4.setFont(font2);
        b5.setFont(font2);
        b1.setSize(dimension1);
        b2.setSize(dimension1);
        b3.setSize(dimension1);
        b4.setSize(dimension1);
        b5.setSize(dimension1);
        typeBox.setSize(dimension2);
        //加入
        panel1.add(jl1);
        panel1.add(f1);
        panel2.add(jl2);
        panel2.add(f2);
        panel3.add(jl3);
        panel3.add(f3);
        panel4.add(jl4);
        panel4.add(typeBox);
        panel5.add(jl5);
        panel5.add(f5);
        panel6.add(b1);
        panel6.add(b2);
        panel6.add(b3);
        panel6.add(b4);
        panel6.add(b5);
        //panel6.setLayout(null);
        //位置
        panel1.setBounds(0,20,getWidth(),60);
        panel2.setBounds(0,80,getWidth(),60);
        panel3.setBounds(0,140,getWidth(),60);
        panel4.setBounds(0,200,getWidth(),60);
        panel5.setBounds(0,260,getWidth(),60);
        panel6.setBounds(0,320,getWidth(),60);
    }
    //功能具体化
    private void initFun() {
        //加监听事件
        //添加书籍
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (f1.getText().equals("")){
                    if(f2.getText().equals("") || f3.getText().equals("")|| typeBox.getSelectedItem().equals("")|| f5.getText().equals("")) {
                        Book b = new Book();
                        b.setName(f2.getText());
                        b.setAuthor(f3.getText());
                        b.setType(typeBox.getSelectedItem().toString());
                        b.setPublish(f5.getText());
                        boolean isok = a.addB(b);
                        if (isok) {
                            int bid = b.getId();
                            JOptionPane.showMessageDialog(BookManage.this, "添加成功！新书书号为" + bid);
                        } else {
                            JOptionPane.showMessageDialog(BookManage.this, "添加失败！");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "错误！添加书籍信息不完整!", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "错误！添加书籍不可手动添加书号", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        //书号查询
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = f1.getText().trim(); // 去除前后空白
                int id = 0;
                try {
                    id = Integer.parseInt(text);
                    Book b = a.get(id);
                    f2.setText(b.getName());
                    f3.setText(b.getAuthor());
                    typeBox.setSelectedItem(b.getType());
                    f5.setText(b.getPublish());
                }catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "错误！请输入要删除书籍的书号！", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        //修改书籍
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = f1.getText().trim(); // 去除前后空白
                int id = 0;
                try {
                    id = Integer.parseInt(text);
                    Book b = new Book();
                    b.setId(id);
                    b.setName(f2.getText());
                    b.setAuthor(f3.getText());
                    b.setType(typeBox.getSelectedItem().toString());
                    b.setPublish(f5.getText());

                    boolean isok = a.update(b);
                    if (isok) {
                        JOptionPane.showMessageDialog(BookManage.this, "修改成功！");
                    } else {
                        JOptionPane.showMessageDialog(BookManage.this, "修改失败！");
                    }
                }catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "错误！请输入要删除书籍的书号！", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        //删除书籍
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = f1.getText().trim(); // 去除前后空白
                int id = 0;
                try {id = Integer.parseInt(text);

                    int op=JOptionPane.showConfirmDialog(BookManage.this,"您确定删除该书吗？");
                    if(op!=JOptionPane.OK_OPTION){
                        return;    //不确定，则直接返回
                    }
                    boolean isok=a.del(id);
                    if(isok){
                        f1.setText("");
                        f2.setText("");
                        f3.setText("");
                        typeBox.setSelectedItem("");
                        f5.setText("");
                        JOptionPane.showMessageDialog(null, "删除成功！", "通知", JOptionPane.WARNING_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(null, "删除失败！", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "错误！请输入要删除书籍的书号！", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        //取消（置空）
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setText("");
                f2.setText("");
                f3.setText("");
                typeBox.setSelectedItem("");
                f5.setText("");
            }
        });
    }
    //初始化窗口
    public void initFrame(){
        setSize(600,435);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setTitle("书籍管理");
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        add(panel6);
    }
    public static void main(String[] args) {
        new BookManage().setVisible(true);
    }
}
