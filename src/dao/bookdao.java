package dao;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class bookdao extends BaseDao{
    // 显示所有图书
    public Vector<Vector<Object>> bookAll(){
        String sql= "select id,type, name, author, publish, status from booktbl";
        Vector<Vector<Object>> data=new Vector<>();
        List<Object[]> list=super.query(sql);
        for(Object[] book:list){
            Vector<Object> rows=new Vector<>(Arrays.asList(book));
            data.add(rows);
        }
        return data;
    }
    //表：根据类别查找书籍
    public Vector<Vector<Object>> bookT(String type){
        String sql="select id,type, name, author, publish, status " +
                "from booktbl where type like ?";
        Vector<Vector<Object>> data=new Vector<>();
        List<Object[]> list=super.query(sql,type);
        for(Object[] book:list){
            Vector<Object> rows=new Vector<>(Arrays.asList(book));
            data.add(rows);
        }
        return data;
    }
    // 表：按书名查找图书
    public Vector<Vector<Object>> bookN(String name){
        String sql="select id,type,name,author,publish,status " +
                "from booktbl where name like ?";
        Vector<Vector<Object>> data=new Vector<>();
        List<Object[]> list=super.query(sql,name);
        for(Object[] book:list){
            Vector<Object> rows=new Vector<>(Arrays.asList(book));
            data.add(rows);
        }
        return data;
    }
    // 表：按作者查找图书
    public Vector<Vector<Object>> bookA(String author){
        String sql="select id,type,name,author,publish,status " +
                "from booktbl where author like ?";
        Vector<Vector<Object>> data=new Vector<>();
        List<Object[]> list=super.query(sql,author);
        for(Object[] book:list){
            Vector<Object> rows=new Vector<>(Arrays.asList(book));
            data.add(rows);
        }
        return data;
    }
    // 表：按书号查找图书
    public Vector<Vector<Object>> bookI(int id){
        String sql="select id,type,name,author,publish,status " +
                "from booktbl where id=?";
        Vector<Vector<Object>> data=new Vector<>();
        List<Object[]> list=super.query(sql,id);
        for(Object[] book:list){
            Vector<Object> rows=new Vector<>(Arrays.asList(book));
            data.add(rows);
        }
        return data;
    }
}
