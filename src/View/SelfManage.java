package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelfManage extends base{
    // 分层窗格
    public JLayeredPane jLayeredPane = new JLayeredPane();
    //构造方法
    SelfManage(String user,int userid){
        initFrame();
        initComp(user,userid);
    }
    //面板
    public JPanel jPanel = new JPanel();
    private String user;
    private int userid;
    public void setUser(String user) {
        this.user = user;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }

    //初始化组件
    private void initComp(String user,int userid) {
        //文本标签
        JLabel jLabel = new JLabel("账户管理");
        jLabel.setFont(font6);
        jLabel.setBounds(460, 50, 800, 70);
        //按钮
        JButton button = new JButton("修改密码");
        JButton button2 = new JButton("修改信息");
        JButton button3 = new JButton("借书记录");
        JButton button4 = new JButton("退出登陆");
        button.setFont(font1);
        button2.setFont(font1);
        button3.setFont(font1);
        button4.setFont(font1);
        button.setBounds(150, 250, 250, 50);
        button2.setBounds(150, 310, 250, 50);
        button3.setBounds(150, 370, 250, 50);
        button4.setBounds(150, 430, 250, 50);
        button.setBackground(Color.cyan);
        button2.setBackground(Color.cyan);
        button3.setBackground(Color.cyan);
        button4.setBackground(Color.cyan);
        button.setOpaque(false);
        button2.setOpaque(false);
        button3.setOpaque(false);
        button4.setOpaque(false);
        //加入面板
        jPanel.add(button);
        jPanel.add(button2);
        jPanel.add(button3);
        jPanel.add(button4);
        jPanel.add(jLabel);
        jPanel.setLayout(null);
        jPanel.setBounds(0,0,1200,800);
        jPanel.setOpaque(false);
        //面板位置
        //加监听事件
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ModifyU(user).setVisible(true);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ModifyP(user).setVisible(true);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LendRecordOne(userid).setVisible(true);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
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
        // 改变背景图片(8)
        ImageIcon i = new ImageIcon("img\\8.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,getWidth(),getHeight());
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(),Image.SCALE_DEFAULT));
        add(Label);
    }
    public static void main(String[] args) {
        //实例化并显示窗口
        Login l=new Login();
        String user=l.user;
        int userid= l.userid;
        new SelfManage(user,userid).setVisible(true);
    }
}
