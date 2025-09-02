package View;

import dao.userDao;
import entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyU extends  base{
    //构造方法
    ModifyU(String user){
        initFrame();
        initComp(user);
    }
    //面板
    private JPanel jPanel = new JPanel();
    //初始化组件
    private void initComp(String user) {
        //文本标签
        JLabel jLabel = new JLabel("用户名 ：");
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel("原始密码：");
        JLabel jL=new JLabel();
        JLabel jLabel4 = new JLabel("新 密 码：");
        JLabel jLabel5 = new JLabel("确认密码：");
        //文本框
        //JTextField field = new JTextField(22);
        JTextField field2 = new JTextField(22);
        JTextField field3 = new JTextField(22);
        //按钮
        JButton button = new JButton("修 改");
        //位置
        jLabel.setFont(font1);
        jLabel2.setFont(font1);
        jLabel3.setFont(font1);
        jLabel4.setFont(font1);
        jLabel5.setFont(font1);
        jL.setFont(font2);
        field2.setFont(font2);
        field3.setFont(font2);
        button.setFont(font2);
        jLabel.setBounds(110, 80, 150, 30);
        jLabel2.setBounds(250, 80, 300, 30);
        jLabel3.setBounds(110, 120, 150, 30);
        jL.setBounds(250, 125, 160, 25);
        jLabel4.setBounds(110, 160, 150, 30);
        field2.setBounds(250, 165, 160, 25);
        jLabel5.setBounds(120, 210, 150, 30);
        field3.setBounds(250, 215, 160, 25);
        button.setBounds(115, 270, 280, 30);
        //加入面板
        jPanel.add(jLabel);
        jPanel.add(jLabel2);
        jPanel.add(jLabel3);
        jPanel.add(jL);
        jPanel.add(jLabel4);
        jPanel.add(field2);
        jPanel.add(jLabel5);
        jPanel.add(field3);
        jPanel.add(button);
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, 530, 400);
        jPanel.setOpaque(false);
        //获得编号
        jLabel2.setText(user);
        userDao u=new userDao();
        User user1=u.get(user);
        //回到显示页面
        jL.setText(user1.getPassword());
        //加监听事件: 修改
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1=jL.getText();
                String s2=field2.getText();
                String s3=field3.getText();
                //封装实体类
                if(s1.equals(s2)){
                    JOptionPane.showMessageDialog(ModifyU.this,"新密码与原密码一致！请重新输入");
                    field2.setText("");
                    field3.setText("");
                }else if(s2.equals(s3)){
                    user1.setPassword(field2.getText());
                    boolean isok=u.update2(user1);
                    if(isok){
                        JOptionPane.showMessageDialog(ModifyU.this,"密码修改成功！");
                    }else{JOptionPane.showMessageDialog(ModifyU.this,"密码修改失败！");
                    }
                }else{
                    JOptionPane.showMessageDialog(ModifyU.this,"两次输入的新密码不一致！");
                }
            }
        });
    }
    //初始化窗口
    public void initFrame() {
        setSize(530,400);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        //窗口标题
        setTitle("账号密码修改");
        //加入窗口
        add(jPanel);
    }

    public static void main(String[] args) {
        Login l=new Login();
        String user=l.getUser();
        //String user="alice";
        new ModifyU(user).setVisible(true);
    }
}
