package com.cdu.hw.model;

public class Course {
    private int id;
    private String cpid;
    private String cname;
    private int num;
    private int snum;
    private String jiaoshi;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCpid() {
        return cpid;
    }
    public void setCpid(String cpid) {
        this.cpid = cpid;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getSnum() {
        return snum;
    }
    public void setSnum(int snum) {
        this.snum = snum;
    }
    public String getJiaoshi() {
        return jiaoshi;
    }
    public void setJiaoshi(String jiaoshi) {
        this.jiaoshi = jiaoshi;
    }
    public Course() {}
    public Course(int id, String cpid, String cname, int num, int snum, String jiaoshi) {
        this.id=id;
        this.cpid=cpid;
        this.cname=cname;
        this.num=num;
        this.snum=snum;
        this.jiaoshi=jiaoshi;
    }
    public Course(String cpid, String cname, int num, int snum, String jiaoshi) {
        this.cpid=cpid;
        this.cname=cname;
        this.num=num;
        this.snum=snum;
        this.jiaoshi=jiaoshi;
    }
}