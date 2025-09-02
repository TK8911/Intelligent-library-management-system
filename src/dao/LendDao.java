package dao;

import entity.Book;
import entity.Lend;

import java.time.LocalDate;

public class LendDao extends BaseDao{
    //����ʵ����
    public Book getB(int id){
        String sql="select * from booktbl where id=?";
        Object book=super.queryOne(sql,Book.class,id);
        return (Book) book;
    }
    //�޸��鼮״̬
    public boolean update1(Book b){
        String sql="update booktbl set status= ? " +
                "where id= ?";
        Object[] params={b.getStatus(),b.getId()};
        return super.update(sql,params)>0;
    }
    //�Ƚ��û�
    public Lend getL(int bid){
        String sql="select * from borrowrecords " +
                "where status='���' and returntime IS NULL and bookid= ?";
        Object l=super.queryOne(sql,Lend.class,bid);
        return (Lend) l;
    }
    //�޸�BR
    public boolean update2(Lend l){
        String sql="update borrowrecords set status=?,returntime=?" +
                "where id= ?";
        Object[] params={l.getStatus(),l.getBackDate(),l.getId()};
        return super.update(sql,params)>0;
    }
    //��ӽ��ļ�¼
    public boolean addR(Lend lend){
        LocalDate d=LocalDate.now();
        String sql="insert into borrowrecords(userid,bookid,bookname,borrowtime,returntime,status) " +
                " values (?,?,?,?,null,?)";
        Object[] params={lend.getUserid(),lend.getBookId(),lend.getBookname(),d,lend.getStatus()};
        int rows=super.update(sql,params);
        return rows>0;
    }
}
