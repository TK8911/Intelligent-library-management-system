package View;

import dao.admindao;
import dao.userDao;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 登录界面 **/
public class Login extends base{
    Login(){
        initFrame();
        initComp();
    }
    // 面板
    public userDao u=new userDao();
    public User user1=new User();
    public int userid;

    private JPanel jPanel = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private JPanel jPanel3 = new JPanel();
    private JPanel jPanel4 = new JPanel();
    private JPanel jPanel5 = new JPanel();

    private JTextField field = new JTextField(20);
    private JPasswordField field2 = new JPasswordField(20);

    public String user;
    public void setUser(String user) {
        this.user = user;
    }
    public String getUser() {
        return user;
    }

    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }

    //初始化组件
    private void initComp() {
        //文本标签
        JLabel jLabel = new JLabel("图书管理系统");
        JLabel jLabel2 = new JLabel("用户名：");
        JLabel jLabel3 = new JLabel("密  码： ");
        jLabel.setFont(font);
        jLabel2.setFont(font1);
        jLabel3.setFont(font1);
        //文本框
        field.setFont(font2);
        field2.setFont(font2);
        field.setPreferredSize(dimension1);
        field2.setPreferredSize(dimension1);
        //按钮
        JButton button = new JButton("登陆");
        JButton button2 = new JButton("注册");
        button.setFont(font2);
        button2.setFont(font2);
        button.setPreferredSize(dimension2);
        button2.setPreferredSize(dimension2);
        //加入面板
        jPanel.add(jLabel);
        jPanel2.add(jLabel2);
        jPanel2.add(field);
        jPanel3.add(jLabel3);
        jPanel3.add(field2);
        jPanel4.add(button);
        jPanel5.add(button2);
        // 设置透明
        jLabel.setOpaque(false);
        jLabel2.setOpaque(false);
        jLabel3.setOpaque(false);
        field.setOpaque(false);
        field2.setOpaque(false);
        jPanel.setOpaque(false);
        jPanel2.setOpaque(false);
        jPanel3.setOpaque(false);
        jPanel4.setOpaque(false);
        jPanel5.setOpaque(false);
        //面板位置
        jPanel.setBounds(0, 60, 550, 80);
        jPanel2.setBounds(0, 165, 550, 80);
        jPanel3.setBounds(0, 250, 550, 60);
        jPanel4.setBounds(100, 325, 150, 80);
        jPanel5.setBounds(275, 325, 150, 80);
        //加监听事件
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user = field.getText();
                String password = new String(field2.getPassword());
                admindao a=new admindao();
                boolean isa=a.login(user,password);
                boolean isok = u.login(user, password);
                if (isok) {
                    System.out.print("登录成功！获取用户名：" + user);
                    setVisible(false);
                    user1=u.get(user);
                    userid=user1.getId();
                    new UserMain(user,userid).setVisible(true);
                    new SelfManage(user,userid);
                    new BorrowReturn(userid);
                    new LendRecordOne(userid);

                } else if (isa) {
                    System.out.print("管理员登录成功!" );
                    setVisible(false);
                    new adminMain().setVisible(true);
                } else {
                    System.out.print("登录失败！");
                    JOptionPane.showMessageDialog(Login.this, "用户名或密码有误！");
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Register().setVisible(true);
            }
        });
    }
    //初始化窗体
    private void initFrame() {
            setSize(550,500);             //设置大小
            setTitle("登录");            //设置标题
            setLocationRelativeTo(null);            //设置显示位置：屏幕居中
            setDefaultCloseOperation(EXIT_ON_CLOSE);              //设置窗体关闭，退出系统JVM
            setLayout(null);            //去掉布局管理器，设置为绝对布局
        // 将面板加入窗口
        add(jPanel);
        add(jPanel2);
        add(jPanel3);
        add(jPanel4);
        add(jPanel5);
        //改变背景图片(5)
        ImageIcon i = new ImageIcon("img\\5.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,getWidth(),getHeight());
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(), Image.SCALE_DEFAULT));
        add(Label);
    }

    public static void main(String[] args) {
            //实例化并显示窗体
        new Login().setVisible(true);
    }
}
