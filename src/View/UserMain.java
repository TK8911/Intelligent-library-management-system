package View;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMain extends base {    //���
    private JLabel jLabel = new JLabel("��ӭ��½ͼ�����ϵͳ!");
    public JMenuBar bar=new JMenuBar();
    //���췽��
    UserMain(String user,int userid){
        initComp(user,userid);
        initFrame();
    }
    //��ʼ�����
    private void initComp(String user,int userid) {
        //�ı���ǩ
        jLabel.setFont(font5);
        jLabel.setBounds(230, 90, 800,200);
        jLabel.setForeground(new Color(255,215,0));

        JMenu menu1=new JMenu("������");
        JMenu menu2=new JMenu("���ܲ˵�");
        JMenu menu3=new JMenu("���ӻ�ͼ���");

        JMenuItem menuItem = new JMenuItem("�鼮����");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchBook().setVisible(true);
            }
        });
        JMenuItem m3 = new JMenuItem("ͼ��軹");
        m3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BorrowReturn(userid).setVisible(true);
            }
        });
        JMenuItem m4 = new JMenuItem("�˺Ź���");
        m4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelfManage(user,userid).setVisible(true);
            }
        });
        JMenuItem m5 = new JMenuItem("����");
        m5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Notice().setVisible(true);
            }
        });
        menu2.add(menuItem);
        menu2.add(m3);
        menu2.add(m4);
        menu2.add(m5);

        JMenuItem mu1= new JMenuItem("��ͬ���ͼ��ռ��");
        mu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    V1pie ex = new V1pie();
                    ex.setVisible(true);
                });
            }
        });
        JMenuItem mu11= new JMenuItem("2022-2023���½��ļ�¼");
        mu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    V2line ex = new V2line();
                    ex.setVisible(true);
                });
            }
        });
        JMenuItem mu111= new JMenuItem("��ע������");
        mu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    V3bar ex = new V3bar();
                    ex.setVisible(true);
                });
            }
        });

        JMenuItem mu2= new JMenuItem("ͼ������");
        mu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new V4ins(userid).setVisible(true);
            }
        });

        menu3.add(mu1);
        menu3.add(mu11);
        menu3.add(mu111);
        menu2.add(mu2);

        bar.setFont(font2);
        bar.add(menu1);
        bar.add(menu2);
        bar.add(menu3);
        bar.setBounds(0,0,1200,30);
    }
    //��ʼ������
    public void initFrame() {
        setSize(1200,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        //���ڱ���
        setTitle("ͼ�����ϵͳ");
        add(jLabel);
        add(bar);
        //�ı䱳��
        ImageIcon i = new ImageIcon("img\\3.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,getWidth(),getHeight());
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(),Image.SCALE_DEFAULT));
        add(Label);

        setVisible(true);
    }
    public static void main(String[] args) {
        //ʵ��������ʾ����
        Login l=new Login();
        String user=l.getUser();
        int userid=l.getUserid();
        new UserMain(user,userid).setVisible(true);
    }
}


