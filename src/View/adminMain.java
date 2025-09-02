package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminMain extends View.base {
    private JLabel jLabel = new JLabel("��ӭ��½ͼ�����ϵͳ!");
    private JPanel jp= new JPanel();
    //���췽��
    adminMain(){
        initComp();
        initFrame();
    }
    //��ʼ�����
    private void initComp() {
        //�ı���ǩ
        jLabel.setFont(font5);
        jLabel.setBounds(230, 90, 800,200);
        jLabel.setForeground(new Color(240,220,105));
        //��ť
        Button b1=new Button("�鼮����");
        Button b2=new Button("ͼ���ѯ");
        Button b3=new Button("���Ĳ�ѯ");
        Button b4=new Button("��������");
        b1.setFont(font2);
        b2.setFont(font2);
        b3.setFont(font2);
        b4.setFont(font2);
        b1.setBounds(200,600,180,50);
        b2.setBounds(420,600,180,50);
        b3.setBounds(640,600,180,50);
        b4.setBounds(860,600,180,50);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookManage().setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchBook().setVisible(true);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LendRecordAll().setResizable(true);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddNotice().setVisible(true);
            }
        });

        //���
        jp.add(b1);
        jp.add(b2);
        jp.add(b3);
        jp.add(b4);
        jp.setLayout(null);
        jp.setBounds(0,0,1200,800);
        jp.setOpaque(false);
    }
    //��ʼ������
    public void initFrame() {
        setSize(1200,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        //���ڱ���
        setTitle("ͼ�����ϵͳ");
        add(jLabel);
        add(jp);
        //�ı䱳��
        ImageIcon i = new ImageIcon("img\\4.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,getWidth(),getHeight());
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(),Image.SCALE_DEFAULT));
        add(Label);
        setVisible(true);
    }

    public static void main(String[] args) {
        new adminMain().setResizable(true);
    }
}
