package com.cdu.hw.model;

public class Teacher {

    private int id;
    private String tpid;
    private String teaname;
    private String sex;
    private String txueyuan;
    private String zhicheng;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTpid() {
        return tpid;
    }
    public void setTpid(String tpid) {
        this.tpid = tpid;
    }
    public String getTeaname() {
        return teaname;
    }
    public void setTeaname(String teaname) {
        this.teaname = teaname;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getTxueyuan() {
        return txueyuan;
    }
    public void setTxueyuan(String txueyuan) {
        this.txueyuan = txueyuan;
    }
    public String getZhicheng() {
        return zhicheng;
    }
    public void setZhicheng(String zhicheng) {
        this.zhicheng = zhicheng;
    }
    public Teacher() { }
    public Teacher(int id,String tpid,String teaname,String sex,String txueyuan,String zhicheng) {
        this.id=id;
        this.tpid=tpid;
        this.teaname=teaname;
        this.sex=sex;
        this.txueyuan=txueyuan;
        this.zhicheng=zhicheng;
    }
    public Teacher(String tpid,String teaname,String sex,String txueyuan,String zhicheng) {
        this.tpid=tpid;
        this.teaname=teaname;
        this.sex=sex;
        this.txueyuan=txueyuan;
        this.zhicheng=zhicheng;
    }
}