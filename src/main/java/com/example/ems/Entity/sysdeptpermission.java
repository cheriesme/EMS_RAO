package com.example.ems.Entity;

import java.util.Date;

public class sysdeptpermission {
    private Integer deptid;

    private Integer permissionid;

    private String operator;

    private Date operateTime;

    private String operateIp;

    public sysdeptpermission(Integer deptid, Integer permissionid, String operator, Date operateTime, String operateIp) {
        this.deptid = deptid;
        this.permissionid = permissionid;
        this.operator = operator;
        this.operateTime = operateTime;
        this.operateIp = operateIp;
    }

    public sysdeptpermission() {
        super();
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }
}