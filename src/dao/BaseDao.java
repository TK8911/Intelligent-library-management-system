package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class BaseDao {
        private String driver = "com.mysql.cj.jdbc.Driver";
        private String url = "jdbc:mysql://localhost/hj1?serverTimezone=Asia/Shanghai";
        protected String username = "root";
        protected String password = "BNU0021l";

        private QueryRunner qr;
        protected Connection conn;
        protected PreparedStatement pst;
        protected ResultSet rst;

        public BaseDao() {
    }

    //创建连接
    public Connection getConnection() {
        try {
            if (this.conn == null || this.conn.isClosed()) {
                this.loadConfig();
                Class.forName(driver);
                this.conn = DriverManager.getConnection(url,username,password);
            }
            if (this.qr == null) {
                this.qr = new QueryRunner();
            }
        } catch (Exception var2) {
            Exception e = var2;
            e.printStackTrace();
        }
        return this.conn;
    }
    //数据库参数调整
        public void loadConfig() {
            InputStream is = this.getClass().getResourceAsStream("/db.properties");
            if (is == null) {
                throw new RuntimeException("Not found file:db.properties!");
            } else {
                Properties p = new Properties();
                try {
                    p.load(is);
                    driver = p.getProperty("driver");
                    url = p.getProperty("url");
                    username = p.getProperty("username");
                    password = p.getProperty("password");
                } catch (IOException var4) {
                    IOException e = var4;
                    e.printStackTrace();
                }
            }
        }
        //关闭连接
        public void close() {
            SQLException e;
            if (this.rst!= null) {
                try {
                    this.rst.close();
                    this.rst = null;
                } catch (SQLException var4) {
                    e = var4;
                    e.printStackTrace();
                }
            }
            if (this.pst!= null) {
                try {
                    this.pst.close();
                    this.pst = null;
                } catch (SQLException var3) {
                    e = var3;
                    e.printStackTrace();
                }
            }
        }

        //更新
    public int update (String sql, Object...param) {
        System.out.print(">>SQL:=" + sql);
        System.out.println("Param:" + Arrays.toString(param));
        this.conn = this.getConnection();

        try {
            int var5 = this.qr.update(this.conn,sql, param);
            return var5;
        }catch (SQLException var8){
            SQLException e = var8;
            e.printStackTrace();
        }finally {
            this.close();
        }
        return -1;
    }
    //返回一个列表，用于表格显示，在具体Dao里编写的时候结合for语句写新的方法使用
        public <T> List<T> query(String sql,Class<T> cls,Object... param) {
            System.out.println(">>>>>sql:" + sql);
            System.out.println(">>>>data:" + Arrays.toString(param));
            this.conn = this.getConnection();
            try {
                BeanListHandler<T> rsh = new BeanListHandler(cls);
                List<T> list = (List) this.qr.query(this.conn, sql, rsh,param);
                List var7 = list;
                return var7;
            } catch (SQLException var10) {
                SQLException e = var10;
                e.printStackTrace();
            } finally {
                this.close();
            }
            return null;
        }
        //返回一个查询结果的对象，用于非表格呈现的单条件查询（显示在文字框里（P34）
    public <T> Object queryOne(String sql, Class<T> cls, Object...param){
        System.out.println(">>>>>sql: " + sql);
        System.out.println( ">>>>data: " + Arrays.toString(param));
        this.conn = this.getConnection();
        try {
            BeanHandler<T> rsh = new BeanHandler<>(cls);
            T o = this.qr.query(this.conn,sql, rsh, param);
            Object var7 = o;
            return (T) var7;
        }catch (SQLException var10) {
            SQLException e = var10;
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }
    //联合查询
        public Long queryCount(String sql, Object... param) {
            System.out.println(">>>>>sql:" + sql);
            System.out.println(">>>>data: " + Arrays.toString(param));
            this.conn = this.getConnection();
            try {
                ScalarHandler<Long> sc = new ScalarHandler();
                Long var5 = (Long) this.qr.query(this.conn,sql,sc,param);
                return var5;
            }catch (SQLException var8) {
                SQLException e = var8;
                e.printStackTrace();
            }finally {
                this.close();
            }
            return null;
        }
        //返回在表格里的单条件查询
    public List<Object[]> query(String sql,Object...param) {
        System.out.println(">>>>>sql: " + sql);
        System.out.println( ">>>>data: " + Arrays.toString(param));
        this.conn = this.getConnection();
        try {
            ArrayListHandler alh = new ArrayListHandler();
            List<Object[]> list = (List) this.qr.query(this.conn,sql,alh,param);
                    List var6 = list;
            return var6;
        }catch (SQLException var9) {
            SQLException e = var9;
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }
    public static void main (String[] args){
        }
}









