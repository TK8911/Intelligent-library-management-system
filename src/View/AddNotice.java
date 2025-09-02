package View;

import dao.admindao;
import entity.Polish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

public class AddNotice extends View.base {
    //构造方法
    AddNotice(){
        initFrame();
        initComp();
    }
    private JTextArea field2 = new JTextArea(24,10);
    private Label l1=new Label("输入公告");
    private Button b1=new Button("确认发布");
    //初始化组件
    private void initComp() {
        field2.setEditable(true);
        field2.setLineWrap(true);
        //JScrollPane scrollPane = new JScrollPane(field2);
        l1.setFont(font1);
        field2.setFont(font3);
        b1.setFont(font2);
        b1.setSize(dimension2);
        l1.setBounds(30,20,100,40);
        field2.setBounds(30,70,490,230);
        b1.setBounds(410,310,100,50);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //得到数据
                String noti = field2.getText();
                LocalDate d = LocalDate.now();
                Date now = Date.valueOf(d);
                //封装数据
                Polish p = new Polish();
                p.setNotice(noti);
                p.setNdate(now);
                //检验
                admindao a = new admindao();
                boolean isok = a.addn(p);
                if (isok) {
                    JOptionPane.showMessageDialog(null, "发布成功！", "恭喜", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "发布失败，请重新尝试！", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
    //初始化窗口
    public void initFrame() {
        setSize(560,420);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        //窗口标题
        setTitle("发布公告");
        //加入窗口
        add(field2);
        add(l1);
        add(b1);
    }
    public static void main(String[] args) {
        //实例化并显示窗口
        new AddNotice().setVisible(true);
    }
}
