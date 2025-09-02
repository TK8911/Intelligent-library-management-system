package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelfManage extends base{
    // �ֲ㴰��
    public JLayeredPane jLayeredPane = new JLayeredPane();
    //���췽��
    SelfManage(String user,int userid){
        initFrame();
        initComp(user,userid);
    }
    //���
    public JPanel jPanel = new JPanel();
    private String user;
    private int userid;
    public void setUser(String user) {
        this.user = user;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }

    //��ʼ�����
    private void initComp(String user,int userid) {
        //�ı���ǩ
        JLabel jLabel = new JLabel("�˻�����");
        jLabel.setFont(font6);
        jLabel.setBounds(460, 50, 800, 70);
        //��ť
        JButton button = new JButton("�޸�����");
        JButton button2 = new JButton("�޸���Ϣ");
        JButton button3 = new JButton("�����¼");
        JButton button4 = new JButton("�˳���½");
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
        //�������
        jPanel.add(button);
        jPanel.add(button2);
        jPanel.add(button3);
        jPanel.add(button4);
        jPanel.add(jLabel);
        jPanel.setLayout(null);
        jPanel.setBounds(0,0,1200,800);
        jPanel.setOpaque(false);
        //���λ��
        //�Ӽ����¼�
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
    //��ʼ������
    public void initFrame() {
        setSize(1200,800);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        //���ڱ���
        setTitle("ͼ�����ϵͳ");
        //���봰��
        add(jPanel);
        // �ı䱳��ͼƬ(8)
        ImageIcon i = new ImageIcon("img\\8.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,getWidth(),getHeight());
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(),Image.SCALE_DEFAULT));
        add(Label);
    }
    public static void main(String[] args) {
        //ʵ��������ʾ����
        Login l=new Login();
        String user=l.user;
        int userid= l.userid;
        new SelfManage(user,userid).setVisible(true);
    }
}
