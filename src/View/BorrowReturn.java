package View;


import dao.LendDao;
import entity.Book;
import entity.Lend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

public class BorrowReturn extends base{
//面板
private JPanel jPanel = new JPanel();
private JPanel jPanel2 = new JPanel();
private int bookid,uid;
    //构造方法
    BorrowReturn(int user){
        initFrame();
        initComp(user);
    }
    //初始化组件
    private void initComp(int user) {
        //文本标签
        JLabel jLabel = new JLabel("图书借还");
        JLabel jLabel2 = new JLabel("请输入书号：");
        JLabel jLabel3 = new JLabel("书名：");
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel("作者：");
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel("状态：");
        JLabel jLabel8 = new JLabel();
        JLabel jLabel9 = new JLabel("书号：");
        JLabel jLabel10 = new JLabel();
        jLabel.setFont(font6);
        jLabel.setBounds(480, 35, 800, 100);
        jLabel.setForeground(Color.black);
        jLabel2.setFont(font1);
        jLabel2.setBounds(280, 164, 250, 30);
        jLabel2.setForeground(Color.black);
        jLabel3.setFont(font1);
        jLabel4.setFont(font1);
        jLabel5.setFont(font1);
        jLabel6.setFont(font1);
        jLabel7.setFont(font1);
        jLabel8.setFont(font1);
        jLabel9.setFont(font1);
        jLabel10.setFont(font1);
        jLabel3.setForeground(Color.black);
        jLabel4.setForeground(Color.black);
        jLabel5.setForeground(Color.black);
        jLabel6.setForeground(Color.black);
        jLabel7.setForeground(Color.black);
        jLabel8.setForeground(Color.black);
        jLabel9.setForeground(Color.black);
        jLabel10.setForeground(Color.black);
        jLabel9.setBounds(100, 20, 100, 50);
        jLabel10.setBounds(200, 20, 400, 50);
        jLabel3.setBounds(100, 90, 100, 50);
        jLabel4.setBounds(200, 90, 400, 50);
        jLabel5.setBounds(100, 160, 100, 50);
        jLabel6.setBounds(200, 160, 400, 50);
        jLabel7.setBounds(100, 230, 100, 50);
        jLabel8.setBounds(200, 230, 400, 50);
        //文本框
        JTextField field = new JTextField(20);
        field.setFont(font1);
        field.setBackground(Color.black);
        field.setBounds(480, 164, 250, 30);
        field.setForeground(Color.black);
        field.setOpaque(false);
        jPanel.add(jLabel3);
        jPanel.add(jLabel4);
        jPanel.add(jLabel5);
        jPanel.add(jLabel6);
        jPanel.add(jLabel7);
        jPanel.add(jLabel8);
        jPanel.add(jLabel9);
        jPanel.add(jLabel10);
        jPanel.setOpaque(false);
        jPanel.setBackground(Color.gray);
        jPanel.setLayout(null);
        jPanel.setBounds(270, 220, 620, 450);
        jPanel2.add(jLabel);
        jPanel2.add(jLabel2);
        jPanel2.add(field);
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);
        jPanel2.setBounds(0, 0, 1200, 800);

        //按钮
        JButton button = new JButton("检索");
        JButton button2 = new JButton("还书");
        JButton button3 = new JButton("借阅");
        button.setFont(font1);
        button.setBounds(780, 160, 100, 40);
        button.setForeground(Color.black);
        button.setBackground(Color.black);
        button.setOpaque(false);
        button2.setFont(font2);
        button3.setFont(font2);
        button2.setBounds(80, 310, 90, 50);
        button3.setBounds(460, 310, 90, 50);
        button2.setBackground(Color.black);
        button2.setOpaque(false);
        button3.setBackground(Color.black);
        button3.setOpaque(false);
        button2.setForeground(Color.black);
        button3.setForeground(Color.black);
        jPanel.add(button2);
        jPanel.add(button3);
        jPanel2.add(button);

        //加监听事件
        LendDao ld=new LendDao();
        LocalDate d = LocalDate.now();
        Date now = Date.valueOf(d);  //此刻的时间
              //检索
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookid= Integer.parseInt(field.getText());
                Book book=ld.getB(bookid);
                try {
                    if(book!=null){
                        jLabel10.setText(String.valueOf(bookid));
                        jLabel4.setText(book.getName());
                        jLabel6.setText(book.getAuthor());
                        jLabel8.setText(book.getStatus());
                    }else{
                        JOptionPane.showMessageDialog(null, "图书不存在", "警告", JOptionPane.WARNING_MESSAGE);
                        jLabel4.setText("");
                        jLabel6.setText("");
                        jLabel8.setText("");
                        jLabel10.setText("");
                    }
                }catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "输入不正确", "警告", JOptionPane.WARNING_MESSAGE);
                    field.setText("");
                }
            }
        });
              //还书
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jLabel8.getText().equals("外借")) {
                    bookid= Integer.parseInt(field.getText());
                    Lend l3=ld.getL(bookid);
                    Book book=ld.getB(bookid);
                    uid=l3.getUserid();   //和user对比

                    System.out.print(uid);
                    System.out.print(user);

                    if(uid==user){
                        //封装实体类
                        book.setStatus("在馆");
                        l3.setStatus("在馆");
                        l3.setBackDate(now);
                        boolean isok=ld.update1(book);
                        boolean isok1=ld.update2(l3);
                        if(isok && isok1){
                            JOptionPane.showMessageDialog(BorrowReturn.this,"还书成功！");
                            jLabel8.setText("在馆");
                        }else{JOptionPane.showMessageDialog(BorrowReturn.this,"还书失败！");
                        }
                        //用于勘误
                        System.out.print(isok);
                        System.out.print(isok1);
                    }else {
                        JOptionPane.showMessageDialog(null, "此书不是您借的哦！", "恭喜", JOptionPane.WARNING_MESSAGE);
                    }
                }else if (jLabel8.getText().equals("在馆")) {
                    JOptionPane.showMessageDialog(null, "此书在馆哦！", "警告", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "错误！", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
              //借书
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jLabel8.getText().equals("外借")) {
                    JOptionPane.showMessageDialog(null, "此书不在馆哦！请尝试借阅其他书籍~", "警告", JOptionPane.WARNING_MESSAGE);
                } else if (jLabel8.getText().equals("在馆")){
                    bookid= Integer.parseInt(field.getText());
                    Book book=ld.getB(bookid);
                    Lend l2=new Lend();
                    //封装实体类
                    book.setStatus("外借");

                    l2.setUserid(user);
                    l2.setBookId(bookid);
                    l2.setBookname(book.getName());
                    l2.setLendDte(now);
                    l2.setStatus("外借");
                    boolean isok2=ld.addR(l2);
                    boolean isok1=ld.update1(book);
                    if(isok2 && isok1){
                        JOptionPane.showMessageDialog(BorrowReturn.this,"借书成功！");
                        jLabel8.setText("外借");
                    } else{
                        JOptionPane.showMessageDialog(BorrowReturn.this,"借书失败！");
                    }
                    //用于勘误
                    System.out.print(isok1);
                    System.out.print(isok2);
                }else {
                    JOptionPane.showMessageDialog(null, "错误！", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    //初始化窗口
    public void initFrame() {
        setSize(1200,800);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        //窗口标题
        setTitle("图书管理系统");
        //加入窗口
        add(jPanel);
        add(jPanel2);
        // 改变背景图片
        ImageIcon i = new ImageIcon("img\\9.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,getWidth(),getHeight());
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(),Image.SCALE_DEFAULT));
        add(Label);
    }

    public static void main(String[] args) {
        //int user1=1;  //测试使用
        Login l=new Login();
        int user1=l.getUserid();
        new BorrowReturn(user1).setVisible(true);
    }
}

