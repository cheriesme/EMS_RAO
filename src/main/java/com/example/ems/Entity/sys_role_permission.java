package com.example.ems.Entity;

import java.util.Date;

public class sys_role_permission extends sys_role_permissionKey {
    private String operator;

    private String operateip;

    private Date operatetime;

    public sys_role_permission(Integer roleid, Integer permissionid, String operator, String operateip, Date operatetime) {
        super(roleid, permissionid);
        this.operator = operator;
        this.operateip = operateip;
        this.operatetime = operatetime;
    }

    public sys_role_permission() {
        super();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getOperateip() {
        return operateip;
    }

    public void setOperateip(String operateip) {
        this.operateip = operateip == null ? null : operateip.trim();
    }

    public Date getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }
}