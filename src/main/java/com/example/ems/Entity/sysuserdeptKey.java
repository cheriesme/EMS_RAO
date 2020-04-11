package com.example.ems.Entity;

public class sysuserdeptKey {
    private Integer uid;

    private Integer deptid;

    public sysuserdeptKey(Integer uid, Integer deptid) {
        this.uid = uid;
        this.deptid = deptid;
    }

    public sysuserdeptKey() {
        super();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }
}