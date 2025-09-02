package dao;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class bookdao extends BaseDao{
    // ��ʾ����ͼ��
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
    //�������������鼮
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
    // ������������ͼ��
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
    // �������߲���ͼ��
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
    // ������Ų���ͼ��
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
