package View;

import dao.userDao;
import entity.User;

import javax.swing.*;
import java.awt.*;

public class V4ins extends base{
    //���췽��
    V4ins(int userid){
        initComp(userid);
        initFrame();
    }
    //���
    private JPanel jPanel = new JPanel();
    private void initComp(int userid) {
        //�ı���ǩ
        JLabel jLabel = new JLabel("�װ��� ");
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel1=new JLabel();
        JLabel jLabel4 = new JLabel("���ڱ��ݹ��ƽ��� ");
        JLabel jLabel5 = new JLabel();
        JLabel field2 = new JLabel();
        JLabel field3 = new JLabel("���Ƕ���ĺ����,");
        JLabel button =new JLabel("ϣ���Ķ�����Ϊ������������Ȥ��");
       //λ��
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
        //�������
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
        //��ñ��
        userDao u=new userDao();
        User user1=u.ins(userid);
        User user2=u.ins2(userid);
        jLabel2.setText(user1.getUsername());
        jLabel3.setText("���������뱾����ʶ�ĵ� "+ user1.getReg_ins() +"��");
        field2.setText(user2.getBorR() +"��");
        jLabel5.setText(user1.getAge() +"��");
        //�ص���ʾҳ��
        jLabel1.setText(user1.getPassword());
    }
    private void initFrame() {
        setSize(530,400);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        //���ڱ���
        setTitle("ͼ������");
        //���봰��
        add(jPanel);
        //�ı䱳��ͼƬ(5)
        ImageIcon i = new ImageIcon("img\\1.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,getWidth(),getHeight());
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(), Image.SCALE_DEFAULT));
        add(Label);
    }
    public static void main(String[] args) {
        //ʵ��������ʾ����
        //int userid=1;           //����
        Login l=new Login();
        int userid=l.getUserid();
        new V4ins(userid).setVisible(true);
    }
}
