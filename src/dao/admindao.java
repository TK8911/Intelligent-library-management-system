package dao;

import entity.Book;
import entity.Lend;
import entity.Polish;
import entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class admindao extends BaseDao{
    //登录
    public boolean login(String username, String password) {
        String sql = "select*from admins where aname=? and apassword=?";
        List<Object[]> list = super.query(sql, username, password);
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }
    //用户注册
    public boolean add(User user){
        String sql="insert into users (username, password, sex, birthday, email, registerDate) " +
                "value(?,?,?,?,?,?)";
        Object[] params={user.getUsername(),user.getPassword(),user.getSex(),user.getBirthday(),user.getEmail(),user.getRegisterDate()};
        int rows=super.update(sql,params);
        return rows>0;
    }
    //添加书籍
    public boolean addB(Book book){
        String sql="insert into booktbl(type,name,author,publish,status) " +
                "value(?,?,?,?,?)";
        Object[] params={book.getType(),book.getName(),book.getAuthor(),book.getPublish(),book.getStatus()};
        int rows=super.update(sql,params);
        return rows>0;
    }
    //添加公告
    public boolean addn(Polish p){
        String sql="INSERT INTO notice (notice, fab_date) " +
                "VALUES(?,?)";
        Object[] params={p.getNotice(),p.getAname()};
        int rows=super.update(sql,params);
        return rows>0;
    }
    //根据id查找书籍
    public Book get(int id){
        String sql="select * from booktbl where id=?";
        Book b= (Book) super.queryOne(sql,Book.class,id);
        return b;
    }
    //修改书籍信息
    public boolean update(Book book){
        String sql="update booktbl set type=?,name=?,author=?,publish=?,status=? " +
                "where id=?";
        Object[] params={book.getType(),book.getName(),book.getAuthor(),book.getPublish(),book.getStatus(),book.getId()};
        return super.update(sql,params)>0;
    }
    //根据id删除书籍
    public boolean del(int id){
        String sql="delete from booktbl where id=?";
        return super.update(sql,id)>0;
    }
    //动态下拉框
    public Vector<String> type(){
        Vector<String> v=new Vector<>();
        String sql="select*from types";
        List<Object[]> list=super.query(sql);
        v.add("-请选择种类-");
        for (Object[] type:list){
            v.add(type[1]+"");
        }
        return v;
    }

    //借阅记录：联合查询
    public Vector<Vector<Object>> searchall(Lend lend){
        String sql="select userid, bookid, bookname, borrowtime, returntime, status,username" +
                " from borrowrecords where 1=1 ";
        List<Object> params=new ArrayList<>();
        Vector<Vector<Object>> data=new Vector<>();
        if(lend.getBookname()!= null &&!"".equals(lend.getBookname())){
            sql+=" and bookname like ?";
            params.add("%"+lend.getBookname()+"%");
        }
        if(lend.getUsername()!= null &&!"".equals(lend.getUsername())){
            sql+=" and username like ?";
            params.add("%"+lend.getUsername()+"%");
        }
        if(lend.getMonth()!= null &&!"".equals(lend.getMonth())){
            sql+=" and month(borrowtime)= ?";
            params.add(lend.getMonth());
        }
        if(lend.getYear()!= null &&!"".equals(lend.getYear())){
            sql+=" and year(borrowtime)= ?";
            params.add(lend.getYear());
        }

        List<Object[]> list =super.query(sql,params.toArray());
        for(Object[] lr : list){
            Vector<Object> rows=new Vector<>(Arrays.asList(lr));
            data.add(rows);
        }
        return data;
    }
}
