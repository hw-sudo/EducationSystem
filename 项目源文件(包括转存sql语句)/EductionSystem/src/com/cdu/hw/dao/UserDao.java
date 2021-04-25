package com.cdu.hw.dao;

import com.cdu.hw.model.Student;
import com.cdu.hw.model.Teacher;

public interface UserDao {

    public int searchPid(String username,String password);
    public boolean addtea(Teacher teacher);
    public boolean adduser(String tpid,String password,int pid);
    public boolean addstu(Student student);
    public boolean delstu(String spid);
    public boolean deluser(String username);
    public boolean delstuAndcou(String spid,String cpid);
    public  String searchteaname(String tpid);
    public boolean updatetea(Teacher teacher);
    public boolean updatestu(Student student);
    public String searchtpid(String jiaoshi);
    public Student searchstu(String spid);
}
