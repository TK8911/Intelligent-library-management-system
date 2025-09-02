package View;

import dao.userDao;
import entity.User;

import javax.swing.*;
import java.awt.*;

public class V4ins extends base{
    //构造方法
    V4ins(int userid){
        initComp(userid);
        initFrame();
    }
    //面板
    private JPanel jPanel = new JPanel();
    private void initComp(int userid) {
        //文本标签
        JLabel jLabel = new JLabel("亲爱的 ");
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel1=new JLabel();
        JLabel jLabel4 = new JLabel("你在本馆共计借阅 ");
        JLabel jLabel5 = new JLabel();
        JLabel field2 = new JLabel();
        JLabel field3 = new JLabel("正是读书的好年纪,");
        JLabel button =new JLabel("希望阅读可以为你的生活带来乐趣！");
       //位置
        jLabel.setFont(font2);
        jLabel2.setFont(font2);
        jLabel3.setFont(font2);
        jLabel4.setFont(font2);
        jLabel5.setFont(font2);
        jLabel1.setFont(font2);
        field2.setFont(font2);
        field3.setFont(font2);
        button.setFont(font2);
        jLabel.setBounds(120, 80, 100, 30);
        jLabel2.setBounds(200, 80, 100, 30);
        jLabel3.setBounds(100, 120, 400, 30);
        //jLabel1.setBounds(410, 120, 80, 25);
        jLabel4.setBounds(100, 160, 180, 30);
        field2.setBounds(280, 165, 60, 25);
        jLabel5.setBounds(100, 210, 50, 30);
        field3.setBounds(160, 215, 200, 25);
        button.setBounds(100, 270, 400, 30);
        //加入面板
        jPanel.add(jLabel);
        jPanel.add(jLabel2);
        jPanel.add(jLabel3);
        //jPanel.add(jLabel1);
        jPanel.add(jLabel4);
        jPanel.add(field2);
        jPanel.add(jLabel5);
        jPanel.add(field3);
        jPanel.add(button);
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, 530, 400);
        jPanel.setOpaque(false);
        //获得编号
        userDao u=new userDao();
        User user1=u.ins(userid);
        User user2=u.ins2(userid);
        jLabel2.setText(user1.getUsername());
        jLabel3.setText("今天是你与本馆相识的第 "+ user1.getReg_ins() +"天");
        field2.setText(user2.getBorR() +"次");
        jLabel5.setText(user1.getAge() +"岁");
        //回到显示页面
        jLabel1.setText(user1.getPassword());
    }
    private void initFrame() {
        setSize(530,400);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        //窗口标题
        setTitle("图书与我");
        //加入窗口
        add(jPanel);
        //改变背景图片(5)
        ImageIcon i = new ImageIcon("img\\1.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,getWidth(),getHeight());
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(), Image.SCALE_DEFAULT));
        add(Label);
    }
    public static void main(String[] args) {
        //实例化并显示窗口
        //int userid=1;           //测试
        Login l=new Login();
        int userid=l.getUserid();
        new V4ins(userid).setVisible(true);
    }
}
