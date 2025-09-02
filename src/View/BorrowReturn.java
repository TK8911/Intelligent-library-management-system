package View;


import dao.LendDao;
import entity.Book;
import entity.Lend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

public class BorrowReturn extends base{
//���
private JPanel jPanel = new JPanel();
private JPanel jPanel2 = new JPanel();
private int bookid,uid;
    //���췽��
    BorrowReturn(int user){
        initFrame();
        initComp(user);
    }
    //��ʼ�����
    private void initComp(int user) {
        //�ı���ǩ
        JLabel jLabel = new JLabel("ͼ��軹");
        JLabel jLabel2 = new JLabel("��������ţ�");
        JLabel jLabel3 = new JLabel("������");
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel("���ߣ�");
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel("״̬��");
        JLabel jLabel8 = new JLabel();
        JLabel jLabel9 = new JLabel("��ţ�");
        JLabel jLabel10 = new JLabel();
        jLabel.setFont(font6);
        jLabel.setBounds(480, 35, 800, 100);
        jLabel.setForeground(Color.black);
        jLabel2.setFont(font1);
        jLabel2.setBounds(280, 164, 250, 30);
        jLabel2.setForeground(Color.black);
        jLabel3.setFont(font1);
        jLabel4.setFont(font1);
        jLabel5.setFont(font1);
        jLabel6.setFont(font1);
        jLabel7.setFont(font1);
        jLabel8.setFont(font1);
        jLabel9.setFont(font1);
        jLabel10.setFont(font1);
        jLabel3.setForeground(Color.black);
        jLabel4.setForeground(Color.black);
        jLabel5.setForeground(Color.black);
        jLabel6.setForeground(Color.black);
        jLabel7.setForeground(Color.black);
        jLabel8.setForeground(Color.black);
        jLabel9.setForeground(Color.black);
        jLabel10.setForeground(Color.black);
        jLabel9.setBounds(100, 20, 100, 50);
        jLabel10.setBounds(200, 20, 400, 50);
        jLabel3.setBounds(100, 90, 100, 50);
        jLabel4.setBounds(200, 90, 400, 50);
        jLabel5.setBounds(100, 160, 100, 50);
        jLabel6.setBounds(200, 160, 400, 50);
        jLabel7.setBounds(100, 230, 100, 50);
        jLabel8.setBounds(200, 230, 400, 50);
        //�ı���
        JTextField field = new JTextField(20);
        field.setFont(font1);
        field.setBackground(Color.black);
        field.setBounds(480, 164, 250, 30);
        field.setForeground(Color.black);
        field.setOpaque(false);
        jPanel.add(jLabel3);
        jPanel.add(jLabel4);
        jPanel.add(jLabel5);
        jPanel.add(jLabel6);
        jPanel.add(jLabel7);
        jPanel.add(jLabel8);
        jPanel.add(jLabel9);
        jPanel.add(jLabel10);
        jPanel.setOpaque(false);
        jPanel.setBackground(Color.gray);
        jPanel.setLayout(null);
        jPanel.setBounds(270, 220, 620, 450);
        jPanel2.add(jLabel);
        jPanel2.add(jLabel2);
        jPanel2.add(field);
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);
        jPanel2.setBounds(0, 0, 1200, 800);

        //��ť
        JButton button = new JButton("����");
        JButton button2 = new JButton("����");
        JButton button3 = new JButton("����");
        button.setFont(font1);
        button.setBounds(780, 160, 100, 40);
        button.setForeground(Color.black);
        button.setBackground(Color.black);
        button.setOpaque(false);
        button2.setFont(font2);
        button3.setFont(font2);
        button2.setBounds(80, 310, 90, 50);
        button3.setBounds(460, 310, 90, 50);
        button2.setBackground(Color.black);
        button2.setOpaque(false);
        button3.setBackground(Color.black);
        button3.setOpaque(false);
        button2.setForeground(Color.black);
        button3.setForeground(Color.black);
        jPanel.add(button2);
        jPanel.add(button3);
        jPanel2.add(button);

        //�Ӽ����¼�
        LendDao ld=new LendDao();
        LocalDate d = LocalDate.now();
        Date now = Date.valueOf(d);  //�˿̵�ʱ��
              //����
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookid= Integer.parseInt(field.getText());
                Book book=ld.getB(bookid);
                try {
                    if(book!=null){
                        jLabel10.setText(String.valueOf(bookid));
                        jLabel4.setText(book.getName());
                        jLabel6.setText(book.getAuthor());
                        jLabel8.setText(book.getStatus());
                    }else{
                        JOptionPane.showMessageDialog(null, "ͼ�鲻����", "����", JOptionPane.WARNING_MESSAGE);
                        jLabel4.setText("");
                        jLabel6.setText("");
                        jLabel8.setText("");
                        jLabel10.setText("");
                    }
                }catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "���벻��ȷ", "����", JOptionPane.WARNING_MESSAGE);
                    field.setText("");
                }
            }
        });
              //����
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jLabel8.getText().equals("���")) {
                    bookid= Integer.parseInt(field.getText());
                    Lend l3=ld.getL(bookid);
                    Book book=ld.getB(bookid);
                    uid=l3.getUserid();   //��user�Ա�

                    System.out.print(uid);
                    System.out.print(user);

                    if(uid==user){
                        //��װʵ����
                        book.setStatus("�ڹ�");
                        l3.setStatus("�ڹ�");
                        l3.setBackDate(now);
                        boolean isok=ld.update1(book);
                        boolean isok1=ld.update2(l3);
                        if(isok && isok1){
                            JOptionPane.showMessageDialog(BorrowReturn.this,"����ɹ���");
                            jLabel8.setText("�ڹ�");
                        }else{JOptionPane.showMessageDialog(BorrowReturn.this,"����ʧ�ܣ�");
                        }
                        //���ڿ���
                        System.out.print(isok);
                        System.out.print(isok1);
                    }else {
                        JOptionPane.showMessageDialog(null, "���鲻�������Ŷ��", "��ϲ", JOptionPane.WARNING_MESSAGE);
                    }
                }else if (jLabel8.getText().equals("�ڹ�")) {
                    JOptionPane.showMessageDialog(null, "�����ڹ�Ŷ��", "����", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "����", "����", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
              //����
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jLabel8.getText().equals("���")) {
                    JOptionPane.showMessageDialog(null, "���鲻�ڹ�Ŷ���볢�Խ��������鼮~", "����", JOptionPane.WARNING_MESSAGE);
                } else if (jLabel8.getText().equals("�ڹ�")){
                    bookid= Integer.parseInt(field.getText());
                    Book book=ld.getB(bookid);
                    Lend l2=new Lend();
                    //��װʵ����
                    book.setStatus("���");

                    l2.setUserid(user);
                    l2.setBookId(bookid);
                    l2.setBookname(book.getName());
                    l2.setLendDte(now);
                    l2.setStatus("���");
                    boolean isok2=ld.addR(l2);
                    boolean isok1=ld.update1(book);
                    if(isok2 && isok1){
                        JOptionPane.showMessageDialog(BorrowReturn.this,"����ɹ���");
                        jLabel8.setText("���");
                    } else{
                        JOptionPane.showMessageDialog(BorrowReturn.this,"����ʧ�ܣ�");
                    }
                    //���ڿ���
                    System.out.print(isok1);
                    System.out.print(isok2);
                }else {
                    JOptionPane.showMessageDialog(null, "����", "����", JOptionPane.WARNING_MESSAGE);
                }
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
        add(jPanel2);
        // �ı䱳��ͼƬ
        ImageIcon i = new ImageIcon("img\\9.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,getWidth(),getHeight());
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(),Image.SCALE_DEFAULT));
        add(Label);
    }

    public static void main(String[] args) {
        //int user1=1;  //����ʹ��
        Login l=new Login();
        int user1=l.getUserid();
        new BorrowReturn(user1).setVisible(true);
    }
}

