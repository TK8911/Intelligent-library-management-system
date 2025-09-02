package View;

import dao.bookdao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Vector;

public class SearchBook extends base{
    //���췽��
    SearchBook(){
        initDataTable();
        initFrame();
    }
    // �ֲ㴰��
    private String s;
    private String str;
    private int id;
    //��ʼ������
    public void initFrame() {
        setSize(1200,800);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        //���ڱ���
        setTitle("ͼ�����ϵͳ");
        // �ı䱳��ͼƬ
        ImageIcon i = new ImageIcon("img\\12.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,getWidth(),getHeight());
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(),Image.SCALE_DEFAULT));
        add(Label);
    }
    //��ʼ�����ݱ�
    public void initDataTable(){
        String[] h={"�鼮���","���","�� ��","�� ��","������","״̬"};
        Vector<String> header=new Vector<>(Arrays.asList(h));
        Vector data=new Vector();
        JTable dataTbl=new JTable(data,header);
        JScrollPane jScrollPane = new JScrollPane(dataTbl);
        jScrollPane.setBounds(180, 250, 800, 400);
        add(jScrollPane);

        //�ı���ǩ
        JLabel jLabel = new JLabel("ͼ���ѯ");
        JLabel jLabel2 = new JLabel("��ѡ���ѯ��ʽ��");
        jLabel.setFont(font);
        jLabel.setBounds(485, 35, 800, 100);
        jLabel.setForeground(Color.cyan);
        jLabel2.setFont(font1);
        jLabel2.setBounds(180, 130, 250, 30);
        jLabel2.setForeground(Color.cyan);
        add(jLabel2);
        add(jLabel);
        //�ı���
        JTextField field = new JTextField(25);
        field.setFont(font2);
        field.setSize(dimension1);
        field.setBackground(Color.cyan);
        field.setBounds(480, 173, 250, 35);
        field.setForeground(Color.cyan);
        field.setOpaque(false);
        add(field);
        //��ť
        JButton button = new JButton("����");
        button.setFont(font2);
        button.setBounds(850, 170, 100, 40);
        button.setForeground(Color.cyan);
        button.setBackground(Color.cyan);
        button.setOpaque(false);
        add(button);
        //������
        JComboBox<Object> Combox1 = new JComboBox<>();
        Combox1.setSize(dimension4);
        add(Combox1);
        Combox1.addItem("��������ȫ������");
        Combox1.addItem("����������");
        Combox1.addItem("������������");
        Combox1.addItem("�������߲���");
        Combox1.addItem("������Ų���");
        Combox1.setFont(font2);
        Combox1.setBounds(180, 170, 200, 40);
        Combox1.setOpaque(false);
        //��ȡ�����б�ֵ
        s = "��������ȫ������";
        Combox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED) {
                    s=(String)e.getItem();
                }
            }
        });
        //��ť
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookdao b=new bookdao();
                if (s.equals("��������ȫ������")){
                    Vector data=b.bookAll();
                    System.out.print(header);  //���鱨������õ�
                    DefaultTableModel model=(DefaultTableModel) dataTbl.getModel();
                    model.setDataVector(data,header);
                    System.out.print(data);    //���鱨������õ�
                }
                else if (s.equals("����������")){
                    try {
                        str= "%" +field.getText()+ "%" ;
                        Vector data=b.bookT(str);
                        System.out.print(header);  //���鱨������õ�
                        DefaultTableModel model=(DefaultTableModel) dataTbl.getModel();
                        model.setDataVector(data,header);
                        System.out.print(data);    //���鱨������õ�
                    } catch (Exception e1) {
                    }
                }else if (s.equals("������������")){
                    str= "%" +field.getText()+ "%" ;
                    Vector data=b.bookN(str);
                    System.out.print(header);  //���鱨������õ�
                    DefaultTableModel model=(DefaultTableModel) dataTbl.getModel();
                    model.setDataVector(data,header);
                    System.out.print(data);    //���鱨������õ�
                }else if (s.equals("�������߲���")){
                    str="%" +field.getText()+"%";
                    Vector data=b.bookA(str);
                    System.out.print(header);  //���鱨������õ�
                    DefaultTableModel model=(DefaultTableModel) dataTbl.getModel();
                    model.setDataVector(data,header);
                    System.out.print(data);    //���鱨������õ�
                }else if (s.equals("������Ų���")) {
                    try {
                        id = Integer.parseInt(field.getText());
                        Vector data = b.bookI(id);
                        System.out.print(header);  //���鱨������õ�
                        DefaultTableModel model=(DefaultTableModel) dataTbl.getModel();
                        model.setDataVector(data,header);
                        System.out.print(data);    //���鱨������õ�
                    } catch (Exception e1) {
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        //ʵ��������ʾ����
        new SearchBook().setVisible(true);
    }
}
