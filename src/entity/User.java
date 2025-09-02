package entity;

import java.sql.Date;

public class User {
    private int id,sex;
    private String username,password,email,introduction;
    private Date birthday,registerDate;

    //用户信息
    private  String reg_ins,age,borR;
    public String getReg_ins() {
        return reg_ins;
    }
    public void setReg_ins(String reg_ins) {
        this.reg_ins = reg_ins;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getBorR() {
        return borR;
    }
    public void setBorR(String borR) {
        this.borR = borR;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    //public void setBirthday(LocalDate birthday) {this.birthday = birthday;}
    //public void setRegisterDate(LocalDate registerDate) {this.registerDate = registerDate;}
    // public LocalDate getBirthday() {return birthday;}
    //public LocalDate getRegisterDate() {return registerDate;}

    public int getId() {
        return id;
    }

    public int getSex() {
        return sex;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getIntroduction() {return introduction;}

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
