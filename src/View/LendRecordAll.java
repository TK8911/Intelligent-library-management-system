package View;


import dao.admindao;
import entity.Lend;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

public class LendRecordAll extends base {
    //���췽��
    public LendRecordAll(){
        initFrame();
        initDataTbl();
    }
    //��ʼ�����
    private JPanel panel1=new JPanel();

    private void initDataTbl(){
        String[] h={"�û�id","�鼮id","����","��������","�黹����","�鼮��״","�û���"};
        Vector<String> header=new Vector<>(Arrays.asList(h)); //��ʼ����ͷ����̬�б�
        Vector data=new Vector<>();
        JTable dataTbl=new JTable(data,header);  //��ʼ�����
        //��ʼ���ƶ���
        JScrollPane jScrollPane = new JScrollPane(dataTbl);
        jScrollPane.setBounds(5,8,getWidth()-25,getHeight()-160);
        // ���ñ����п�  dataTbl.setRowHeight(15);
        // ���ñ�����������С   dataTbl.setFont(font4);

        JLabel jl1=new JLabel("�û�����");
        JLabel jl2=new JLabel("��  ����");
        JLabel jl3=new JLabel("��ѯ�꣺");
        JLabel jl4=new JLabel("��ѯ�£�");
        JTextField fl1=new JTextField();
        JTextField fl2=new JTextField();
        JTextField fl3=new JTextField();
        JTextField fl4=new JTextField();
        Button b1=new Button("�� ѯ");

        jl1.setBounds(30,15,54,18);
        jl2.setBounds(215,15,54,18);
        jl3.setBounds(30,50,54,18);
        jl4.setBounds(215,50,54,18);
        fl1.setBounds(95,15,106,22);
        fl2.setBounds(280,15,106,22);
        fl3.setBounds(95,50,106,22);
        fl4.setBounds(280,50,106,22);
        b1.setBounds(425,26,106,30);

        //����
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admindao a=new admindao();
                //��װ
                Lend l=new Lend();
                l.setUsername(fl1.getText());
                l.setBookname(fl2.getText());
                l.setYear(fl3.getText());
                l.setMonth(fl4.getText());
                //ʹ��
                System.out.print(header);
                Vector data=a.searchall(l);
                DefaultTableModel model=(DefaultTableModel) dataTbl.getModel();
                model.setDataVector(data,header);
            }
        });

        panel1.add(jl1);
        panel1.add(jl2);
        panel1.add(jl3);
        panel1.add(jl4);
        panel1.add(fl1);
        panel1.add(fl2);
        panel1.add(fl3);
        panel1.add(fl4);
        panel1.add(b1);
        add(jScrollPane);

        panel1.setLayout(null);
        panel1.setBorder(LineBorder.createGrayLineBorder());
        panel1.setBounds(5,getHeight()-140,getWidth()-25,93);
        panel1.setVisible(true);
    }
    public void initFrame() {
        //JFrame frame=new JFrame();
        //frame.add(panel1);
        //���ڱ���
        setTitle("���Ĳ�ѯ");
        add(panel1);
        setSize(600,400);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        new LendRecordAll().setVisible(true);
    }
}
