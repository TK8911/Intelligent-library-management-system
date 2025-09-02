package View;

import cn.com.zcp.util.JDateChooser;
import dao.admindao;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

public class Register extends base{
    //构造方法
    Register(){
        initFrame();
        initComp();
    }
    // 面板
    private JPanel jPanel = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private JPanel jPanel3 = new JPanel();
    private JPanel jPanel4 = new JPanel();
    private JPanel jPanel5 = new JPanel();
    private JPanel jPanel6 = new JPanel();
    private JPanel jPanel7 = new JPanel();
    private JPanel jPanel8 = new JPanel();
    private JPanel jPanel9 = new JPanel();
    //初始化组件
    private void initComp(){
        //文本标签
        JLabel jLabel = new JLabel("注 册");
        JLabel jLabel2 = new JLabel("用 户 名：");
        JLabel jLabel3 = new JLabel(" 生   日：");
        JLabel jLabel4 = new JLabel("邮   箱 ：");
        JLabel jLabel5 = new JLabel("密   码 ：");
        JLabel jLabel6 = new JLabel("确认密码:");
        JLabel jLabel7 = new JLabel("密码长度：6~16位，不能含有空格 ");
        jLabel.setFont(font);
        jLabel2.setFont(font1);
        jLabel3.setFont(font1);
        jLabel4.setFont(font1);
        jLabel5.setFont(font1);
        jLabel6.setFont(font1);
        jLabel7.setFont(font4);
        jLabel7.setForeground(Color.red);
        jLabel7.setBounds(0, 310, 450, 25);
        jLabel.setBounds(170, 30, 150, 60);
        //文本框
           //日期
        JDateChooser dateChooser =JDateChooser.getInstance();
        JTextField field2 = new JTextField(18);
        dateChooser.register(field2);
          //一般
        JTextField field = new JTextField(15);
        JTextField field3 = new JTextField(16);
        JPasswordField field4 = new JPasswordField(16);
        JPasswordField field5 = new JPasswordField(16);
        field.setFont(font3);
        field3.setFont(font3);
        field4.setFont(font3);
        field5.setFont(font3);
        field.setForeground(Color.blue);
        field2.setForeground(Color.blue);
        field3.setForeground(Color.blue);
        field4.setForeground(Color.blue);
        field5.setForeground(Color.blue);
        //标签透明
        jLabel.setOpaque(false);
        jLabel2.setOpaque(false);
        jLabel3.setOpaque(false);
        jLabel4.setOpaque(false);
        jLabel5.setOpaque(false);
        jLabel6.setOpaque(false);
        jLabel7.setOpaque(false);
        // 文本框透明
        field.setOpaque(false);
        field2.setOpaque(false);
        field3.setOpaque(false);
        field4.setOpaque(false);
        field5.setOpaque(false);
        // 面板透明
        jPanel.setOpaque(false);
        jPanel2.setOpaque(false);
        jPanel3.setOpaque(false);
        jPanel4.setOpaque(false);
        jPanel5.setOpaque(false);
        jPanel6.setOpaque(false);
        jPanel7.setOpaque(false);
        jPanel8.setOpaque(false);
        jPanel9.setOpaque(false);

        // 按钮（一大一小一点击）
        JButton button = new JButton("注 册");
        button.setFont(font2);
        JButton button2 = new JButton("返回");
        button2.setFont(font3);
        button2.setBounds(2, 2, 70, 30);
        button2.setBackground(Color.cyan);
        button2.setOpaque(false);
        JLabel sexLB1=new JLabel("性 别：");
        sexLB1.setFont(font1);
        JRadioButton nan=new JRadioButton("男");
        add(nan);
        nan.setFont(font2);
        nan.setOpaque(false);
        JRadioButton nv=new JRadioButton("女");
        add(nv);
        nv.setFont(font2);
        nv.setOpaque(false);
        ButtonGroup group=new ButtonGroup();
        group.add(nan);
        group.add(nv);                      //限定：创建按钮组对象

        //加入面板
        jPanel.add(button2);
        jPanel.add(jLabel);
        jPanel2.add(jLabel2);
        jPanel2.add(field);
        jPanel3.add(jLabel3);
        jPanel3.add(field2);
        jPanel4.add(jLabel4);
        jPanel4.add(field3);
        jPanel5.add(sexLB1);         /**这里试验一下应该是怎么样吧*/
        jPanel5.add(nan);
        jPanel5.add(nv);
        jPanel6.add(jLabel5);
        jPanel6.add(field4);
        jPanel9.add(jLabel7);
        jPanel7.add(jLabel6);
        jPanel7.add(field5);
        jPanel8.add(button);
        jPanel.setLayout(null);
        // 面板位置
        jPanel.setBounds(0, 0, 450, 100);
        jPanel2.setBounds(0, 110, 450, 45);
        jPanel4.setBounds(0, 170, 450, 45);
        jPanel6.setBounds(0, 230, 450, 45);
        jPanel7.setBounds(0, 285, 450, 40);
        jPanel3.setBounds(0, 350, 450, 45);
        jPanel5.setBounds(0, 400, 450, 40);
        jPanel8.setBounds(0, 460, 450, 70);
        jPanel9.setBounds(220,325,200,15);
        //加监听事件
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admindao a = new admindao();
                if (field.getText() != null && field2.getText() != null && field3.getText() != null && field4.getText() != null&& field5.getText() != null) {
                    if(field4.getText().equals(field5.getText())) {
                        //封装实体类对象
                        User user = new User();
                        user.setUsername(field.getText());
                        user.setPassword(field4.getText());
                        user.setEmail(field3.getText());
                        user.setBirthday(DateUtil.toDate(field2.getText()));
                        LocalDate d = LocalDate.now();
                        Date now = Date.valueOf(d);
                        user.setRegisterDate(now);
                        int sex = 0;
                        if (nv.isSelected()) {
                            sex = 1;  //女性是1
                        }
                        user.setSex(sex);
                        boolean isok = a.add(user);
                        System.out.print(isok);
                        if (isok) {
                            JOptionPane.showMessageDialog(null, "注册成功！", "恭喜", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "注册失败，请重新尝试！", "警告", JOptionPane.WARNING_MESSAGE);
                        }
                    }else {
                        field5.setText("");
                        JOptionPane.showMessageDialog(null, "两次输入密码不一致，请确认后提交！", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "请填写完整信息！", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login().setVisible(true);
            }
        });
    }

    public void initFrame(){
       setSize(500,600);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(null);
       setTitle("注册");
       //加入窗口
        add(jPanel);
        add(jPanel2);
        add(jPanel3);
        add(jPanel4);
        add(jPanel5);
        add(jPanel6);
        add(jPanel7);
        add(jPanel8);
        //改变背景图片(10)
        ImageIcon i = new ImageIcon("img\\10.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,getWidth(),getHeight());
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(),Image.SCALE_DEFAULT));
        add(Label);
    }
    public static void main(String[] args) {
        //实例化并显示窗体
        new Register().setVisible(true);
    }
}
