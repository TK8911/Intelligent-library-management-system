package View;

import dao.userDao;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyP extends base{
    //���췽��
    ModifyP(String user) {
        initFrame();
        initComp(user);
    }
    //���
    private JPanel jPanel = new JPanel();
    //��ʼ�����
    private void initComp(String user) {
        //�ı���ǩ
        JLabel jLabel = new JLabel("�û�����");
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel("��  �䣺");
        JLabel jLabel4 = new JLabel("��  �飺");
        JLabel jLabel5=new JLabel("��ò�Ҫ����50��Ŷ��");
        //�ı���
        JTextField field = new JTextField(25);
        JTextArea field2 = new JTextArea(24,7);
        field2.setEditable(true);
        field2.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(field2);
        //��ť
        JButton button = new JButton("�� ��");
        //λ��
        jLabel.setFont(font1);
        jLabel2.setFont(font1);
        jLabel3.setFont(font1);
        jLabel4.setFont(font1);
        field.setFont(font3);
        field2.setFont(font3);
        button.setFont(font2);
        jLabel.setBounds(80, 180, 110, 30);
        jLabel2.setBounds(190, 180, 300, 30);
        jLabel3.setBounds(80, 230, 100, 30);
        field.setBounds(190, 230, 200, 30);
        jLabel4.setBounds(80, 280, 100, 30);
        field2.setBounds(190, 280, 200, 150);
        button.setBounds(105, 480, 268, 30);
        jLabel5.setFont(font4);
        jLabel5.setBounds(190,440,150,15);
        //�������
        jPanel.add(jLabel);
        jPanel.add(jLabel2);
        jPanel.add(jLabel3);
        jPanel.add(field);
        jPanel.add(jLabel4);
        jPanel.add(field2);
        jPanel.add(button);
        jPanel.add(jLabel5);
        jPanel.add(scrollPane);
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, 480, 620);
        jPanel.setOpaque(false);
        //�����û���
        jLabel2.setText(user);
        userDao u=new userDao();
        User user1=u.get(user);
        //�ص���ʾҳ��
        field.setText(user1.getEmail());
        field2.setText(user1.getIntroduction());
        //�޸�
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //��װʵ����
                user1.setEmail(field.getText());
                user1.setIntroduction(field2.getText());
                boolean isok=u.update1(user1);
                if(isok){
                    JOptionPane.showMessageDialog(ModifyP.this,"�޸ĳɹ���");
                }else{JOptionPane.showMessageDialog(ModifyP.this,"�޸�ʧ�ܣ�");
                }
            }
        });
    }

    //��ʼ������
    public void initFrame() {
        setSize(480, 620);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        //���ڱ���
        setTitle("�˺���Ϣ�޸�");
        //���봰��
        add(jPanel);
        // �ı䱳��ͼƬ
        ImageIcon i = new ImageIcon("img\\6.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,getWidth(),150);
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(),Image.SCALE_DEFAULT));
        add(Label);
    }

    public static void main(String[] args) {
        Login l=new Login();
        String user=l.getUser();
        //String user="alice";  //����ʹ��
        new ModifyP(user).setVisible(true);
    }
}
