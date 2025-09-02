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
        frame.setTitle("Demo01"); // 设置窗口标题
        frame.setSize(700,500); // 设置窗口显示大小

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel1 = new JPanel();
        tabbedPane.addTab("活动", panel1);
        JPanel panel2 = new JPanel();
        tabbedPane.addTab("公告", panel2);
        tabbedPane.setFocusable(false);
        frame.add(tabbedPane);
        //
        Font font = new Font("宋体", Font.BOLD, 23);
        Font font1 = new Font("宋体", Font.PLAIN, 15);
        //布置面板1
        panel1.setLayout(null);
        ImageIcon im = new ImageIcon("img\\11.jpg");
        JLabel Label = new JLabel(im);
        Label.setBounds(20,20,290,380);
        im.setImage(im.getImage().getScaledInstance(Label.getWidth(),Label.getHeight(), Image.SCALE_DEFAULT));
        panel1.add(Label);
        JLabel title=new JLabel("“悦读一夏”读书活动公告");
        JTextArea activity = new JTextArea(42, 30);
        activity.setText("    活动内容：炎炎夏日，让阅读成为最清凉的慰藉。图书馆诚邀您参与“悦读一夏”读书活动，活动期间，我们将推出精选书单，涵盖文学、科普、历史等多个领域，更有线上读书会、作者见面会等精彩环节，让您在书海中遨游，与智者对话，享受阅读带来的乐趣与成长。参与活动的读者还有机会赢取精美图书及文创礼品哦！"
                +"                               "
                + "活动时间：即日起至8月31日，每周二至周日的9:00-17:00，期待您的加入，共赴这场知识与灵魂的盛宴！");
        activity.setLineWrap(true);
        activity.setEditable(false);
        title.setFont(font);
        title.setBounds(340,25,400,30);
        activity.setFont(font1);
        activity.setBounds(350,65,300,320);
        panel1.add(title);
        panel1.add(activity);

        //布置面板2
        panel2.setLayout(null);
       String[] h={"编号","   内        容   ","发布时间"};
        Vector<String> header=new Vector<>(Arrays.asList(h));
        userDao u=new userDao();
        Vector<Vector<Object>> data=u.shownt();
        JTable dataTbl=new JTable(data,header);
        JScrollPane jScrollPane = new JScrollPane(dataTbl);
        jScrollPane.setBounds(30, 15, 600, 400);
        panel2.add(jScrollPane);
        //设置列距
        TableColumnModel columnModel = dataTbl.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(450);
        columnModel.getColumn(2).setPreferredWidth(100);

        DefaultTableModel model=(DefaultTableModel) dataTbl.getModel();
        model.setDataVector(data,header);
        // 设置表格的行宽
        dataTbl.setRowHeight(25);
        // 设置表格行中字体大小
        dataTbl.setFont(new Font("宋体", Font.PLAIN, 15));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口默认关闭操作
        frame.setLocationRelativeTo(null); // 相对屏幕居中
        frame.setVisible(true); // 设置窗口可见
        frame.setResizable(false); // 禁止用户调整窗口大小
    }
}
