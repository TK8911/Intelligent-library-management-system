package View;

import dao.admindao;
import dao.userDao;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** ��¼���� **/
public class Login extends base{
    Login(){
        initFrame();
        initComp();
    }
    // ���
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

    //��ʼ�����
    private void initComp() {
        //�ı���ǩ
        JLabel jLabel = new JLabel("ͼ�����ϵͳ");
        JLabel jLabel2 = new JLabel("�û�����");
        JLabel jLabel3 = new JLabel("��  �룺 ");
        jLabel.setFont(font);
        jLabel2.setFont(font1);
        jLabel3.setFont(font1);
        //�ı���
        field.setFont(font2);
        field2.setFont(font2);
        field.setPreferredSize(dimension1);
        field2.setPreferredSize(dimension1);
        //��ť
        JButton button = new JButton("��½");
        JButton button2 = new JButton("ע��");
        button.setFont(font2);
        button2.setFont(font2);
        button.setPreferredSize(dimension2);
        button2.setPreferredSize(dimension2);
        //�������
        jPanel.add(jLabel);
        jPanel2.add(jLabel2);
        jPanel2.add(field);
        jPanel3.add(jLabel3);
        jPanel3.add(field2);
        jPanel4.add(button);
        jPanel5.add(button2);
        // ����͸��
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
        //���λ��
        jPanel.setBounds(0, 60, 550, 80);
        jPanel2.setBounds(0, 165, 550, 80);
        jPanel3.setBounds(0, 250, 550, 60);
        jPanel4.setBounds(100, 325, 150, 80);
        jPanel5.setBounds(275, 325, 150, 80);
        //�Ӽ����¼�
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user = field.getText();
                String password = new String(field2.getPassword());
                admindao a=new admindao();
                boolean isa=a.login(user,password);
                boolean isok = u.login(user, password);
                if (isok) {
                    System.out.print("��¼�ɹ�����ȡ�û�����" + user);
                    setVisible(false);
                    user1=u.get(user);
                    userid=user1.getId();
                    new UserMain(user,userid).setVisible(true);
                    new SelfManage(user,userid);
                    new BorrowReturn(userid);
                    new LendRecordOne(userid);

                } else if (isa) {
                    System.out.print("����Ա��¼�ɹ�!" );
                    setVisible(false);
                    new adminMain().setVisible(true);
                } else {
                    System.out.print("��¼ʧ�ܣ�");
                    JOptionPane.showMessageDialog(Login.this, "�û�������������");
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
    //��ʼ������
    private void initFrame() {
            setSize(550,500);             //���ô�С
            setTitle("��¼");            //���ñ���
            setLocationRelativeTo(null);            //������ʾλ�ã���Ļ����
            setDefaultCloseOperation(EXIT_ON_CLOSE);              //���ô���رգ��˳�ϵͳJVM
            setLayout(null);            //ȥ�����ֹ�����������Ϊ���Բ���
        // �������봰��
        add(jPanel);
        add(jPanel2);
        add(jPanel3);
        add(jPanel4);
        add(jPanel5);
        //�ı䱳��ͼƬ(5)
        ImageIcon i = new ImageIcon("img\\5.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,getWidth(),getHeight());
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(), Image.SCALE_DEFAULT));
        add(Label);
    }

    public static void main(String[] args) {
            //ʵ��������ʾ����
        new Login().setVisible(true);
    }
}
