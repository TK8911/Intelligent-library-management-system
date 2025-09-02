package View;


import dao.admindao;
import dao.userDao;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

public class Notice extends base {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Demo01"); // ���ô��ڱ���
        frame.setSize(700,500); // ���ô�����ʾ��С

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel1 = new JPanel();
        tabbedPane.addTab("�", panel1);
        JPanel panel2 = new JPanel();
        tabbedPane.addTab("����", panel2);
        tabbedPane.setFocusable(false);
        frame.add(tabbedPane);
        //
        Font font = new Font("����", Font.BOLD, 23);
        Font font1 = new Font("����", Font.PLAIN, 15);
        //�������1
        panel1.setLayout(null);
        ImageIcon im = new ImageIcon("img\\11.jpg");
        JLabel Label = new JLabel(im);
        Label.setBounds(20,20,290,380);
        im.setImage(im.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(), Image.SCALE_DEFAULT));
        panel1.add(Label);
        JLabel title=new JLabel("���ö�һ�ġ���������");
        JTextArea activity = new JTextArea(42, 30);
        activity.setText("    ����ݣ��������գ����Ķ���Ϊ��������ο�塣ͼ��ݳ��������롰�ö�һ�ġ���������ڼ䣬���ǽ��Ƴ���ѡ�鵥��������ѧ�����ա���ʷ�ȶ�����򣬸������϶���ᡢ���߼����Ⱦ��ʻ��ڣ��������麣�����Σ������߶Ի��������Ķ���������Ȥ��ɳ��������Ķ��߻��л���Ӯȡ����ͼ�鼰�Ĵ���ƷŶ��"
                +"                               "
                + "�ʱ�䣺��������8��31�գ�ÿ�ܶ������յ�9:00-17:00���ڴ����ļ��룬�����ⳡ֪ʶ������ʢ�磡");
        activity.setLineWrap(true);
        activity.setEditable(false);
        title.setFont(font);
        title.setBounds(340,25,400,30);
        activity.setFont(font1);
        activity.setBounds(350,65,300,320);
        panel1.add(title);
        panel1.add(activity);

        //�������2
        panel2.setLayout(null);
       String[] h={"���","   ��        ��   ","����ʱ��"};
        Vector<String> header=new Vector<>(Arrays.asList(h));
        userDao u=new userDao();
        Vector<Vector<Object>> data=u.shownt();
        JTable dataTbl=new JTable(data,header);
        JScrollPane jScrollPane = new JScrollPane(dataTbl);
        jScrollPane.setBounds(30, 15, 600, 400);
        panel2.add(jScrollPane);
        //�����о�
        TableColumnModel columnModel = dataTbl.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(450);
        columnModel.getColumn(2).setPreferredWidth(100);

        DefaultTableModel model=(DefaultTableModel) dataTbl.getModel();
        model.setDataVector(data,header);
        // ���ñ����п�
        dataTbl.setRowHeight(25);
        // ���ñ�����������С
        dataTbl.setFont(new Font("����", Font.PLAIN, 15));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô���Ĭ�Ϲرղ���
        frame.setLocationRelativeTo(null); // �����Ļ����
        frame.setVisible(true); // ���ô��ڿɼ�
        frame.setResizable(false); // ��ֹ�û��������ڴ�С
    }
}
