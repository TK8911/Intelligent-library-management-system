package View;

import dao.userDao;
import entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyU extends  base{
    //���췽��
    ModifyU(String user){
        initFrame();
        initComp(user);
    }
    //���
    private JPanel jPanel = new JPanel();
    //��ʼ�����
    private void initComp(String user) {
        //�ı���ǩ
        JLabel jLabel = new JLabel("�û��� ��");
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel("ԭʼ���룺");
        JLabel jL=new JLabel();
        JLabel jLabel4 = new JLabel("�� �� �룺");
        JLabel jLabel5 = new JLabel("ȷ�����룺");
        //�ı���
        //JTextField field = new JTextField(22);
        JTextField field2 = new JTextField(22);
        JTextField field3 = new JTextField(22);
        //��ť
        JButton button = new JButton("�� ��");
        //λ��
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
        //�������
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
        //��ñ��
        jLabel2.setText(user);
        userDao u=new userDao();
        User user1=u.get(user);
        //�ص���ʾҳ��
        jL.setText(user1.getPassword());
        //�Ӽ����¼�: �޸�
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1=jL.getText();
                String s2=field2.getText();
                String s3=field3.getText();
                //��װʵ����
                if(s1.equals(s2)){
                    JOptionPane.showMessageDialog(ModifyU.this,"��������ԭ����һ�£�����������");
                    field2.setText("");
                    field3.setText("");
                }else if(s2.equals(s3)){
                    user1.setPassword(field2.getText());
                    boolean isok=u.update2(user1);
                    if(isok){
                        JOptionPane.showMessageDialog(ModifyU.this,"�����޸ĳɹ���");
                    }else{JOptionPane.showMessageDialog(ModifyU.this,"�����޸�ʧ�ܣ�");
                    }
                }else{
                    JOptionPane.showMessageDialog(ModifyU.this,"��������������벻һ�£�");
                }
            }
        });
    }
    //��ʼ������
    public void initFrame() {
        setSize(530,400);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        //���ڱ���
        setTitle("�˺������޸�");
        //���봰��
        add(jPanel);
    }

    public static void main(String[] args) {
        Login l=new Login();
        String user=l.getUser();
        //String user="alice";
        new ModifyU(user).setVisible(true);
    }
}
