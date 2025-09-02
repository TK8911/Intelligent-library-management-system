package dao;

import entity.User;

import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class userDao extends BaseDao {
    //登录
    public boolean login(String username, String password) {
        String sql = "select*from users where username=? and password=?";
        List<Object[]> list = super.query(sql, username, password);
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }
    //显示信息
    public User get(String username){
        String sql="select*from users where username=?";
        Object user=super.queryOne(sql,User.class,username);
        return (User) user;
    }
    //修改信息
    public boolean update1(User user){
        String sql="update users set email=?,introduction=?" +
                "where username=?";
        Object[] params={user.getEmail(),user.getIntroduction(),user.getUsername()};
        return super.update(sql,params)>0;
    }
    //修改密码
    public boolean update2(User user){
        String sql="update users set password=? " +
                "where username=?";
        Object[] params={user.getPassword(),user.getUsername()};
        return super.update(sql,params)>0;
    }

    //个人借阅查询
    public Vector<Vector<Object>> borrow2(int user){
        String sql="select bookid,bookname,borrowtime,returntime,status from borrowrecords where userid = ?";
        Vector<Vector<Object>> data=new Vector<>();
        List<Object[]> list=super.query(sql,user);
        for(Object[] borrow:list){
            Vector<Object> rows=new Vector<>(Arrays.asList(borrow));
            data.add(rows);
        }
        return data;
    }

    //公告
    public Vector<Vector<Object>> shownt(){
        String sql="select * from notice";
        Vector<Vector<Object>> data=new Vector<>();
        List<Object[]> list=super.query(sql);
        for(Object[] notice:list){
            Vector<Object> rows=new Vector<>(Arrays.asList(notice));
            data.add(rows);
        }
        return data;
    }

    //显示信息
    public User ins(int id){
        String sql="SELECT id,username,registerDate, birthday," +
                "DATEDIFF(CURDATE(), registerDate) AS reg_ins," +
                "TIMESTAMPDIFF(YEAR, birthday, CURDATE()) AS age " +
                "FROM users where id=?";
        Object user=super.queryOne(sql,User.class,id);
        return (User) user;
    }
    public User ins2(int id){
        String sql="SELECT count(*) as borR FROM borrowrecords where userid=?";
        Object user=super.queryOne(sql,User.class,id);
        return (User) user;
    }

}
