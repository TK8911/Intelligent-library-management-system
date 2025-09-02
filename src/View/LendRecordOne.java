package View;

import com.sun.glass.ui.Size;
import dao.userDao;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

public class LendRecordOne extends base{
    //���췽��
    LendRecordOne(int user){
        initDataTable(user);
        initFrame();
    }
    // ���
    private JPanel jPanel = new JPanel();
    //��ʼ������
    public void initFrame() {
        setSize(800,600);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        //���ڱ���
        setTitle("ͼ�����ϵͳ");
        // �ı䱳��ͼƬ
        ImageIcon i = new ImageIcon("img\\2.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,800,100);
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(),Image.SCALE_DEFAULT));
        //���봰��
        add(Label);
        add(jPanel);
    }
    public void initDataTable(int user) {
        //��ǩ
        JLabel jLabel = new JLabel("�����¼");
        jLabel.setFont(font);
        jLabel.setBounds(315, 80, 400, 100);
        jPanel.add(jLabel);
        // ���
        String[] h={"�鼮���","�� ��","��������","��������","״̬"};
        Vector<String> header=new Vector<>(Arrays.asList(h));
        //Vector data=new Vector();  �ÿ�
        //�����û���
        userDao u=new userDao();
        //Vector data=new Vector();
        Vector data=u.borrow2(user);
        JTable dataTbl=new JTable(data,header);
        JScrollPane jScrollPane = new JScrollPane(dataTbl);
        jScrollPane.setBounds(80, 160, 640, 350);
        add(jScrollPane);
        System.out.print(header);  //���鱨������õ�
        DefaultTableModel model=(DefaultTableModel) dataTbl.getModel();
        model.setDataVector(data,header);
        System.out.print(data);
        // ���ñ����п�
        dataTbl.setRowHeight(25);
        // ���ñ�����������С
        dataTbl.setFont(new Font("����", Font.ROMAN_BASELINE, 17));

        jPanel.setBounds(0, 0, 800, 200);
        jPanel.setOpaque(false);
        jPanel.setLayout(null);
        setTitle("�����¼");
        // �����Ըı䴰��Ĵ�С
        setResizable(false);
        //setVisible(true);
    }

    public static void main(String[] args) {
        Login l=new Login();
        int user=l.userid;
        //int user1=1;
        new LendRecordOne(user).setVisible(true);
    }
}
