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
    //构造方法
    LendRecordOne(int user){
        initDataTable(user);
        initFrame();
    }
    // 面板
    private JPanel jPanel = new JPanel();
    //初始化窗口
    public void initFrame() {
        setSize(800,600);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        //窗口标题
        setTitle("图书管理系统");
        // 改变背景图片
        ImageIcon i = new ImageIcon("img\\2.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0,0,800,100);
        i.setImage(i.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(),Image.SCALE_DEFAULT));
        //加入窗口
        add(Label);
        add(jPanel);
    }
    public void initDataTable(int user) {
        //标签
        JLabel jLabel = new JLabel("借书记录");
        jLabel.setFont(font);
        jLabel.setBounds(315, 80, 400, 100);
        jPanel.add(jLabel);
        // 表格
        String[] h={"书籍编号","书 名","借书日期","还书日期","状态"};
        Vector<String> header=new Vector<>(Arrays.asList(h));
        //Vector data=new Vector();  置空
        //接收用户名
        userDao u=new userDao();
        //Vector data=new Vector();
        Vector data=u.borrow2(user);
        JTable dataTbl=new JTable(data,header);
        JScrollPane jScrollPane = new JScrollPane(dataTbl);
        jScrollPane.setBounds(80, 160, 640, 350);
        add(jScrollPane);
        System.out.print(header);  //检验报错调试用的
        DefaultTableModel model=(DefaultTableModel) dataTbl.getModel();
        model.setDataVector(data,header);
        System.out.print(data);
        // 设置表格的行宽
        dataTbl.setRowHeight(25);
        // 设置表格行中字体大小
        dataTbl.setFont(new Font("宋体", Font.ROMAN_BASELINE, 17));

        jPanel.setBounds(0, 0, 800, 200);
        jPanel.setOpaque(false);
        jPanel.setLayout(null);
        setTitle("借书记录");
        // 不可以改变窗体的大小
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
