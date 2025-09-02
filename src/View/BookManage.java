package View;

import dao.admindao;
import entity.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class BookManage extends base {
   //���췽��
    public BookManage(){
        initFrame();
        initOpArea();
        initFun();
    }
    private admindao a=new admindao();
    //�������
    //��̬������
    private Vector<String> types=a.type();
    private JComboBox<String> typeBox=new JComboBox<>(types);

    private JPanel panel1=new JPanel();
    private JPanel panel2=new JPanel();
    private JPanel panel3=new JPanel();
    private JPanel panel4=new JPanel();
    private JPanel panel5=new JPanel();
    private JPanel panel6=new JPanel();
    private Label jl1=new Label("�� �ţ�");
    private Label jl2=new Label("�� ����");
    private Label jl3=new Label("�� �ߣ�");
    private Label jl4=new Label("�� �ͣ�");
    private Label jl5=new Label("�����磺");
    private JTextField f1=new JTextField(20);
    private JTextField f2=new JTextField(20);
    private JTextField f3=new JTextField(20);
    //private JTextField f4=new JTextField(20);
    private JTextField f5=new JTextField(20);
    private Button b1=new Button("���");
    private Button b2=new Button("��ѯ");
    private Button b3=new Button("�޸�");
    private Button b4=new Button("ɾ��");
    private Button b5=new Button("ȡ��");
    //��ʼ�����
    public void initOpArea() {
        typeBox.setSize(dimension2);
        //����
        jl1.setFont(font2);
        jl2.setFont(font2);
        jl3.setFont(font2);
        jl4.setFont(font2);
        jl5.setFont(font2);
        f1.setFont(font3);
        f2.setFont(font3);
        f3.setFont(font3);
        typeBox.setFont(font3);
        f5.setFont(font3);
        b1.setFont(font2);
        b2.setFont(font2);
        b3.setFont(font2);
        b4.setFont(font2);
        b5.setFont(font2);
        b1.setSize(dimension1);
        b2.setSize(dimension1);
        b3.setSize(dimension1);
        b4.setSize(dimension1);
        b5.setSize(dimension1);
        typeBox.setSize(dimension2);
        //����
        panel1.add(jl1);
        panel1.add(f1);
        panel2.add(jl2);
        panel2.add(f2);
        panel3.add(jl3);
        panel3.add(f3);
        panel4.add(jl4);
        panel4.add(typeBox);
        panel5.add(jl5);
        panel5.add(f5);
        panel6.add(b1);
        panel6.add(b2);
        panel6.add(b3);
        panel6.add(b4);
        panel6.add(b5);
        //panel6.setLayout(null);
        //λ��
        panel1.setBounds(0,20,getWidth(),60);
        panel2.setBounds(0,80,getWidth(),60);
        panel3.setBounds(0,140,getWidth(),60);
        panel4.setBounds(0,200,getWidth(),60);
        panel5.setBounds(0,260,getWidth(),60);
        panel6.setBounds(0,320,getWidth(),60);
    }
    //���ܾ��廯
    private void initFun() {
        //�Ӽ����¼�
        //����鼮
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (f1.getText().equals("")){
                    if(f2.getText().equals("") || f3.getText().equals("")|| typeBox.getSelectedItem().equals("")|| f5.getText().equals("")) {
                        Book b = new Book();
                        b.setName(f2.getText());
                        b.setAuthor(f3.getText());
                        b.setType(typeBox.getSelectedItem().toString());
                        b.setPublish(f5.getText());
                        boolean isok = a.addB(b);
                        if (isok) {
                            int bid = b.getId();
                            JOptionPane.showMessageDialog(BookManage.this, "��ӳɹ����������Ϊ" + bid);
                        } else {
                            JOptionPane.showMessageDialog(BookManage.this, "���ʧ�ܣ�");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "��������鼮��Ϣ������!", "����", JOptionPane.WARNING_MESSAGE);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "��������鼮�����ֶ�������", "����", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        //��Ų�ѯ
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = f1.getText().trim(); // ȥ��ǰ��հ�
                int id = 0;
                try {
                    id = Integer.parseInt(text);
                    Book b = a.get(id);
                    f2.setText(b.getName());
                    f3.setText(b.getAuthor());
                    typeBox.setSelectedItem(b.getType());
                    f5.setText(b.getPublish());
                }catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "����������Ҫɾ���鼮����ţ�", "����", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        //�޸��鼮
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = f1.getText().trim(); // ȥ��ǰ��հ�
                int id = 0;
                try {
                    id = Integer.parseInt(text);
                    Book b = new Book();
                    b.setId(id);
                    b.setName(f2.getText());
                    b.setAuthor(f3.getText());
                    b.setType(typeBox.getSelectedItem().toString());
                    b.setPublish(f5.getText());

                    boolean isok = a.update(b);
                    if (isok) {
                        JOptionPane.showMessageDialog(BookManage.this, "�޸ĳɹ���");
                    } else {
                        JOptionPane.showMessageDialog(BookManage.this, "�޸�ʧ�ܣ�");
                    }
                }catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "����������Ҫɾ���鼮����ţ�", "����", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        //ɾ���鼮
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = f1.getText().trim(); // ȥ��ǰ��հ�
                int id = 0;
                try {id = Integer.parseInt(text);

                    int op=JOptionPane.showConfirmDialog(BookManage.this,"��ȷ��ɾ��������");
                    if(op!=JOptionPane.OK_OPTION){
                        return;    //��ȷ������ֱ�ӷ���
                    }
                    boolean isok=a.del(id);
                    if(isok){
                        f1.setText("");
                        f2.setText("");
                        f3.setText("");
                        typeBox.setSelectedItem("");
                        f5.setText("");
                        JOptionPane.showMessageDialog(null, "ɾ���ɹ���", "֪ͨ", JOptionPane.WARNING_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�", "����", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "����������Ҫɾ���鼮����ţ�", "����", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        //ȡ�����ÿգ�
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setText("");
                f2.setText("");
                f3.setText("");
                typeBox.setSelectedItem("");
                f5.setText("");
            }
        });
    }
    //��ʼ������
    public void initFrame(){
        setSize(600,435);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setTitle("�鼮����");
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        add(panel6);
    }
    public static void main(String[] args) {
        new BookManage().setVisible(true);
    }
}
