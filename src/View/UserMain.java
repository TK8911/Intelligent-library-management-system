package View;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMain extends base {    //面板
    private JLabel jLabel = new JLabel("欢迎登陆图书管理系统!");
    public JMenuBar bar=new JMenuBar();
    //构造方法
    UserMain(String user,int userid){
        initComp(user,userid);
        initFrame();
    }
    //初始化组件
    private void initComp(String user,int userid) {
        //文本标签
        jLabel.setFont(font5);
        jLabel.setBounds(230, 90, 800,200);
        jLabel.setForeground(new Color(255,215,0));

        JMenu menu1=new JMenu("主界面");
        JMenu menu2=new JMenu("功能菜单");
        JMenu menu3=new JMenu("可视化图书馆");

        JMenuItem menuItem = new JMenuItem("书籍检索");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchBook().setVisible(true);
            }
        });
        JMenuItem m3 = new JMenuItem("图书借还");
        m3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BorrowReturn(userid).setVisible(true);
            }
        });
        JMenuItem m4 = new JMenuItem("账号管理");
        m4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelfManage(user,userid).setVisible(true);
            }
        });
        JMenuItem m5 = new JMenuItem("公告");
        m5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Notice().setVisible(true);
            }
        });
        menu2.add(menuItem);
        menu2.add(m3);
        menu2.add(m4);
        menu2.add(m5);

        JMenuItem mu1= new JMenuItem("不同类别图书占比");
        mu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    V1pie ex = new V1pie();
                    ex.setVisible(true);
                });
            }
        });
        JMenuItem mu11= new JMenuItem("2022-2023年月借阅记录");
        mu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    V2line ex = new V2line();
                    ex.setVisible(true);
                });
            }
        });
        JMenuItem mu111= new JMenuItem("年注册人数");
        mu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    V3bar ex = new V3bar();
                    ex.setVisible(true);
                });
            }
        });

        JMenuItem mu2= new JMenuItem("图书与我");
        mu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new V4ins(userid).setVisible(true);
            }
        });

        menu3.add(mu1);
        menu3.add(mu11);
        menu3.add(mu111);
        menu2.add(mu2);

        bar.setFont(font2);
        bar.add(menu1);
        bar.add(menu2);
        bar.add(menu3);
        bar.setBounds(0,0,1200,30);
    }
    //初始化窗口
    public void initFrame() {
        setSize(1200,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        //窗口标题
        setTitle("图书管理系统");
        add(jLabel);
        add(bar);
        //改变背景
        ImageIcon i = new ImageIcon("img\\3.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,getWidth(),getHeight());
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(),Image.SCALE_DEFAULT));
        add(Label);

        setVisible(true);
    }
    public static void main(String[] args) {
        //实例化并显示窗口
        Login l=new Login();
        String user=l.getUser();
        int userid=l.getUserid();
        new UserMain(user,userid).setVisible(true);
    }
}


