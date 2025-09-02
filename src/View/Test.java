package View;

import cn.com.zcp.util.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;


public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Date Chooser Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JDateChooser dateChooser =JDateChooser.getInstance("yyyy-MM-dd");
        JTextField field2 = new JTextField(18);
        field2.setBounds(0,0,100,20);
        dateChooser.register(field2);

        Button b=new Button("yes");
        b.setBounds(0,50,20,20);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input =field2.getText();
                System.out.print(DateUtil.toDate(input));
            }
        });
        frame.add(b);
        frame.add(field2);
        frame.add(dateChooser);
        frame.setVisible(true);
    }
}

/*String input = "2009 08 07";
        //field2.setText(input);

        JFrame frame = new JFrame("Date Chooser Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JDateChooser dateChooser =JDateChooser.getInstance("yyyy-MM-dd");
        JTextField field2 = new JTextField(18);
        field2.setBounds(0,0,100,20);
        dateChooser.register(field2);

        Button b=new Button("yes");
        b.setBounds(0,50,20,20);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input =field2.getText();
                System.out.print(DateUtil.toDate(input));
            }
        });
        frame.add(b);
        frame.add(field2);
        frame.add(dateChooser);
        frame.setVisible(true);*/

