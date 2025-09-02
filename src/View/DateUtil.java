package View;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static Date toDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            //LocalDate date = LocalDate.parse(dateStr, formatter);
            Date date1= java.sql.Date.valueOf(dateStr);
            LocalDate date=date1.toLocalDate();
            System.out.println("�����������: " + date);
            return date1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("�����ַ�����ʽ����ȷ���޷�����Ϊ���ڶ���");
            return null;
        }
    }
}
